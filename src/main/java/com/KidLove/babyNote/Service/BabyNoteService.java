package com.KidLove.babyNote.Service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.KidLove.comm.vo.ResultVO;

public interface BabyNoteService {

	/**
	 * @MethodName	: getBabyNote
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	:
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param chldrnNo
	 * @return
	 */
	
	ResponseEntity<ResultVO<Object>> getBabyNote(String chldrnNo);

	/**
	 * @MethodName	: createVacntnRecord
	 * @author		: Boyoung
	 * @date 		: 2024.11.15
	 * @description	:
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param param
	 * @return
	 */
	ResponseEntity<ResultVO<Object>> createVacntnRecord(Map<String, String> param);

	/**
	 * @MethodName	: getVacntnIctsdDtl
	 * @author		: Boyoung
	 * @date 		: 2024.11.15
	 * @description	:
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param param
	 * @return
	 */
	ResponseEntity<ResultVO<Object>> getVacntnIctsdDtl(Map<String, String> param);

	
}
