/**
 * 
 */
package com.KidLove.jwt.vo;

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
public class TokenRequestVO {
	
	private String accessToken;
	private String refreshToken;

}
 