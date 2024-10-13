package com.KidLove.atch.dao;

import org.apache.ibatis.annotations.Mapper;

import com.KidLove.atch.vo.AtchVO;

@Mapper
public interface AtchDAO {

	public void save(AtchVO makeAtch);

	

}
