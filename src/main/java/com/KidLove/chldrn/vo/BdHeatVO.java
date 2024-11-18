package com.KidLove.chldrn.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 체온
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BdHeatVO {

	
	private String atchCode;              			// 파일코드
	private String bdheatMemo;            			// 체온메모
	private Long bdheatNo;             				// 체온번호
	private Double bdheatTp;              			// 측정온도
	private Integer chldrnNo;             			// 자녀번호
	private LocalDateTime bdheatCrtDt;          	// 생성일
	private LocalDateTime bdheatBgndt;     			// 체온측정 시작
	private LocalDateTime bdheatEnddt;     		    // 체온측정 완료
	
	private LocalDateTime recordDate;
	private Double avgBdheat;
	
	
	//1:1
	private ChldrnVO chldrn;

}
