/**
 * 
 */
package com.KidLove.auth.vo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @packageName	: com.KidLove.auth.vo
 * @since		: 2024.08.19
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.08.19		Boyoung			최초생성
 */

public class LoginVO  extends User{
	
	public LoginVO (String mberId, String mberPw , List<String> roleNames) {
		super(mberId,mberPw, 
				roleNames.stream().map(str -> 
					new SimpleGrantedAuthority("ROLE"+str)).collect(Collectors.toList()));
	}
	
}
