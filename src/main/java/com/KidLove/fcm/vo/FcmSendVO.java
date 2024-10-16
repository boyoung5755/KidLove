package com.KidLove.fcm.vo;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


/**
 * 모바일에서 전달 받은 객체
 */
@Builder
@Data
@AllArgsConstructor
public class FcmSendVO {
	
	private String token;
	private String title;
	private String body;
	private String topic;
	private String type;
	private HttpStatus status;
	
	private int mberNo;

}
