package com.KidLove.fcm.vo;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * 모바일에서 전달 받은 객체
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FcmSendVO {
	
	private Long fcmHistNo;
	
	private String token;
	private String title;
	private String body;
	private String topic;
	private String type;
	private HttpStatus status;
	private String sender;
	
	private Long mberNo;

	private Long fcmMberNo;
	private String readYn;
	private LocalDateTime fcmMberCrtDt;
}
