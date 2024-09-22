/**
 * 
 */
package com.KidLove.auth.service;



import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KidLove.auth.dao.AuthDAO;
import com.KidLove.auth.vo.AuthVO;
import com.KidLove.auth.vo.LoginVO;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.jwt.TokenProvider;
import com.KidLove.jwt.vo.RefreshToken;
import com.KidLove.jwt.vo.TokenVO;
import com.KidLove.mber.vo.MberVO;

import lombok.RequiredArgsConstructor;

/**
 * @packageName	: com.KidLove.auth.service
 * @since		: 2024.08.19
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.08.19		Boyoung			최초생성
 */

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
	
	private final AuthenticationManagerBuilder authenticationManageBuilder;
	private final PasswordEncoder passwordEncoder;
	private final TokenProvider tokenProvider;
	private final RefreshToken refreshToken;
	
	
	@Inject
	private AuthDAO authDao;
	
	
	@Transactional
	public ResponseEntity<ResultVO<Object>> login(LoginVO loginRequest) {
		// TODO Auto-generated method stub
		
		// 1. Login ID/PW 를 기반으로 AuthenticationToken 생성
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getMberId(), loginRequest.getMberPw());

        // 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
        //    authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메서드가 실행됨
        Authentication authentication = authenticationManageBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenVO tokenVO = tokenProvider.generateTokenDto(authentication);

        // 4. RefreshToken 저장
        RefreshToken refreshToken = RefreshToken.builder()
                .key(authentication.getName())
                .value(tokenVO.getRefreshToken())
                .build();

        //refreshTokenRepository.save(refreshToken);
        

        // 5. 토큰 발급
        return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",tokenVO));
	}
	
	
	
	


	

}
