/**
 * 
 */
package com.KidLove.auth.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

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

@Data
@AllArgsConstructor
@Builder
public class TokenVO {
	
	private String refreshToken;
	private String accessToken;
	private String mberId;
	private String mberRole;
	
}
