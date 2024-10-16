package com.KidLove.chldrn.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 이유식
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BabyFDVO {
	
	private Integer babyFdNo;             			// 이유식번호
	private String fdNm;                  			// 이유식종류
	private String fdTy;                  			// 재료타입
	
	//1:1
	private MealVO mealUnity;
	
}
