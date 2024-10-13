/**
 * 
 */
package com.KidLove.jwt.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class TokenVO {
	
	private String grantType;
	private String accessToken;
	private String refreshToken;
	private Long accessTokenExpiresIn;
}
