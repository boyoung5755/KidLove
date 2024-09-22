/**
 * 
 */
package com.KidLove.auth.vo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonCreator;

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


public class AuthVO  extends User implements UserDetails{
	
	
	private final String mberPw;
	private final String mberId;
	private final String mberRole;


	public AuthVO(String mberId, String mberPw, List<String> roleNames) {
		super(mberId, mberPw, 
				roleNames.stream().map(role -> 
					new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList()));
		this.mberId = mberId;
		this.mberPw = mberPw;
		this.mberRole = String.join(",", roleNames); // 역할을 문자열로 저장하거나 필요한 방식으로 변환
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return super.getAuthorities();
	}

	@Override
	public String getPassword() {
		return mberPw;
	}

	@Override
	public String getUsername() {
		return mberId;
	}
	
	public String getMberId() {
		return mberId;
	}
	
	public String getMberRole() {
		return mberRole;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
