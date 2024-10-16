package com.KidLove.chldrn.vo;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 자녀 메모
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChldrnMemoVO {
	
	private Integer chldrnMemoNo;
	private LocalDateTime crtDt;
	private Integer chldrnNo;
	private String chldrnMemo;
	
	//1:1
	private ChldrnVO chldrnUnity;
	

}
