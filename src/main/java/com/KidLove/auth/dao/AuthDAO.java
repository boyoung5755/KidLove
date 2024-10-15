/**
 * 
 */
package com.KidLove.auth.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.KidLove.mber.vo.MberVO;

@Mapper
public interface AuthDAO {
	
	
	public MberVO findOneWithAuthoritiesByUserId(@Param("mberId") String mberId);

	public int saveToken(MberVO mberVO);

	public String findByKey(@Param("mberId") String mberId);

	public void join(MberVO mberVO);

	public String loginWithKakao(@Param("loginId") String loginId);

	public String loginWithGoogle(@Param("loginId") String loginId);

	public void joinSSO(MberVO mberVO);

	public int findMberNo(@Param("mberId") String mberId);

	public void setMberAuthor(@Param("mberNo") int mberNo, @Param("authorNm")String authorNm);



	

}
