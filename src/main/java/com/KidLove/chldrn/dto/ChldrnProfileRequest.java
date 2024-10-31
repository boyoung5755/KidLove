package com.KidLove.chldrn.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChldrnProfileRequest {
	private String chldrnTy;
	private String chldrnNm;
	private String chldrnBrthdy;
	private Double chldrnBdwgh;
	private Double chldrnHeight;
	private Double	chldrnHead;
	private List<String> allrgyNm;
	private List<String> symptmsNm;
	private String chldrnMemo;
	
	
}
