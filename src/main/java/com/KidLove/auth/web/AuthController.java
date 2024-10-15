/**
 * 
 */
package com.KidLove.auth.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.KidLove.auth.service.AuthService;
import com.KidLove.auth.vo.JoinVO;
import com.KidLove.auth.vo.LoginVO;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.jwt.vo.TokenRequestVO;
import com.KidLove.jwt.vo.TokenVO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/authenticate")
@RequiredArgsConstructor
public class AuthController {
	
	
	
	@Inject
	private final AuthService authService;
	
	
	@PostMapping("/sign-with-kakao")
    public ResponseEntity<ResultVO<Object>> signWithKakao(@RequestBody JoinVO joinRequest) {
		try {
			ResponseEntity<ResultVO<Object>> result = authService.signWithKakao(joinRequest);
			return result;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(ResultVO.res(HttpStatus.BAD_REQUEST, "Failed to create user", ""));
		}
    }
	
	@PostMapping("/sign-with-google")
	public ResponseEntity<ResultVO<Object>> signWithGoogle(@RequestBody JoinVO joinRequest) {
		try {
			ResponseEntity<ResultVO<Object>> result = authService.signWithGoogle(joinRequest);
			return result;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(ResultVO.res(HttpStatus.BAD_REQUEST, "Failed to create user", ""));
		}
	}
	
	@PostMapping("/login-with-kakao")
    public ResponseEntity<ResultVO<Object>> loginWithKakao(Authentication authentication ,  HttpServletResponse response) {
		ResponseEntity<ResultVO<Object>> result = authService.loginWithKakao(authentication);
		TokenVO tokenVO = (TokenVO) result.getBody().getData();
		setHttpOnlyCookie(tokenVO.getRefreshToken(),response);
        return result;
    }
	
	@PostMapping("/login-with-google")
	public ResponseEntity<ResultVO<Object>> loginWithGoogle(Authentication authentication, HttpServletResponse response) {
		ResponseEntity<ResultVO<Object>> result =  authService.loginWithGoogle(authentication);
		TokenVO tokenVO = (TokenVO) result.getBody().getData();
		setHttpOnlyCookie(tokenVO.getRefreshToken(),response);
        return result;
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<ResultVO<Object>> login(@RequestBody LoginVO loginRequest ,  HttpServletResponse response ) {
		ResponseEntity<ResultVO<Object>> result   = authService.login(loginRequest);
		if (result.getBody().getResult().equals(HttpStatus.OK)){
			TokenVO tokenVO = (TokenVO) result.getBody().getData();
			setHttpOnlyCookie(tokenVO.getRefreshToken(),response);
		}else {
			return result;
		}
	    return result;
	}
	
	@PostMapping("/signup")
    public ResponseEntity<ResultVO<Object>> signup(
    		@RequestPart("Member") JoinVO joinRequest 
    		,@RequestPart(value = "file", required = false) MultipartFile file ) throws Exception{
		
		try {
			ResponseEntity<ResultVO<Object>> result = authService.signup(joinRequest,file);
			return result;
		} catch (Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST)
		                .body(ResultVO.res(HttpStatus.BAD_REQUEST, "Failed to create user", ""));
		}
	}
	

    @PostMapping("/reissue")
    public ResponseEntity<ResultVO<Object>> reissue(
    		@RequestHeader(value = "Authorization", required = false) String authorizationHeader,HttpServletRequest request,HttpServletResponse response) {
    	TokenRequestVO tokenRequestVO = new TokenRequestVO();
    	tokenRequestVO.setAccessToken(authorizationHeader.substring(7));
    	
    	ResponseEntity<ResultVO<Object>> result   = authService.reissue(tokenRequestVO , request);
    	
    	if (result.getBody().getData() instanceof TokenVO) {
    		TokenVO tokenVO = (TokenVO) result.getBody().getData();
    		  if (tokenVO.getRefreshToken() != null) {
    			  setHttpOnlyCookie(tokenRequestVO.getRefreshToken(),response);
    		  }
    	}
    	return result;
	}
    
	
    //HttpOnlyCookie 저장
    public void setHttpOnlyCookie (String setCookieWithRefreshToken ,HttpServletResponse response) {
    	Cookie cookie = new Cookie("refreshToken", setCookieWithRefreshToken);
    	cookie.setHttpOnly(true);
 	    cookie.setSecure(true);
 	    cookie.setPath("/");
 	    cookie.setMaxAge(7 * 24 * 60 * 60); //만료 7일
 	    
 	    response.addCookie(cookie);
    }

		
}
