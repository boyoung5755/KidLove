package com.KidLove.checkUp.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.KidLove.chldrn.vo.ChldrnVO;
import com.KidLove.comm.vo.HsptlVO;
import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MdexmnRcordVO {
	
	private Long chldrnNo;             			// 자녀번호
	private LocalDateTime crtDt;          			// 생성일
	private Long hsptlNo;              			// 병원번호
	private String mdexmnDgnssNm;         		// 병명
	private String mdexmnDoctrOpinion;    		// 의사소견
	private Long mdexmnRcordNo;        			// 검진기록번호
	private Long parmacyNo;           			// 약국번호
	private LocalDateTime mdexmnRcordDt;		// 검진일		
	private String mdexmnMdlrt;					// 치료
	private String mdexmnMemo;	
	private String mdexmnTy;					//enum('CLNIC','MDEXMN')  일반진료, 검진
	
	//1:N
	private List<HsptlVO> hsptlList;
	
	//1:1
	private ChldrnVO chldrn;
	private PrscrptnVO prscrptn;
	
}


