package com.KidLove.fcm.service;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.KidLove.comm.utils.SQLErrorMessage;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.fcm.dao.FcmDAO;
import com.KidLove.fcm.vo.FcmMessageVO;
import com.KidLove.fcm.vo.FcmSendVO;
import com.KidLove.mber.dao.MberDAO;
import com.KidLove.mber.vo.MberVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;

@Service
public class FcmServiceImpl implements FcmService {
	
	@Inject
	private FcmDAO fcmDao;
	
	@Inject
	private MberDAO mberDao;
	
	
	@Value("${fcm.secret-file}")
	private String secretFileName;
	
	@Value("${fcm.api-url}")
	private String fcmUrl;
	
	@Inject
	private SQLErrorMessage sqlErrorMessage;
	
	
	@Override
	@Transactional
	public ResponseEntity<ResultVO<Object>> pushMessage(FcmSendVO fcmRequest) {
		
		try {
			List<MberVO> memeberList = mberDao.getMemberPushToken(fcmRequest);
			
			for(MberVO mber : memeberList) {
				
				if(mber.getMberPushToken() ==  null) continue;
				
				fcmRequest.setToken(mber.getMberPushToken());
				String message = makeMessage(fcmRequest);
				RestTemplate restTemplate = new RestTemplate();
				
				HttpHeaders headers = new HttpHeaders();
				headers.set("Content-Type", "application/json");
                headers.set("Authorization", "Bearer " + getAccessToken());
                
                HttpEntity<String> entity = new HttpEntity<String>(message, headers);
				
                String API_URL =fcmUrl;
                ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, entity, String.class);
				
                
            	fcmRequest.setStatus((HttpStatus) response.getStatusCode());
            	fcmDao.insertFcmHist(fcmRequest);
            	
            	fcmRequest.setMberNo(mber.getMberNo());
                fcmDao.insertFcmMber(fcmRequest);
			}
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "fcm_send_failed", ""));
		}	 
		return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",""));
	}
	
	
	/**
	 * Firebase Admin SDK의 비공개 키를 참조하여 Bearer 토큰을 발급
	 * @return
	 * @throws IOException
	 */
	@Override
	public String getAccessToken() throws IOException {
    	ClassPathResource cps = new ClassPathResource("/"+secretFileName);

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


	@Override
	public ResponseEntity<ResultVO<Object>> updateToken(FcmSendVO fcmRequest, Authentication authentication) {
		String loginId = authentication.getName();
		try {
			fcmDao.updateToken(fcmRequest.getToken(),loginId);
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK, "Update success", ""));
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK, "Update failed", ""));
		}
	}


	@Override
	public ResponseEntity<ResultVO<Object>> getPushReadYn(String mberNo) {
		List<FcmSendVO> fcm = fcmDao.getPushReadYn(Long.parseLong(mberNo));
		return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",fcm));
	}
	
}
