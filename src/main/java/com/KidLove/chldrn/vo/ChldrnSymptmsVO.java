package com.KidLove.chldrn.vo;

import java.time.LocalDateTime;

import com.KidLove.mber.vo.MberVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 자녀증상
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChldrnSymptmsVO {
	
	private String atchCode;              			// 파일코드
	private Long chldrnNo;             				// 자녀번호
	private Long chldrnSymptmsNo;      				// 자녀증상번호
	private LocalDateTime symptmsCrtDt;          			// 생성일
	private LocalDateTime symptmsBgndt;   			// 증상시작일
	private LocalDateTime symptmsEnddt;   			// 증상종료일
	private String symptmsMemo;           			// 증상메모
	private Long symptmsNo;            				// 질병번호
	private String symptmsTy;
	
	//1:1
	private ChldrnVO chldrn;
	private SymptmsVO symptms;
}
