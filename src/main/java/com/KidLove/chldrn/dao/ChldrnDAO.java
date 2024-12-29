package com.KidLove.chldrn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.KidLove.chldrn.vo.ChldrnAllrgyVO;
import com.KidLove.chldrn.vo.ChldrnInfoVO;
import com.KidLove.chldrn.vo.ChldrnMemoVO;
import com.KidLove.chldrn.vo.ChldrnSymptmsVO;
import com.KidLove.chldrn.vo.ChldrnVO;
import com.KidLove.chldrn.vo.SymptmsVO;
import com.KidLove.comm.vo.AllrgyVO;
import com.KidLove.comm.vo.HsptlVO;
import com.KidLove.comm.vo.VacntnVO;
import com.KidLove.mber.vo.MberVO;

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
	
	public ChldrnVO selectChldrnProfileInfo(Map<String, Object> map);

	public List<MberVO> selectParentInfo(Map<String, Object> map);
	
	public List<VacntnVO> selectChldrnVacntn(Map<String, Object> map);

	public List<AllrgyVO> selectAllrgyInfo(Map<String, Object> map);

	public List<SymptmsVO> selectSymptmsInfo(Map<String, Object> map);

	public HsptlVO selectHsptlInfo(Map<String, Object> map);

}
