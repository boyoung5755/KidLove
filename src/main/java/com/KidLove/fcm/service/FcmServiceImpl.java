package com.KidLove.fcm.service;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.KidLove.comm.vo.ResultVO;
import com.KidLove.fcm.dao.FcmDAO;
import com.KidLove.fcm.vo.FcmMessageVO;
import com.KidLove.fcm.vo.FcmSendVO;
import com.KidLove.mber.dao.MberDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;

@Service
public class FcmServiceImpl implements FcmService {
	
	@Inject
	private FcmDAO fcmDao;
	
	@Inject
	private MberDAO mberDao;
	
	@Override
	public ResponseEntity<ResultVO<Object>> pushMessage(FcmSendVO fcmRequest) {
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",""));
	}
	
	
	/**
	 * Firebase Admin SDK의 비공개 키를 참조하여 Bearer 토큰을 발급
	 * @return
	 * @throws IOException
	 */
    private String getAccessToken() throws IOException {
    	ClassPathResource cps = new ClassPathResource("firebase/today-s-i-firebase-adminsdk-j4l67-ded9c5e249.json");

        GoogleCredentials googleCredentials = GoogleCredentials
        		.fromStream(cps.getInputStream())
                .createScoped(List.of("https://www.googleapis.com/auth/cloud-platform"));
        googleCredentials.refreshIfExpired();
        
        return googleCredentials.getAccessToken().getTokenValue();
    }
    
    /**
     * FCM 전송 정보를 기반으로 메시지를 구성 (Object -> String)
     * @param fcmSendDto
     * @return
     * @throws JsonProcessingException
     */
    private String makeMessage(FcmSendVO fcmSendVO) throws JsonProcessingException {

        ObjectMapper om = new ObjectMapper();
        FcmMessageVO fcmMessageVO = FcmMessageVO.builder()
                .message(FcmMessageVO.Message.builder()
                .token(fcmSendVO.getToken())
                .notification(FcmMessageVO.Notification.builder()
                .title(fcmSendVO.getTitle())
                .body(fcmSendVO.getBody())
                .image(null)
                .build()
                 )
                .build()).validateOnly(false).build();

        return om.writeValueAsString(fcmMessageVO);
    }

	
}
