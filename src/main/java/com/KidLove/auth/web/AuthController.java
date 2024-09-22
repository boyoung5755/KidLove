/**
 * 
 */
package com.KidLove.auth.web;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.auth.service.AuthService;
import com.KidLove.auth.vo.LoginVO;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.jwt.vo.TokenRequestVO;
import com.KidLove.jwt.vo.TokenVO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

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
@RequiredArgsConstructor
public class AuthController {
	
	@Inject
	private final AuthService authService;
	
	
	@PostMapping("/login")
	public ResponseEntity<ResultVO<Object>> login(@RequestBody LoginVO loginRequest ,  HttpServletResponse response ) {
		
		ResponseEntity<ResultVO<Object>> result   = authService.login(loginRequest);
		
		TokenVO tokenVO = (TokenVO) result.getBody().getData();
		String setCookieWithRefreshToken = tokenVO.getRefreshToken();
		
		// HTTPOnly 쿠키에 저장
	    Cookie cookie = new Cookie("refreshToken", setCookieWithRefreshToken);
	    cookie.setHttpOnly(true);
	    cookie.setSecure(true);
	    cookie.setPath("/");
	    cookie.setMaxAge(7 * 24 * 60 * 60); //만료 7일
	    
	    response.addCookie(cookie);
		
	    return result;
	}
	
	/*
	 @PostMapping("/signup")
	    public ResponseEntity<UserResponseDto> signup(@RequestBody JoinRequest joinRequest) {
	    return ResponseEntity.ok(authService.signup(joinRequest));
	}
	*/


    @PostMapping("/reissue")
    public ResponseEntity<ResultVO<Object>> reissue(@RequestBody TokenRequestVO tokenRequestDto , HttpServletRequest request) {
	    return authService.reissue(tokenRequestDto , request);
	}
	

		
}
