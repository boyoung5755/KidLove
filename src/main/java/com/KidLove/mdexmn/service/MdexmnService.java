/**
 * 
 */
package com.KidLove.mdexmn.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.KidLove.comm.vo.PageVO;
import com.KidLove.comm.vo.ResultVO;

/**
 * @packageName	: com.KidLove.mdexmn.service
 * @since		: 2024.11.12
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.12		Boyoung			최초생성
 */
public interface MdexmnService {

	/**
	 * @MethodName	: getHstplHist
	 * @author		: Boyoung
	 * @date 		: 2024.11.12
	 * @description	:
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @return
	 */
	ResponseEntity<ResultVO<Object>> getHstplHist(String chldrnNo);

	/**
	 * @MethodName	: createMdexmnRecord
	 * @author		: Boyoung
	 * @date 		: 2024.11.13
	 * @description	:
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param param
	 * @return
	 */
	ResponseEntity<ResultVO<Object>> createMdexmnRecord(Map<String, String> param , MultipartFile file);

	/**
	 * @MethodName	: getMdexmnDgnssNmHist
	 * @author		: Boyoung
	 * @date 		: 2024.11.14
	 * @description	:
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param chldrnNo
	 * @return
	 */
	ResponseEntity<ResultVO<Object>> getMdexmnDgnssNmHist(String chldrnNo);

	/**
	 * @MethodName	: getMdexmnRecord
	 * @author		: Boyoung
	 * @date 		: 2024.11.14
	 * @description	:
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param page
	 * @return
	 */
	ResponseEntity<ResultVO<Object>> getMdexmnRecord(PageVO page);

	
}
