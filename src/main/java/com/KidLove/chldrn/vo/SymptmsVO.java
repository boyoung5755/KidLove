package com.KidLove.chldrn.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 증상
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SymptmsVO {

	private String symptmsDtl;            			// 증상상세
	private String symptmsNm;             			// 증상명
	private Integer symptmsNo;            			// 질병번호
	
	//1:N
	private List<ChldrnSymptmsVO> chldrnSymptmsList;

}
