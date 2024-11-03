package com.KidLove.babyNote.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.KidLove.chldrn.vo.ChldrnVO;
import com.KidLove.comm.vo.HsptlVO;
import com.KidLove.comm.vo.VacntnVO;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 예방접종기록
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VacntnRcordVO {
	
	private Long chldrnNo;             				// 자녀번호
	private LocalDateTime vacntnRcordCrtDt;          			// 생성일(접종일)
	private Integer hsptlNo;              			// 병원번호
	private String vacinTy;               			// 백신종류 
	private Long vacntnNo;             				// 예방접종번호
	private Long vacntnRcordNo;        				// 예방접종기록번호
	private Integer vacntnRemndr;         			// 접종잔여횟수
	private String vacntnSportAt;         			// N 유료, Y무료

	//1:1
	private ChldrnVO chldrn;
	
	//1:N
	private List<VacntnVO> vacntnList;
	private List<HsptlVO> hsptlList;
	
	
}
