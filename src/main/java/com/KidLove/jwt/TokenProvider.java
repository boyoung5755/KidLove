package com.KidLove.jwt;

import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.KidLove.jwt.vo.TokenVO;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

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

@Slf4j
@Component
public class TokenProvider  implements InitializingBean{
	
	private final Logger logger = LoggerFactory.getLogger(TokenProvider.class);
	private static final String AUTHORITIES_KEY = "auth";
	private static final String BEARER_TYPE = "Bearer";
	
	
	//Refresh Token의 만료기간이 3일 이내이면 Access Token과 Refresh Token을 클라이언트에 전달해주고, 
	//Refresh Token의 만료기간이 3일 이상이면, Access Token만 클라이언트에 전달
	private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 30;            // 30분
	private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7;  // 7일
	private static final long THREE_DAYS = 1000 * 60 * 60 * 24 * 3;  // 3일
	
	private final String secret;
	private final long tokenValidityInMilliseconds;
	
	private final Key key;
	
	public TokenProvider(@Value("${jwt.secret}") String secretKey) {
		
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		this.key = Keys.hmacShaKeyFor(keyBytes);
	}

	@Override
	public void afterPropertiesSet() {
		byte[] keyBytes = Decoders.BASE64.decode(secret);
		this.key = Keys.hmacShaKeyFor(keyBytes);
	}
	
	
	public TokenVO createAccessToken (Authentication authentication) {
		
		String authorities = authentication.getAuthorities().stream()
				.map(GrantedAuthority :: getAuthority)
				.collect(Collectors.joining(","));
		
		long now =(new Date().getTime());
	}
	

}
