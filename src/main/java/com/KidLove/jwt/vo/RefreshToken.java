/**
 * 
 */
package com.KidLove.jwt.vo;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @packageName	: com.KidLove.jwt.vo
 * @since		: 2024.08.20
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.08.20		Boyoung			최초생성
 */

@NoArgsConstructor
@Getter
@Component
public class RefreshToken {
	
	private String key;
	private String value;
	
	@Builder
	public RefreshToken (String key , String value) {
		this.key = key;
		this.value = value;
	}
	
	public RefreshToken updateValue (String token) {
		this.value = token;
		return this;
	}

}
