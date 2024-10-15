/**
 * 
 */
package com.KidLove.comm.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.KidLove.jwt.JwtAccessDeniedHandler;
import com.KidLove.jwt.JwtAuthenticationEntryPoint;
import com.KidLove.jwt.JwtTokenFilter;
import com.KidLove.jwt.TokenProvider;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	
	private final TokenProvider tokenProvider;
	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
	
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
		
		//CSRF, CORS
		http.csrf((csrf) -> csrf.disable()); //csrf 비활성
		http.cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource ()));
		
		//세션관리 상태 없음으로 구성  ->시큐리티가 세션을 만들지도 사용하지도 않음.
    	http.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(
    			SessionCreationPolicy.STATELESS));
    	
    	//FormLogin, BasicHttp 비활성화
    	http.formLogin((form) -> form.disable()); //폼 로그인 비활성
    	http.httpBasic(AbstractHttpConfigurer::disable); //HTTP 기본인증 비활성
    	
    	//권한 규칙 작성
    	http.authorizeHttpRequests(authorize -> authorize
    			.requestMatchers("/authenticate/**").permitAll()
    			.anyRequest().authenticated()
    		); 
    	
    	//jwt 필터추가
    	http.addFilterBefore(new JwtTokenFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class);
    	
    	//handler
    	http.exceptionHandling((exceptionHandling) -> exceptionHandling
    			.authenticationEntryPoint(jwtAuthenticationEntryPoint)
    			.accessDeniedHandler(jwtAccessDeniedHandler)
    			
    	);
    	
		return http.build();
	}
	
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		
		corsConfiguration.setAllowedOriginPatterns(List.of("*"));
	    corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
	    corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
	    corsConfiguration.setAllowCredentials(true);

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", corsConfiguration); // 모든 경로에 대해서 CORS 설정을 적용
		
		return source;
		
	}
	
}
