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


	private String resolveToken(HttpServletRequest request) {
		
		String bearerToken  = request.getHeader(AUTHORIZATION_HEADER);
		
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
			return bearerToken.substring(BEARER_PREFIX.length()).trim();
		}
		return null;
	}

	

}
