/**
 * 
 */
package com.KidLove.jwt;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.KidLove.comm.utils.ErrorResponseUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @packageName	: com.KidLove.jwt
 * @since		: 2024.08.19
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.08.19		Boyoung			최초생성
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {

		// 유효한 자격증명을 제공하지 않고 접근하려 할때 401
		ErrorResponseUtil.setErrorResponse(HttpStatus.UNAUTHORIZED, request, response, "F", "유효한 자격 증명이 필요합니다.");
	}

}
