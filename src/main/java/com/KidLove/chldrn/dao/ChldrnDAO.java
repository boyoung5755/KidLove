package com.KidLove.chldrn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.KidLove.chldrn.vo.ChldrnAllrgyVO;
import com.KidLove.chldrn.vo.ChldrnInfoVO;
import com.KidLove.chldrn.vo.ChldrnMemoVO;
import com.KidLove.chldrn.vo.ChldrnSymptmsVO;
import com.KidLove.chldrn.vo.ChldrnVO;

@Mapper
public interface ChldrnDAO {

	public void insertChldrn(ChldrnVO chdlrn);

	public void insertChldrnInfo(ChldrnInfoVO chldrnInfo);

	public Long getAllergyIdByName(@Param("allergyNm") String allergy);

	public Long insertAllergy(@Param("allergyNm") String allergy);

	public void insertChldrnAllergy(ChldrnAllrgyVO chldrnAllrgy);

	public Long getSymptmsIdByName(@Param("symptmsNm") String symptms);

	public Long insertSymptms(@Param("symptmsNm") String symptms);

	public void insertChldrnSymptms(ChldrnSymptmsVO chldrnSymptms);

	public void insertChldrnMemo(ChldrnMemoVO memo);

}
