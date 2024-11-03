package com.KidLove.chldrn.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 수면
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SleepVO {
	
	private String atchCode;              			// 파일코드
	private Long chldrnNo;             				// 자녀번호
	private LocalDateTime sleepCrtDt;          		// 생성일
	private LocalDateTime sleepBgndt;     			// 수면시작시간
	private LocalDateTime sleepEnddt;     			// 수면종료시간
	private String sleepMemo;             			// 수면메모
	private Integer sleepNo;              			// 수면번호
	private String sleepTy;               			// 수면타입(낮,밤)

	//1:1
	private ChldrnVO chldrn;
}
