package com.KidLove.fcm.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import com.KidLove.comm.vo.ResultVO;
import com.KidLove.fcm.vo.FcmSendVO;

public interface FcmService {

	public ResponseEntity<ResultVO<Object>> pushMessage(FcmSendVO fcmRequest);

	/**
	 * @MethodName	: getAccessToken
	 * @author		: Boyoung
	 * @date 		: 2024.11.20
	 * @description	:
	 * @return 		: String
	 * @return
	 * @throws IOException 
	 */
	public String getAccessToken() throws IOException;

	/**
	 * @MethodName	: updateToken
	 * @author		: Boyoung
	 * @date 		: 2024.11.20
	 * @description	:
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @param fcmRequest
	 * @param authentication
	 * @return
	 */
	public ResponseEntity<ResultVO<Object>> updateToken(FcmSendVO fcmRequest, Authentication authentication);

	/**
	 * @MethodName	: getPushReadYn
	 * @author		: Boyoung
	 * @date 		: 2024.11.20
	 * @description	:
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @return
	 */
	public ResponseEntity<ResultVO<Object>> getPushReadYn(String mberNo);

}
