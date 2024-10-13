/**
 * 
 */
package com.KidLove.jwt.vo;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


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
