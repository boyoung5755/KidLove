package com.KidLove.comm.vo;

import com.KidLove.babyNote.vo.VacntnRcordVO;
import com.KidLove.checkUp.vo.MdexmnRcordVO;
import com.KidLove.chldrn.vo.ChldrnSymptmsVO;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 병원
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HsptlVO {

	private String hsptlNm;               			// 병원명
	private Long id;              					// 병원번호 (DB용)
	private Long hsptlNo;              				// 병원번호
	private String hsptlDrctr; 						// 원장이름
	
	private String dutyAddr;						// 병원주소
	private String dutyAddr1Depth;
	private String dutyAddr2Depth;
	private String dutyAddr3Depth;
	private String dutyEtc;
	private String dutyName;
	private String dutyTel1;
	private String dutyTime1c;
	private String dutyTime1s;
	private String dutyTime2c;
	private String dutyTime2s;
	private String dutyTime3c;
	private String dutyTime3s;
	private String dutyTime4c;
	private String dutyTime4s;
	private String dutyTime5c;
	private String dutyTime5s;
	private String dutyTime6c;
	private String dutyTime6s;
	private String dutyTime7c;
	private String dutyTime7s;
	private String dutyTime8c;
	private String dutyTime8s;
	private Double wgs84Lat;
	private Double wgs84Lon;
	
	private Long vacntnRcordNo;    
	private Long mdexmnRcordNo;  
	private Long chldrnSymptmsNo; 
	private Long mberHsptlNo;
	
	private String mdexmnDgnssNm;
	
	
	//1:1
	private VacntnRcordVO vacntnRcord;
	private MdexmnRcordVO mdexmnRcord;
	private ChldrnSymptmsVO chldrnSymptms; 
	
}
