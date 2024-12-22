package com.KidLove.chldrn.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.KidLove.chldrn.dto.ChldrnProfileRequest;
import com.KidLove.comm.vo.ResultVO;

public interface ChldrnService {
	
	/**
	 * @MethodName	: findChldrnHealthInfo
	 * @author		: Boyoung
	 * @date 		: 2024.12.22
	 * @description	: 신생아정보등록
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param param
	 * @return
	 */
	
	ResponseEntity<ResultVO<Object>> createChldrnInfo(ChldrnProfileRequest chldrnRequest);
	
	/**
	 * @MethodName	: findChldrnHealthInfo
	 * @author		: Boyoung
	 * @date 		: 2024.12.22
	 * @description	: 아이기본정보
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param param
	 * @return
	 */

	ResponseEntity<ResultVO<Object>> findChldrnProfileInfo(Map<String, String> param);

	/**
	 * @MethodName	: findChldrnHealthInfo
	 * @author		: Boyoung
	 * @date 		: 2024.12.22
	 * @description	: 아이건강정보
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param param
	 * @return
	 */
	
	ResponseEntity<ResultVO<Object>> findChldrnHealthInfo(Map<String, String> param);
}
