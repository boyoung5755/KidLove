package com.KidLove.comm.vo;

import com.KidLove.checkUp.vo.PrscrptnVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 약국
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParmacyVO {
	
	private String parmacyNm;             			// 약국명
	private Integer parmacyNo;            			// 약국번호
	
	//1:1
	private PrscrptnVO prscrptnUnity;

}
