package com.KidLove.babyNote.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.KidLove.comm.vo.VacntnVO;

@Mapper
public interface BabyNoteDAO {

	public List<VacntnVO> getBabyNote(@Param("chldrnNo") Long chldrnNo);

}
