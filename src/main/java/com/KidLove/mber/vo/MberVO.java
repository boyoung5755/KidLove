/**
 * 
 */
package com.KidLove.mber.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MberVO {
	
	private String mberRole;
	private String refreshToken;
	
	private Integer mberNo;
	private String mberId;
	private String mberPw;
	private String mberNcnm;
	private String mberEml;
	private String mberTel;
	private String mberAddr;
	private String mberZip;
	private String mberSexdstn;
	private String atchCode;
	private String cnrsCd;
	private String mberSttus;
	private LocalDateTime crtDt;
	private LocalDateTime mberLastConectdt;

}
