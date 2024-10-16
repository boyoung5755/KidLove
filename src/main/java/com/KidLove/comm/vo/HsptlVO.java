package com.KidLove.comm.vo;

import com.KidLove.babyNote.vo.VacntnRcordVO;
import com.KidLove.checkUp.vo.MdexmnRcordVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 병원
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HsptlVO {

	private String hsptlNm;               			// 병원명
	private Integer hsptlNo;              			// 병원번호
	
	//1:1
	private VacntnRcordVO vacntnRcordUnity;
	private MdexmnRcordVO mdexmnRcordUnity;
	
}
