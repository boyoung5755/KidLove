package com.KidLove.atch.dao;

import org.apache.ibatis.annotations.Mapper;

import com.KidLove.atch.vo.AtchVO;

@Mapper
public interface AtchDAO {

	public AtchVO save(AtchVO makeAtch);

}
