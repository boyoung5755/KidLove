/**
 * 
 */
package com.KidLove.jwt;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.KidLove.comm.utils.ErrorResponseUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException {
		// 필요한 권한이 없이 접근하려 할때 403
		ErrorResponseUtil.setErrorResponse(HttpStatus.UNAUTHORIZED, request, response, "F", "허가되지 않은 권한입니다.");
	}

}
