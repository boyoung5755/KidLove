/**
 * 
 */
package com.KidLove.auth.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.KidLove.mber.vo.MberVO;

@Mapper
public interface AuthDAO {
	
	
	public MberVO  findOneWithAuthoritiesByUserId(@Param("mberId") String mberId);

	public int saveToken(MberVO mberVO);

	public String findByKey(@Param("mberId") String mberId);


	

}
