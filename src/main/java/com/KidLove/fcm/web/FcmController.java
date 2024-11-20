package com.KidLove.fcm.web;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.comm.vo.ResultVO;
import com.KidLove.fcm.service.FcmService;
import com.KidLove.fcm.vo.FcmSendVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/fcm")
@RequiredArgsConstructor
public class FcmController {
	
	@Inject
	private final FcmService fcmService;
	
	
	@GetMapping("/getPushReadYn")
	public ResponseEntity<ResultVO<Object>> getPushReadYn(@RequestParam("mberNo")String mberNo){
		try {
			return fcmService.getPushReadYn(mberNo);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	@PatchMapping("/updateToken")
	public ResponseEntity<ResultVO<Object>> updateToken(
			@RequestBody FcmSendVO fcmRequest , Authentication authentication){
		try {
			return fcmService.updateToken(fcmRequest,authentication);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	@PostMapping("/send")
    public ResponseEntity<ResultVO<Object>> pushMessage(@RequestBody FcmSendVO fcmRequest)  {
		try {
			return fcmService.pushMessage(fcmRequest);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
    }
	
	
	/**
	 * @MethodName	: generateToken
	 * @author		: Boyoung
	 * @date 		: 2024.11.20
	 * @description	: admin fcm키
	 * @return 		: ResponseEntity<ResultVO<Object>>
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/generateToken")
    public ResponseEntity<ResultVO<Object>> generateToken() throws IOException {
		String accessToken = fcmService.getAccessToken();
		return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",accessToken));
    }


	

}
