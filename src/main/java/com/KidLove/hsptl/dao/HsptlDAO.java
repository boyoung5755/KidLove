/**
 * 
 */
package com.KidLove.hsptl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.KidLove.comm.vo.HsptlVO;
import com.KidLove.comm.vo.PageVO;

/**
 * @packageName	: com.KidLove.hsptl.dao
 * @since		: 2024.11.25
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.25		Boyoung			최초생성
 */

@Mapper
public interface HsptlDAO {

	/**
	 * @MethodName	: checkHsptlId
	 * @author		: Boyoung
	 * @date 		: 2024.11.25
	 * @description	: 기존의 저장된 병원인지 확인
	 * @return 		: HsptlVO
	 * @param id
	 * @return
	 */
	HsptlVO checkHsptlId(@Param("id") Long id);

	/**
	 * @MethodName	: insertHsptl
	 * @author		: Boyoung
	 * @date 		: 2024.11.25
	 * @description	: 병원저장하기
	 * @return 		: void
	 * @param ele
	 */
	void insertHsptl(HsptlVO hsptl);

	/**
	 * @MethodName	: getAllHsptlRecordTotRecCnt
	 * @author		: Boyoung
	 * @date 		: 2024.11.25
	 * @description	: 모든병원 레코드 수
	 * @return 		: int
	 * @param page
	 * @return
	 */
	int getAllHsptlRecordTotRecCnt(PageVO page);

	/**
	 * @MethodName	: getAllHsptl
	 * @author		: Boyoung
	 * @date 		: 2024.11.25
	 * @description	: 모든 병원 목록 조회
	 * @return 		: List<HsptlVO>
	 * @param newPage
	 * @return
	 */
	List<Map<String, String>> getAllHsptl(PageVO newPage);

	/**
	 * @MethodName	: getHsptlByRegionRecordTotRecCnt
	 * @author		: Boyoung
	 * @date 		: 2024.11.25
	 * @description	: 지역별 조회 병원 레코스 수
	 * @return 		: int
	 * @param page
	 * @return
	 */
	int getHsptlByRegionRecordTotRecCnt(PageVO page);

	/**
	 * @MethodName	: getHsptlByRegion
	 * @author		: Boyoung
	 * @date 		: 2024.11.25
	 * @description	: 지역별 검색 병원 목록 조회
	 * @return 		: List<HsptlVO>
	 * @param newPage
	 * @param searchStr
	 * @param sort
	 * @return
	 */
	List<Map<String, String>> getHsptlByRegion(PageVO newPage);

	/**
	 * @MethodName	: getHsptlByNameRecordTotRecCnt
	 * @author		: Boyoung
	 * @date 		: 2024.12.01
	 * @description	: 이름별 검색 병원 레코드 수
	 * @return 		: int
	 * @param page
	 * @return
	 */
	
	int getHsptlByNameRecordTotRecCnt(PageVO page);

	/**
	 * @MethodName	: getHsptlByName
	 * @author		: Boyoung
	 * @date 		: 2024.12.01
	 * @description	: 이름별 검색 병원
	 * @return 		: List<HsptlVO>
	 * @param newPage
	 * @return
	 */
	
	List<Map<String, String>> getHsptlByName(PageVO newPage);

	/**
	 * @MethodName	: getNearHsptlRecordTotRecCnt
	 * @author		: Boyoung
	 * @date 		: 2024.12.01
	 * @description	: 유저위치기반 반경 병원조회 레코드 수
	 * @return 		: int
	 * @param page
	 * @return
	 */
	
	int getNearHsptlRecordTotRecCnt(PageVO page);

	/**
	 * @MethodName	: getNearHsptl
	 * @author		: Boyoung
	 * @date 		: 2024.12.01
	 * @description	: 유저위치기반 반경 병원조회
	 * @return 		: List<HsptlVO>
	 * @param newPage
	 * @return
	 */
	
	List<Map<String, String>> getNearHsptl(PageVO newPage);

	/**
	 * @MethodName	: getHsptlByHourRecordTotRecCnt
	 * @author		: Boyoung
	 * @date 		: 2025.12.29
	 * @description	: 요일별 운영시간 조회
	 * @return 		: int
	 * @param page
	 * @return
	 */
	
	int getHsptlByHourRecordTotRecCnt(PageVO page);

	/**
	 * @MethodName	: getHsptlByHour
	 * @author		: Boyoung
	 * @date 		: 2025.12.29
	 * @description	: 요일별 운영시간 조회 레코드 수 
	 * @return 		: List<HsptlVO>
	 * @param newPage
	 * @return
	 */
	
	List<HsptlVO> getHsptlByHour(PageVO newPage);

}
