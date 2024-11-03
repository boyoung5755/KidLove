/**
 * 
 */
package com.KidLove.babyNote.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @packageName	: com.KidLove.babyNote.vo
 * @since		: 2024.11.03
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.03	Boyoung			최초생성
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VacntnMthVO {
	
	private Long vacntnMthNo;
	private String vacntnNm;
	private String mthUseAt;

}
