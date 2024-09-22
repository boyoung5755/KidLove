/**
 * 
 */
package com.KidLove.auth.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.KidLove.mber.vo.MberVO;

/**
 * @packageName	: com.KidLove.auth.dao
 * @since		: 2024.08.19
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.08.19		Boyoung			최초생성
 */

@Mapper
public interface AuthDAO {
	
	
	public MberVO  findOneWithAuthoritiesByUserId(@Param("mberId") String mberId);

	public int saveToken(MberVO mberVO);
	

}
