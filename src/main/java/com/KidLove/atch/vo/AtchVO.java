package com.KidLove.atch.vo;

import java.time.LocalDateTime;

import com.KidLove.comm.FileTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtchVO {

	private Integer atchNo;
	private String atchOrginlnm;
	private String atchExtsn;
	private String atchCode; 
	private String atchFlpth;
	private Integer atchSz;
	private FileTypeEnum atchTy;
	
	private String atchResizedAt;
	private LocalDateTime crtDt;
}

