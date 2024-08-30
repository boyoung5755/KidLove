/**
 * 
 */
package com.KidLove.auth.web;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.jwt.TokenProvider;

/**
 * @packageName	: com.KidLove.auth.web
 * @since		: 2024.08.19
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.08.19		Boyoung			최초생성
 */

@RestController
@RequestMapping("/authenticate")
public class AuthController {
	
	
	@Inject
	private UserDetailsService userDetailsService;
	
	@Inject
	private TokenProvider tokenProvider;

	
}
