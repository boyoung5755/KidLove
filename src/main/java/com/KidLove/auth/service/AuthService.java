/**
 * 
 */
package com.KidLove.auth.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import com.KidLove.auth.vo.JoinVO;
import com.KidLove.auth.vo.LoginVO;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.jwt.vo.TokenRequestVO;

import jakarta.servlet.http.HttpServletRequest;


public interface AuthService {

	public ResponseEntity<ResultVO<Object>> login(LoginVO loginRequest);

	public ResponseEntity<ResultVO<Object>> reissue(TokenRequestVO tokenRequestDto, HttpServletRequest request);

	public ResponseEntity<ResultVO<Object>> signup(JoinVO joinRequest ,  MultipartFile file);

	public ResponseEntity<ResultVO<Object>> loginWithKakao(Authentication authentication);

	public ResponseEntity<ResultVO<Object>> loginWithGoogle(Authentication authentication);

	public ResponseEntity<ResultVO<Object>> signWithKakao(JoinVO joinRequest);

	public ResponseEntity<ResultVO<Object>> signWithGoogle(JoinVO joinRequest);

	
	
	
	
	

}
