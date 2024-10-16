package com.KidLove.chldrn.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.KidLove.babyNote.vo.VacntnRcordVO;
import com.KidLove.checkUp.vo.MdexmnRcordVO;
import com.KidLove.mber.vo.MberVO;

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
public class ChldrnVO {

	private String atchCode;              			// 첨부파일코드
	private String chldrnBrthdy;          			// 생일
	private String chldrnNcnm;            			// 별명, 태명
	private String chldrnNm;              			// 이름
	private Integer chldrnNo;             			// 자녀번호
	private String chldrnSexdstn;         			// 성별   F,M,N
	private String chldrnTy;              			// 자녀타입
	private String cnrsCd;                			// 공유코드
	private LocalDateTime crtDt;          			// 생성일
	
	//1:1
	private MberVO mberUnity;
	
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
	
	
	
}
