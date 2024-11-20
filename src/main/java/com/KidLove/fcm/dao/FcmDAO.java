package com.KidLove.fcm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.KidLove.fcm.vo.FcmSendVO;

@Mapper
public interface FcmDAO {

	/**
	 * @MethodName	: insertFcmHist
	 * @author		: Boyoung
	 * @date 		: 2024.11.20
	 * @description	: 푸쉬토큰 보낸 내역 저장
	 * @return 		: int
	 * @param fcmRequest
	 * @return
	 */
	int insertFcmHist(FcmSendVO fcmRequest);

	/**
	 * @MethodName	: insertFcmMber
	 * @author		: Boyoung
	 * @date 		: 2024.11.20
	 * @description	: 푸쉬토큰받은 사람 목록 저장
	 * @return 		: int
	 * @param fcmRequest
	 * @param mberNo
	 * @return
	 */
	int insertFcmMber(FcmSendVO fcmRequest);

	/**
	 * @MethodName	: updateToken
	 * @author		: Boyoung
	 * @date 		: 2024.11.20
	 * @description	: 푸쉬토큰 업데이트
	 * @return 		: void
	 * @param fcmRequest
	 * @param loginId
	 */
	void updateToken( @Param("token")String token,  @Param("loginId")String loginId);

	/**
	 * @MethodName	: getPushReadYn
	 * @author		: Boyoung
	 * @date 		: 2024.11.20
	 * @description	: 푸쉬알람 읽음 여부 
	 * @return 		: List<FcmSendVO>
	 * @param int1
	 * @return
	 */
	List<FcmSendVO> getPushReadYn(@Param("mberNo") Long mberNo);

}
