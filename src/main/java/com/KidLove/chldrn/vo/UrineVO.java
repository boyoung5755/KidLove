package com.KidLove.chldrn.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 배뇨
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UrineVO {
	
	private String atchCode;              			// 파일코드
	private Long chldrnNo;             				// 자녀번호
	private LocalDateTime urineCrtDt;          		// 생성일
	private String urineColor;            			// 배뇨색상
	private String urineMemo;             			// 메모
	private Long urineNo;              				// 배뇨번호
	private String urineStle;             			// 물변,딱딱함,적당함
	private Integer urineTime;            			// 배뇨시간
	private String urineTy;               			// 배뇨타입 소변 ,대변 
	private Double urineWt;               			// 배뇨무게
	private String urineAmt;						// 배뇨양
	

	//1:1
	private ChldrnVO chldrn;


}
