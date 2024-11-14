package com.KidLove.checkUp.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.KidLove.comm.vo.ParmacyVO;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 처방전
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrscrptnVO {
	
	private String atchCode;              			// 파일코드
	private String prscrptnAtchCode;              			// 파일코드
	private LocalDateTime crtDt;          			// 생성일
	private Long mdexmnRcordNo;        			// 검진기록번호
	private Long parmacyNo;            			// 약국번호
	private LocalDateTime prscrptnDt;     			// 처방일
	private Long prscrptnNo;           			// 처방전번호
	
	
	//1:1
	private ParmacyVO parmacy;
	private MdexmnRcordVO mdexmnRcord;
	
	
	//1:N
	private List<PrscrptnDrugVO> PrscrptnDrugList;
}
