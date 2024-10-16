package com.KidLove.comm.vo;

import java.util.List;

import com.KidLove.chldrn.vo.ChldrnAllrgyVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 알레르기
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllrgyVO {
	
	private String allrgyNm;              			// 알레르기명
	private Integer allrgyNo;             			// 알러지번호
	private String allrgySymptms;         			// 증상
	private String allrgyTy;              			// 알레르기타입
	
	//1:1
	private ChldrnAllrgyVO chldrnAllrgyList;
		
	//1:N 
	private List<AllrgyCrsRespnsVO> allrgyCrsRespnsList;


}
