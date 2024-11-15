package com.KidLove.babyNote.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.KidLove.babyNote.vo.VacntnRcordVO;
import com.KidLove.comm.vo.VacntnVO;

@Mapper
public interface BabyNoteDAO {

	public List<VacntnVO> getBabyNote(@Param("chldrnNo") Long chldrnNo);

	/**
	 * @MethodName	: insertVacntnRcord
	 * @author		: Boyoung
	 * @date 		: 2024.11.15
	 * @description	:
	 * @return 		: void
	 * @param vacntn
	 */
	public void insertVacntnRcord(VacntnRcordVO vacntn);

	/**
	 * @MethodName	: getVacntnIctsdDtl
	 * @author		: Boyoung
	 * @date 		: 2024.11.15
	 * @description	: 전염병명 별 상세보기 
	 * @return 		: List<VacntnRcordVO>
	 * @param param
	 * @return
	 */
	public List<VacntnRcordVO> getVacntnIctsdDtl(Map<String, String> param);

}
