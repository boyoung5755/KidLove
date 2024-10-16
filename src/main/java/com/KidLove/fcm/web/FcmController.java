package com.KidLove.fcm.web;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.comm.vo.ResultVO;
import com.KidLove.fcm.service.FcmService;
import com.KidLove.fcm.vo.FcmSendVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/fcm")
@RequiredArgsConstructor
public class FcmController {
	
	@Inject
	private final FcmService fcmService;
	
	@PostMapping("/send")
    public ResponseEntity<ResultVO<Object>> pushMessage(@RequestPart FcmSendVO fcmRequest) throws IOException {
        return fcmService.pushMessage(fcmRequest);
    }
	

}
