package com.KidLove.comm.vo;

import java.util.List;

import com.KidLove.babyNote.vo.VacntnMthVO;
import com.KidLove.babyNote.vo.VacntnRcordVO;
import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VacntnVO {
	
	private Integer vacntnCnt;            			// 접종횟수
	private Integer vacntnEra;            			// 접종시기
	private String vacntnIctsd;           			// 대상전염병명
	private Long vacntnNo;             			    // 예방접종번호
	private String mthNm;							// 백신명
	private Long  vacntnMthNo;
	private Integer vacntnOdr;
	
	//1:1
	private VacntnRcordVO vacntnRcord;
	
	//1:N
	private List<VacntnMthVO> vacntnMthList;
	
}
