/**
 * 
 */
package com.KidLove.comm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @packageName	: com.KidLove.comm.config
 * @since		: 2024.08.19
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.08.19		Boyoung			최초생성
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	public void addCorsMappings (CorsRegistry registry) {
		registry.addMapping("/**")
		.maxAge(500)    //응답의 캐시시간
		.allowedOrigins("*")   //모든도메인요청 허용
		.allowedMethods("GET","POST","PUT","DELETE"," HEAD", "OPTIONS");  //허용된 HTTP
	}
}
