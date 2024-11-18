/**
 * 
 */
package com.KidLove.chldrn.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @packageName	: com.KidLove.chldrn.vo
 * @since		: 2024.11.18
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.18		Boyoung			최초생성
 */

@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SymptmsFrsaidVO {
	
	
	private Long symptmsFrsaidNo;
	private Long chldrnSymptmsNo;
	private LocalDateTime symptmsFrsaidCrtDt;
	private String frsaidCn;

}
