package com.KidLove.chldrn.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 자녀건강정보
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChldrnInfoVO {
	
	private Double chldrnBdwgh;           			// 몸무게
	private Double chldrnHead;            			// 머리둘레
	private String chldrnHearab;          			// 청력
	private Double chldrnHeight;          			// 키
	private Integer chldrnInfoNo;         			// 자녀건강정보
	private Integer chldrnNo;             			// 자녀번호
	private Double chldrnVspr;            			// 시력
	private LocalDateTime crtDt;          			// 측정일

	//1:1
	private ChldrnVO chidrnUnity;
	
	 
	
}
