package com.KidLove.chldrn.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.KidLove.babyNote.vo.VacntnRcordVO;
import com.KidLove.checkUp.vo.MdexmnRcordVO;
import com.KidLove.mber.vo.MberVO;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



/**
 * 자녀
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChldrnVO {

	private String atchCode;              			// 첨부파일코드
	private String chldrnBrthdy;          			// 생일
	private String chldrnNcnm;            			// 별명, 태명
	private String chldrnNm;              			// 이름
	private Long chldrnNo;             				// 자녀번호
	private String chldrnSexdstn;         			// 성별   F,M,N
	private String chldrnTy;              			// 자녀타입 'FETUS','NWNBB','BABY','INFANT','CHILD'
	private String cnrsCd;                			// 공유코드
	private LocalDateTime chldrnCrtDt;          	// 생성일
	private String chldrnHideAt;					// 자녀 숨김여부
	private String chldrnDelAt;						// 자녀 정보 삭제 여부
	private String atchFlpth;      					 //파일경로
	
	
	private String mberId ;
	private Integer dday;

	private int age;
	private int weeks;
	private int days;
	
	//N:N
	private List<MberVO> mberList;		
	
	//1:N
	private List<SignificantVO> significantList;
	private List<ChldrnInfoVO> chldrnInfoList;
	private List<ChldrnAllrgyVO> chldrnAllrgyList;
	private List<ChldrnSymptmsVO> chldrnSymptmsList;
	private List<UrineVO> urineList;
	private List<MealVO> mealList;
	private List<BdHeatVO> bdHeatList;
	private List<SleepVO> sleepList;
	private List<VacntnRcordVO> vacntnRcordList;
	private List<MdexmnRcordVO> mdexmnRcordList;
	private List<ChldrnMemoVO> chldrnMemoList;
	private List<TakngVO> takngList;
	
	
	
}
