package com.KidLove.comm.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 알레르기 교차반응
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllrgyCrsRespnsVO {
	
	private Integer allrgyCrsRespnsNo;    			// 알레르기교차반응번호
	private Integer allrgyNo;             			// 알러지번호
	private String crsRespnsNm;           			// 교차반응항목
	private Integer crsRespnsRate;        			// 교차반응률
	private String crsRespnsTy;           			// 교차반응항목타입

	
	//1:1
	private AllrgyVO allrgyUnity;
}


