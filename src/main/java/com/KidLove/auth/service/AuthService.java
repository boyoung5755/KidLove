/**
 * 
 */
package com.KidLove.auth.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.KidLove.auth.vo.JoinVO;
import com.KidLove.auth.vo.LoginVO;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.jwt.vo.TokenRequestVO;

import jakarta.servlet.http.HttpServletRequest;

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

public interface AuthService {

	public ResponseEntity<ResultVO<Object>> login(LoginVO loginRequest);

	public ResponseEntity<ResultVO<Object>> reissue(TokenRequestVO tokenRequestDto, HttpServletRequest request);

	public ResponseEntity<ResultVO<Object>> signup(JoinVO joinRequest ,  MultipartFile file);

	
	
	
	
	

}
