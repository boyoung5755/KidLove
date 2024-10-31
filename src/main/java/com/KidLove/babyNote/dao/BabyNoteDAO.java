package com.KidLove.babyNote.dao;

import org.apache.ibatis.annotations.Mapper;

import com.KidLove.chldrn.vo.ChldrnVO;
import com.KidLove.comm.vo.VacntnVO;

@Mapper
public interface BabyNoteDAO {

	public VacntnVO getBabyNote(ChldrnVO chldrnRequest);

}
