package com.KidLove.checkUp.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.KidLove.chldrn.vo.ChldrnVO;
import com.KidLove.comm.vo.HsptlVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 검진기록
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MdexmnRcordVO {
	
	private Integer chldrnNo;             			// 자녀번호
	private LocalDateTime crtDt;          			// 생성일
	private Integer hsptlNo;              			// 병원번호
	private String mdexmnDgnssNm;         			// 병명
	private String mdexmnDoctrOpinion;    			// 의사소견
	private Integer mdexmnRcordNo;        			// 검진기록번호
	private Integer parmacyNo;           			// 약국번호

	
	//1:N
	private List<HsptlVO> hsptlList;
	
	//1:1
	private ChldrnVO chldrnUnity;
	private PrscrptnVO prscrptnUnity;
	
}


