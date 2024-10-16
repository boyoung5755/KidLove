package com.KidLove.chldrn.vo;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 체온
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BdHeatVO {

	
	private String atchCode;              			// 파일코드
	private String bdheatMemo;            			// 체온메모
	private Integer bdheatNo;             			// 체온번호
	private Double bdheatTp;              			// 측정온도
	private Integer chldrnNo;             			// 자녀번호
	private LocalDateTime crtDt;          			// 생성일

	//1:1
	private ChldrnVO chldrnUnity;

}
