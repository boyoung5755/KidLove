/**
 * 
 */
package com.KidLove.mber.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.KidLove.chldrn.vo.ChldrnVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * member
 */
@Builder
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MberVO {
	
	//권한
	private String mberRole;
	private Integer authorNo;             			// 권한번호
	
	//멤버
	
	private String atchCode;              			// 프로필이미지
	private String cnrsCd;                			// 공유코드
	private LocalDateTime crtDt;          			// 생성일
	private String mberAddr;              			// 회원주소
	private String mberEml;               			// 회원이메일
	private String mberId;                			// 회원아이디
	private LocalDateTime mberLastConectdt;			// 마지막접속일
	private String mberLoginTy;           			// 
	private String mberNcnm;              			// 회원별명
	private Integer mberNo;               			// 회원번호
	private String mberPw;                			// 회원비밀번호
	private String mberSexdstn;           			// 성별  F,M,A
	private String mberSttus;             			// 1. 임신중 2.출산 3.계획중
	private String mberTel;               			// 회원전화번호
	private String mberZip;               			// 우편번호
	private String refreshToken;          			// 
	
	
	//탈퇴
	private LocalDateTime whdwlDt;        			// 탈퇴일
	private Integer whdwlNo;              			// 탈퇴번호
	private String whdwlResnCn;           			// 탈퇴사유
	private String whdwlResnType;         			// 탈퇴타입
	
	//1:N
	private List<ChldrnVO> chldrnList ;

}
