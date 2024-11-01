/**
 * 
 */
package com.KidLove.report.service;

import org.springframework.http.ResponseEntity;

import com.KidLove.chldrn.vo.SleepVO;
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
	 * @description	:
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param sleep
	 * @return
	 */
	public ResponseEntity<ResultVO<Object>> createSleepHist(SleepVO sleep);

}
