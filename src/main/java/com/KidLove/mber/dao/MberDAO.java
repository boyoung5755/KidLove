package com.KidLove.mber.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.KidLove.fcm.vo.FcmSendVO;
import com.KidLove.mber.vo.MberVO;

@Mapper
public interface MberDAO {

	/**
	 * @MethodName	: getMemberPushToken
	 * @author		: Boyoung
	 * @date 		: 2024.11.20
	 * @description	: 토큰에 해당하는 멤버 리스트 조회
	 * @return 		: List<MberVO>
	 * @param fcmRequest
	 * @return
	 */
	List<MberVO> getMemberPushToken(FcmSendVO fcmRequest);

}
