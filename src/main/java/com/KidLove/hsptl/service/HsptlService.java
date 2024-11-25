/**
 * 
 */
package com.KidLove.hsptl.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.KidLove.comm.vo.HsptlVO;
import com.KidLove.comm.vo.PageVO;
import com.KidLove.comm.vo.ResultVO;

/**
 * @packageName	: com.KidLove.hsptl.service
 * @since		: 2024.11.25
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.25		Boyoung			최초생성
 */
public interface HsptlService {

	/**
	 * @MethodName	: saveHsptlMdcnc
	 * @author		: Boyoung
	 * @date 		: 2024.11.25
	 * @description	:
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param hsptl
	 * @return
	 */
	ResponseEntity<ResultVO<Object>> saveHsptlMdcnc(List<HsptlVO> hsptl);

	/**
	 * @MethodName	: getAllHsptl
	 * @author		: Boyoung
	 * @date 		: 2024.11.25
	 * @description	:
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param page
	 * @return
	 */
	ResponseEntity<ResultVO<Object>> getAllHsptl(PageVO page);

}
