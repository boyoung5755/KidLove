/**
 * 
 */
package com.KidLove.auth.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.auth.vo.LoginVO;
import com.KidLove.auth.vo.TokenVO;
import com.KidLove.comm.vo.ResultVO;

/**
 * @packageName	: com.KidLove.auth.web
 * @since		: 2024.08.19
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.08.19		Boyoung			최초생성
 */

@RestController
@RequestMapping("/authenticate")
public class AuthController {
	
	
	@Inject
	private UserDetailsService userDetailsService;

	
	@PostMapping
    public ResponseEntity<ResultVO<Object>> authorize(@RequestBody LoginVO loginVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 유효성 검사 오류가 있는 경우
            String errorMsg = bindingResult.getFieldErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(ResultVO.res(HttpStatus.BAD_REQUEST, errorMsg, null));
        }

        // 인증 토큰 생성
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginVO.getUsername(), loginVO.getPassword());

        try {
            // 사용자 인증
            Authentication authentication = userDetailsService
                .loadUserByUsername(loginVO.getUsername()) != null
                ? SecurityContextHolder.getContext().getAuthentication()
                : null;

            // 인증 실패 시 예외 처리
            if (authentication == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResultVO.res(HttpStatus.UNAUTHORIZED, "인증 실패", null));
            }

            // SecurityContextHolder에 인증 객체 설정
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // JWT 토큰 생성
            String jwt = tokenProvider.createToken(authentication);

            // 토큰 반환
            TokenVO tokenVO = new TokenVO();
            tokenVO.setToken(jwt);

            return ResponseEntity.ok(ResultVO.res(HttpStatus.OK, "로그인 성공", tokenVO));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResultVO.res(HttpStatus.INTERNAL_SERVER_ERROR, "로그인 처리 중 오류 발생", null));
        }
    }
}
