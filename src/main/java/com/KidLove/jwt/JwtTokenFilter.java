/**
 * 
 */
package com.KidLove.jwt;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

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

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
	
	public static final String AUTHORIZATION_HEADER = "Authorization";
	public static final String BEARER_PREFIX = "Bearer ";
	
	private final TokenProvider tokenProvider;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String jwt = resolveToken(request);
		//String requestURI = httpServletRequest.getRequestURI();
		
		if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
	        Authentication authentication = tokenProvider.getAuthentication(jwt);
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	    }
	    filterChain.doFilter(request, response);
	}


	/**
	 * @MethodName	: resolveToken
	 * @author		: Boyoung
	 * @date 		: 2024.08.20
	 * @description	: request Header 에서 토큰 정보를 꺼내오기 위한 메소드
	 * @return 		: String
	 * @param request
	 * @return
	 */
	private String resolveToken(HttpServletRequest request) {
		
		String bearerToken  = request.getHeader(AUTHORIZATION_HEADER);
		
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
			return bearerToken.substring(BEARER_PREFIX.length()).trim();
		}
		return null;
	}

	

}
