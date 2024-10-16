package com.KidLove.comm.vo;

import com.KidLove.babyNote.vo.VacntnRcordVO;
import com.KidLove.chldrn.vo.ChldrnVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 예방접종
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacntnVO {
	
	private Integer vacntnCnt;            			// 접종횟수
	private Integer vacntnEra;            			// 접종시기
	private String vacntnIctsd;           			// 대상전염병명
	private Integer vacntnNo;             			// 예방접종번호
	
	
	//1:1
	private VacntnRcordVO vacntnRcordUnity;
	
}
