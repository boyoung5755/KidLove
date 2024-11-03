/**
 * 
 */
package com.KidLove.chldrn.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @packageName	: com.KidLove.chldrn.vo
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
public class TakngVO {
	
	
	private Long takngNo;              			// 
	private Long chldrnNo;             			// 
	private LocalDateTime takngDt;        			// 복용시간
	private LocalDateTime takngCrtDt;          			 
	private LocalDateTime takngEnddt;     			// 복용종료시간
	private String takngMdcinNm;          			// 약이름
	private String takngMdcinTy;          			// 약타입
	private Integer takngMdcinAmt;        			// 복용량
	private String takngMdcinUnit;        			// 복용량 단위
	private String takngPd;               			// 복용기간
	private String takngMemo;             			// 복용메모

	
	//1:1
	private ChldrnVO chldrn;
}
