package com.KidLove.checkUp.vo;

import java.time.LocalDateTime;

import com.KidLove.comm.vo.ParmacyVO;

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
public class PrscrptnVO {
	
	private String atchCode;              			// 파일코드
	private LocalDateTime crtDt;          			// 생성일
	private Integer mdexmnRcordNo;        			// 검진기록번호
	private Integer parmacyNo;            			// 약국번호
	private LocalDateTime prscrptnDt;     			// 처방일
	private Integer prscrptnNo;           			// 처방전번호
	
	
	//1:1
	private ParmacyVO parmacyUnity;
	private MdexmnRcordVO mdexmnRcordUnity;
}
