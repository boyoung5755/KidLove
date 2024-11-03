package com.KidLove.babyNote.Service;

import org.springframework.http.ResponseEntity;

import com.KidLove.chldrn.vo.ChldrnVO;
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

	
}
