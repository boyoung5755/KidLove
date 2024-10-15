/**
 * 
 */
package com.KidLove.auth.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.KidLove.atch.service.AtchService;
import com.KidLove.atch.vo.AtchVO;
import com.KidLove.auth.dao.AuthDAO;
import com.KidLove.auth.vo.JoinVO;
import com.KidLove.auth.vo.LoginVO;
import com.KidLove.comm.constant.FileTypeEnum;
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
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		try {
			
			// 1. Login ID/PW 를 기반으로 AuthenticationToken 생성
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getMberId(), loginRequest.getMberPw());
			
			// 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
			//    authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메서드가 실행됨
			Authentication authentication = null ;
			try {
				authentication = authenticationManageBuilder.getObject().authenticate(authenticationToken);
			} catch (Exception e) {
				return ResponseEntity.ok(ResultVO.res(HttpStatus.UNAUTHORIZED, "Password Error", ""));
			}
			
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
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.INTERNAL_SERVER_ERROR, "Failed Login", ""));
		}
		
        
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
					.mberLoginTy("EML")
					.build();
			authDao.join(mberVO);
			
			
			AtchVO atchVO = AtchVO.builder()
					.atchCode(makeFileCode)
					.atchTy(FileTypeEnum.PROFILE)
					.build();
			atchService.saveFile(file, atchVO);
			
			int mberNo = authDao.findMberNo(joinRequest.getMberId());
			authDao.setMberAuthor(mberNo,"GNRL");
			
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK, "success", ""));
		
		} catch (RuntimeException  e) {
			throw new RuntimeException("Failed to create user", e);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.INTERNAL_SERVER_ERROR, "Failed", ""));	
		}
	}

	@Override
	@Transactional
	public ResponseEntity<ResultVO<Object>> loginWithGoogle(Authentication authentication) {
		String loginId = authentication.getName();
		try {
			TokenVO tokenVO = tokenProvider.generateTokenDto(authentication);
			
			RefreshToken refreshToken = RefreshToken.builder()
					.key(authentication.getName())
					.value(tokenVO.getRefreshToken())
					.build();
						
			MberVO mberVO = MberVO.builder()
					.mberId(loginId)
					.refreshToken(refreshToken.getValue())
					.build();
			
			authDao.saveToken(mberVO);
			
			String loginUserId = authDao.loginWithGoogle(loginId);
			if (! loginUserId.isEmpty()) {
				return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"Success Login_"+loginUserId,tokenVO));
			}else {
				return ResponseEntity.ok(ResultVO.res(HttpStatus.NOT_FOUND, "User not found", ""));
			}
		} catch (RuntimeException  e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "Failed Created", ""));
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.INTERNAL_SERVER_ERROR, "Failed Login", ""));
		}	 
	}



	@Override
	@Transactional
	public ResponseEntity<ResultVO<Object>> loginWithKakao(Authentication authentication) {
		String loginId = authentication.getName();
		try {
			TokenVO tokenVO = tokenProvider.generateTokenDto(authentication);
						
			RefreshToken refreshToken = RefreshToken.builder()
					.key(authentication.getName())
					.value(tokenVO.getRefreshToken())
					.build();
						
			MberVO mberVO = MberVO.builder()
					.mberId(loginId)
					.refreshToken(refreshToken.getValue())
					.build();
			
			authDao.saveToken(mberVO);
			
			String loginUserId = authDao.loginWithKakao(loginId);
			
			if (! loginUserId.isEmpty()) {
				return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"Success Login_"+loginUserId,tokenVO));
			}else {
				return ResponseEntity.ok(ResultVO.res(HttpStatus.NOT_FOUND, "User not found", ""));
			}
		} catch (RuntimeException  e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "Failed Created", ""));	
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.INTERNAL_SERVER_ERROR, "Failed Login", ""));
		}
	}
	
	
	@Transactional
	@Override
	public ResponseEntity<ResultVO<Object>> signWithKakao(JoinVO joinRequest) {
		try {
			TokenVO tokenVO = createSSO(joinRequest , "KAKAO");
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",tokenVO));
		} catch (RuntimeException  e) {
			throw new RuntimeException("Failed to create user", e);
		}
	}

	
	@Transactional
	@Override
	public ResponseEntity<ResultVO<Object>> signWithGoogle(JoinVO joinRequest) {
		try {
			TokenVO tokenVO = createSSO(joinRequest , "GOOGLE");
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",tokenVO));
		} catch (RuntimeException  e) {
			log.error(e.toString());
			throw new RuntimeException("Failed to create user", e);
		}
	}
	
	
	public TokenVO createSSO( JoinVO joinRequest , String type) {
		String makeFileCode = RandomStringGenerator.generateRandomString(15);
		String makeCnrsCode = RandomStringGenerator.generateRandomString(10);
		
		MberVO mberVO = MberVO.builder()
				.mberId(joinRequest.getMberId())
				.atchCode(makeFileCode)
				.cnrsCd(makeCnrsCode)
				.mberLoginTy(type)
				.build();
		authDao.joinSSO(mberVO);
		
		int mberNo = authDao.findMberNo(joinRequest.getMberId());
		authDao.setMberAuthor(mberNo,"GNRL");
		
		List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_GNRL"));
		
		//토큰발급
		Authentication  authenticationToken = new UsernamePasswordAuthenticationToken(
				joinRequest.getMberId()
				, null
				,authorities
			);
		
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		
		TokenVO tokenVO = tokenProvider.generateTokenDto(authenticationToken);
		
		// 4. RefreshToken 저장 (데이터베이스)
		RefreshToken refreshToken = RefreshToken.builder()
				.key(authenticationToken.getName())
				.value(tokenVO.getRefreshToken())
				.build();
		
		MberVO newMber = MberVO.builder()
				.mberId(joinRequest.getMberId())
				.refreshToken(refreshToken.getValue())
				.build();
		
		authDao.saveToken(newMber);
		
		return tokenVO;
	}
}
