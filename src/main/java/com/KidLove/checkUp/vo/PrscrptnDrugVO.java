/**
 * 
 */
package com.KidLove.checkUp.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @packageName	: com.KidLove.checkUp.vo
 * @since		: 2024.11.12
 * @author		: Boyoung
 * @description	: 처방약
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.12		Boyoung			최초생성
 */

@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrscrptnDrugVO {
	
	
	private Long prscrptnDrugNo;       		// 
	private Long prscrptnNo;           		// 
	private String drugNm;                		// 
	private String drugUnit;              		// 
	private String drugAmount;            		// 
	private String drugPd;                		// 
	
	//1:1
	private PrscrptnVO prscrptn;
	

}
