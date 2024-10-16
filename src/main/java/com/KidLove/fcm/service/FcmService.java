package com.KidLove.fcm.service;

import org.springframework.http.ResponseEntity;

import com.KidLove.comm.vo.ResultVO;
import com.KidLove.fcm.vo.FcmSendVO;

public interface FcmService {

	public ResponseEntity<ResultVO<Object>> pushMessage(FcmSendVO fcmRequest);

}
