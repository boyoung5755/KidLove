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
	private Integer chldrnNo;             			// 자녀번호
	private Integer chldrnSymptmsNo;      			// 자녀증상번호
	private LocalDateTime crtDt;          			// 생성일
	private LocalDateTime symptmsBgndt;   			// 증상시작일
	private LocalDateTime symptmsEnddt;   			// 증상종료일
	private String symptmsMemo;           			// 증상메모
	private Integer symptmsNo;            			// 질병번호
	
	//1:1
	private ChldrnVO chldrnUnity;
	private SymptmsVO symptmsUnity;
}
