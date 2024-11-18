package com.KidLove.comm.vo;

import com.KidLove.babyNote.vo.VacntnRcordVO;
import com.KidLove.checkUp.vo.MdexmnRcordVO;
import com.KidLove.chldrn.vo.ChldrnSymptmsVO;
import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HsptlVO {

	private String hsptlNm;               			// 병원명
	private Long hsptlNo;              				// 병원번호
	private String hsptlDrctr; 						// 원장이름
	private String hsptlAddr;						// 병원주소
	
	//1:1
	private VacntnRcordVO vacntnRcord;
	private MdexmnRcordVO mdexmnRcord;
	private ChldrnSymptmsVO chldrnSymptms; 
	
}
