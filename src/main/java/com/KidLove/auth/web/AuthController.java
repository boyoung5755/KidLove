/**
 * 
 */
package com.KidLove.auth.web;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.auth.service.AuthService;
import com.KidLove.auth.vo.AuthVO;
import com.KidLove.auth.vo.LoginVO;
import com.KidLove.comm.vo.ResultVO;

import lombok.RequiredArgsConstructor;

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
@RequiredArgsConstructor
public class AuthController {
	
	@Inject
	private final AuthService authService;
	
	
	@PostMapping("/login")
	public ResponseEntity<ResultVO<Object>> login(@RequestBody LoginVO loginRequest) {
		return authService.login(loginRequest);
	}
	
	
	/*
	 @PostMapping("/signup")
	    public ResponseEntity<UserResponseDto> signup(@RequestBody JoinRequest joinRequest) {
	    return ResponseEntity.ok(authService.signup(joinRequest));
	}


    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
	    return ResponseEntity.ok(authService.reissue(tokenRequestDto));
	}
	*/

		
}
