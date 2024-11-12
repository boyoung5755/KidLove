/**
 * 
 */
package com.KidLove.comm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	private String connectPath = "/imagePath/**";
	
	@Value("${upload.path}")
	private String resourcePath;
	
	public void addCorsMappings (CorsRegistry registry) {
		registry.addMapping("/**")
		.maxAge(500)    //응답의 캐시시간
		.allowedOrigins("*")   //모든도메인요청 허용
		.allowedMethods("GET","POST","PUT","DELETE"," HEAD", "OPTIONS");  //허용된 HTTP
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(connectPath)
		        //윈도우일 경우에는 
		        .addResourceLocations("file:///"+resourcePath);
                //.addResourceLocations("file:"+resourcePath+"/");
    }
}
