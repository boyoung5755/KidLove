package com.KidLove.chldrn.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.KidLove.mber.vo.MberVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 식사
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealVO {
	
	private String atchCode;              			// 파일코드
	private Integer babyFdNo;             			// 이유식번호
	private Integer chldrnNo;             			// 자녀번호
	private LocalDateTime crtDt;          			// 생성일(식사일)
	private Integer mealAmount;           			// 식사량
	private String mealMemo;              			// 식사메모
	private String mealMhrsmLc;           			// 모유위치
	private Integer mealNo;               			// PK
	private Integer mealTime;             			// 수유시간
	private String mealTy;                			// 식사타입
	private String mealUnit;              			// 식사량단위

	//1:1
	private ChldrnVO chldrnUnity;
	
	//1:N
	private List<BabyFDVO> babyFDList;

}
