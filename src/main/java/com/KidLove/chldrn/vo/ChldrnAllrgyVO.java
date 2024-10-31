package com.KidLove.chldrn.vo;

import java.util.List;

import com.KidLove.comm.vo.AllrgyVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 자녀 알레르기
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChldrnAllrgyVO {
	
	private Long allrgyNo;             				// 알러지번호
	private Long chldrnAllrgyNo;       			// 자녀알레르기번호
	private Long chldrnNo;             			// 자녀번호

	//1:1
	private ChldrnVO chidrnUnity;
	
	//1:N 
	private List<AllrgyVO> allrgyList;
	

}

