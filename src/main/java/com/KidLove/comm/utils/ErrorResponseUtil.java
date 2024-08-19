/**
 * 
 */
package com.KidLove.comm.utils;

import java.io.IOException;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @packageName	: com.KidLove.comm.utils
 * @since		: 2024.08.19
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.08.19		Boyoung			최초생성
 */
public class ErrorResponseUtil {
	
	public static void setErrorResponse(HttpStatus status, HttpServletRequest request, HttpServletResponse response, String errorCode, String errorMessage) throws IOException {
        response.setStatus(status.value());
        response.setContentType("application/json; charset=UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(ResultMaps.json(errorCode, errorMessage));

        response.getWriter().write(json);
    }

}
