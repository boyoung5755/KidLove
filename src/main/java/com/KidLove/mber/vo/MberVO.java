/**
 * 
 */
package com.KidLove.mber.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.EqualsAndHashCode;

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

@EqualsAndHashCode
@Data
public class MberVO {
	
	private Integer mberNo;
	private String mberId;
	private String mberPw;
	private String mberRole;

}
