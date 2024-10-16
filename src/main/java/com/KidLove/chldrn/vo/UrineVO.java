package com.KidLove.chldrn.vo;

import java.time.LocalDateTime;
import java.util.List;

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
public class UrineVO {
	
	private String atchCode;              			// 파일코드
	private Integer chldrnNo;             			// 자녀번호
	private LocalDateTime crtDt;          			// 생성일
	private String urineColor;            			// 배뇨색상
	private String urineMemo;             			// 메모
	private Integer urineNo;              			// 배뇨번호
	private String urineStle;             			// 1~7 대변형태척도
	private Integer urineTime;            			// 배뇨시간
	private String urineTy;               			// 배뇨타입
	private Double urineWt;               			// 배뇨무게

	//1:1
	private ChldrnVO chldrnUnity ;


}
