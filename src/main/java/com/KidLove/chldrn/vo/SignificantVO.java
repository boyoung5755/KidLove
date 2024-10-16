package com.KidLove.chldrn.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 자녀 특이사항
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignificantVO {
	
	private Integer chldrnNo;             			// 자녀번호
	private String significantMemo;       			// 특이사항
	private Integer significantNo;        			// 특이사항번호

	//1:1
	private ChldrnVO chidrnUnity;
		

}
