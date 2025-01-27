/**
 * 
 */
package com.KidLove.report.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.KidLove.chldrn.vo.BdHeatVO;
import com.KidLove.chldrn.vo.ChldrnInfoVO;
import com.KidLove.chldrn.vo.MealVO;
import com.KidLove.chldrn.vo.SleepVO;
import com.KidLove.chldrn.vo.TakngVO;
import com.KidLove.chldrn.vo.UrineVO;
import com.KidLove.comm.vo.ResultVO;

/**
 * @packageName	: com.KidLove.report.service
 * @since		: 2024.11.01
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.01		Boyoung			최초생성
 */
public interface ReportService {

	/**
	 * @MethodName	: createSleepHist
	 * @author		: Boyoung
	 * @date 		: 2024.11.01
	 * @description	: 수면기록
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param sleep
	 * @return
	 */
	public ResponseEntity<ResultVO<Object>> createSleepHist(SleepVO sleep);

	/**
	 * @MethodName	: createHeWgh
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	: 키/체중 기록
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param info
	 * @return
	 */
	
	public ResponseEntity<ResultVO<Object>> createHeWgh(ChldrnInfoVO info);

	/**
	 * @MethodName	: getRecentHeWghList
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	: 최근 키/체중 조회
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param chldrnNo
	 * @return
	 */
	
	public ResponseEntity<ResultVO<Object>> getRecentHeWghList(String chldrnNo);

	/**
	 * @MethodName	: createUrineHist
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	: 배변 기록
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param urine
	 * @return
	 */
	
	public ResponseEntity<ResultVO<Object>> createUrineHist(UrineVO urine);

	/**
	 * @MethodName	: createMealHist
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	: 수유기록
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param meal
	 * @return
	 */
	
	public ResponseEntity<ResultVO<Object>> createMealHist(MealVO meal);

	/**
	 * @MethodName	: getRecentSleepList
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	: 수면기록조회
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param chldrnNo
	 * @return
	 */
	
	public ResponseEntity<ResultVO<Object>> getRecentSleepList(String chldrnNo);

	/**
	 * @MethodName	: getRecentUrineList
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	: 배변기록조회
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param chldrnNo
	 * @return
	 */
	
	public ResponseEntity<ResultVO<Object>> getRecentUrineList(String chldrnNo);

	/**
	 * @MethodName	: getRecentMealList
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	: 수유기록조회
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param chldrnNo
	 * @return
	 */
	
	public ResponseEntity<ResultVO<Object>> getRecentMealList(String chldrnNo);

	/**
	 * @MethodName	: removeRecord
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	:
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param paramMap
	 * @return
	 */
	
	public ResponseEntity<ResultVO<Object>> removeRecord(Map<String, Object> paramMap);

	/**
	 * @MethodName	: createbdHeatHist
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	: 체온기록하기
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param heat
	 * @return
	 */
	
	public ResponseEntity<ResultVO<Object>> createbdHeatHist(BdHeatVO heat);

	/**
	 * @MethodName	: getRecentBdHeatList
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	: 체온기록조회
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param chldrnNo
	 * @return
	 */
	
	public ResponseEntity<ResultVO<Object>> getRecentBdHeatList(String chldrnNo);

	/**
	 * @MethodName	: createTakngHist
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	: 약 복용기록
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param takng
	 * @return
	 */
	
	public ResponseEntity<ResultVO<Object>> createTakngHist(TakngVO takng);

	/**
	 * @MethodName	: getRecentTakngList
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	: 약 복용기록 조회
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param chldrnNo
	 * @return
	 */
	
	public ResponseEntity<ResultVO<Object>> getRecentTakngList(String chldrnNo);

	/**
	 * @MethodName	: createSymptms
	 * @author		: Boyoung
	 * @date 		: 2024.11.18
	 * @description	: 아이증상 기록하기
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param paramMap
	 * @return
	 */
	public ResponseEntity<ResultVO<Object>> createSymptms(Map<String, String> paramMap);

	/**
	 * @MethodName	: getBabyHome
	 * @author		: Boyoung
	 * @date 		: 2024.11.18
	 * @description	: 레포트 아기홈
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param param
	 * @return
	 */
	public ResponseEntity<ResultVO<Object>> getBabyHome(Map<String, String> param);

	/**
	 * @MethodName	: createEmotion
	 * @author		: Boyoung
	 * @date 		: 2025.01.27
	 * @description	: 아이 감정기록
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param param
	 * @return
	 */
	
	public ResponseEntity<ResultVO<Object>> createEmotion(Map<String, String> param);

	/**
	 * @MethodName	: getTotHist
	 * @author		: Boyoung
	 * @date 		: 2025.01.27
	 * @description	:
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param param
	 * @return
	 */
	
	public ResponseEntity<ResultVO<Object>> getTotHist(Map<String, Object> param);

}
