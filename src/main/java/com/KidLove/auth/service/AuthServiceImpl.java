/**
 * 
 */
package com.KidLove.auth.service;



import java.util.Arrays;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.KidLove.atch.dao.AtchDAO;
import com.KidLove.atch.service.AtchService;
import com.KidLove.atch.service.AtchServiceImpl;
import com.KidLove.atch.vo.AtchVO;
import com.KidLove.auth.dao.AuthDAO;
import com.KidLove.auth.vo.JoinVO;
import com.KidLove.auth.vo.LoginVO;
import com.KidLove.comm.FileTypeEnum;
import com.KidLove.comm.utils.RandomStringGenerator;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.jwt.TokenProvider;
import com.KidLove.jwt.vo.RefreshToken;
import com.KidLove.jwt.vo.TokenRequestVO;
import com.KidLove.jwt.vo.TokenVO;
import com.KidLove.mber.vo.MberVO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
	
	private final AuthenticationManagerBuilder authenticationManageBuilder;
	private final PasswordEncoder passwordEncoder;
	private final TokenProvider tokenProvider;
	private final RefreshToken refreshToken;
	
	@Inject
	private AuthDAO authDao;
	
	@Inject
	private AtchService atchService;
	
	/** 
	 * 최초 login 시 refresh토큰과 access토큰 발급
	 */
	@Transactional
	@Override
	public ResponseEntity<ResultVO<Object>> login(LoginVO loginRequest) {
		// TODO Auto-generated method stub
		
		// 1. Login ID/PW 를 기반으로 AuthenticationToken 생성
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getMberId(), loginRequest.getMberPw());

        // 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
        //    authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메서드가 실행됨
        Authentication authentication = authenticationManageBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenVO tokenVO = tokenProvider.generateTokenDto(authentication);
        
        
	     // 4. RefreshToken 저장 (데이터베이스)
        RefreshToken refreshToken = RefreshToken.builder()
                .key(authentication.getName())
                .value(tokenVO.getRefreshToken())
                .build();

        MberVO mberVO = MberVO.builder()
        		.mberId(loginRequest.getMberId())
        		.refreshToken(refreshToken.getValue())
        		.build();
        
        authDao.saveToken(mberVO);
        
        // 5. 토큰 발급
        return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",tokenVO));
	}

	
	
	/**
	 * 토큰으로 로그인시 유효기간 확인 및 재발급
	 */
	@Transactional
	@Override
	public ResponseEntity<ResultVO<Object>> reissue(TokenRequestVO tokenRequestDto ,HttpServletRequest request) {
		
		// 1. 쿠키에서 Refresh Token 값 확인
		
		String refreshTokenFromCookie  = Arrays.stream(request.getCookies())
		        .filter(cookie -> cookie.getName().equals("refreshToken")) 
		        .findFirst()
		        .map(Cookie::getValue)
		        .orElseThrow(() -> new RuntimeException("Refresh Token 쿠키가 존재하지 않습니다."));
		
		
		// 2. Refresh Token 검증
        if (!tokenProvider.validateToken(refreshTokenFromCookie)) {
            throw new RuntimeException("Refresh Token 이 유효하지 않습니다.");
        }

        // 3. Access Token 에서 Member ID 가져오기
        Authentication authentication = tokenProvider.getAuthentication(tokenRequestDto.getAccessToken());
        		
        String savedRefreshToken = authDao.findByKey(authentication.getName());
        
        // 4. Refresh Token 일치하는지 검사
        if (!savedRefreshToken.equals(refreshTokenFromCookie)) {
            throw new RuntimeException("토큰의 유저 정보가 일치하지 않습니다.");
        }

        // 5. 새로운 토큰 생성
        TokenVO tokenVO = null;
        if (tokenProvider.refreshTokenPeriodCheck(savedRefreshToken)) {
            // 5-1. Refresh Token의 유효기간이 3일 미만일 경우 전체(Access / Refresh) 재발급
        	tokenVO = tokenProvider.generateTokenDto(authentication);

            // 6. Refresh Token 저장 
            RefreshToken newRefreshToken = refreshToken.updateValue(tokenVO.getRefreshToken());
            
            MberVO mberVO = MberVO.builder()
            		.mberId(authentication.getName())
            		.refreshToken(newRefreshToken.getValue())
            		.build();
            authDao.saveToken(mberVO);
        	
        } else {
            // 5-2. Refresh Token의 유효기간이 3일 이상일 경우 Access Token만 재발급
        	tokenVO = tokenProvider.createAccessToken(authentication);
        }
        // 토큰 발급
        return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",tokenVO));
	}



	@Transactional
	@Override
	public ResponseEntity<ResultVO<Object>> signup(JoinVO joinRequest ,  MultipartFile file) {
		
		try {
			
			String makeFileCode = RandomStringGenerator.generateRandomString(15);
			String makeCnrsCode = RandomStringGenerator.generateRandomString(10);
			
			MberVO mberVO = MberVO.builder()
					.mberId(joinRequest.getMberId())
					.mberPw(passwordEncoder.encode(joinRequest.getMberPw()))
					.mberNcnm(joinRequest.getMberNcnm())
					.mberEml(joinRequest.getMberEml())
					.mberAddr(joinRequest.getMberAddr())
					.mberZip(joinRequest.getMberZip())
					.mberSttus(joinRequest.getMberSttus())
					.mberSexdstn(joinRequest.getMberSexdstn())
					.atchCode(makeFileCode)
					.cnrsCd(makeCnrsCode)
					.build();
			authDao.join(mberVO);
			
			
			AtchVO atchVO = AtchVO.builder()
					.atchCode(makeFileCode)
					.atchTy(FileTypeEnum.PROFILE)
					.build();
			atchService.saveFile(file, atchVO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",""));
	}
}
