/**
 * 
 */
package com.KidLove.jwt.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @packageName	: com.KidLove.jwt.vo
 * @since		: 2024.08.21
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.08.21		Boyoung			최초생성
 */

@Data
@Builder
@AllArgsConstructor
public class TokenVO {
	
	private String grantType;
	private String accessToken;
	private String refreshToken;
	private Long accessTokenExpiresIn;
}
