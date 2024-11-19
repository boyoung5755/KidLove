/**
 * 
 */
package com.KidLove.report.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.KidLove.babyNote.vo.VacntnRcordVO;
import com.KidLove.checkUp.vo.MdexmnRcordVO;
import com.KidLove.checkUp.vo.PrscrptnDrugVO;
import com.KidLove.chldrn.vo.BdHeatVO;
import com.KidLove.chldrn.vo.ChldrnInfoVO;
import com.KidLove.chldrn.vo.ChldrnSymptmsVO;
import com.KidLove.chldrn.vo.ChldrnVO;
import com.KidLove.chldrn.vo.MealVO;
import com.KidLove.chldrn.vo.SignificantVO;
import com.KidLove.chldrn.vo.SleepVO;
import com.KidLove.chldrn.vo.SymptmsFrsaidVO;
import com.KidLove.chldrn.vo.SymptmsVO;
import com.KidLove.chldrn.vo.TakngVO;
import com.KidLove.chldrn.vo.UrineVO;

/**
 * @packageName	: com.KidLove.report.dao
 * @since		: 2024.11.01
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.01		Boyoung			최초생성
 */

@Mapper
public interface ReportDAO {

	/**
	 * @MethodName	: insertSleepHist
	 * @author		: Boyoung
	 * @date 		: 2024.11.01
	 * @description	:
	 * @return 		: void
	 * @param sleep
	 */
	public void insertSleepHist(SleepVO sleep);

	/**
	 * @MethodName	: insertHeWgh
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	:
	 * @return 		: void
	 * @param info
	 */
	
	public void insertHeWgh(ChldrnInfoVO info);

	/**
	 * @MethodName	: getRecentHeWgh
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	:
	 * @return 		: ChldrnInfoVO
	 * @param chldrnNo
	 * @return
	 */
	
	public List<ChldrnInfoVO> getRecentHeWghList(@Param("chldrn") Long chldrn);

	/**
	 * @MethodName	: insertUrine
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	:
	 * @return 		: void
	 * @param urine
	 */
	
	public void insertUrine(UrineVO urine);

	/**
	 * @MethodName	: insertMeal
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	:
	 * @return 		: void
	 * @param meal
	 */
	
	public void insertMeal(MealVO meal);

	/**
	 * @MethodName	: getRecentSleepList
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	:
	 * @return 		: List<SleepVO>
	 * @param chldrn
	 * @return
	 */
	
	public List<SleepVO> getRecentSleepList(@Param("chldrn") Long chldrn);

	/**
	 * @MethodName	: getRecentUrineList
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	:
	 * @return 		: List<UrineVO>
	 * @param chldrn
	 * @return
	 */
	
	public List<UrineVO> getRecentUrineList(@Param("chldrn")Long chldrn);

	/**
	 * @MethodName	: getRecentMealList
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	:
	 * @return 		: List<MealVO>
	 * @param chldrn
	 * @return
	 */
	
	public List<MealVO> getRecentMealList(@Param("chldrn") Long chldrn);

	/**
	 * @MethodName	: deleteRecord
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	:
	 * @return 		: void
	 * @param table
	 * @param pk
	 */
	
	public void deleteRecord(@Param("table") String table, @Param("pk") Long pk);

	/**
	 * @MethodName	: insertBdHeat
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	:
	 * @return 		: void
	 * @param heat
	 */
	
	public void insertBdHeat(BdHeatVO heat);

	/**
	 * @MethodName	: getRecentBdHeatList
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	:
	 * @return 		: List<BdHeatVO>
	 * @param chldrn
	 * @return
	 */
	
	public List<BdHeatVO> getRecentBdHeatList(@Param("chldrn") Long chldrn);
	
	/**
	 * @MethodName	: insertTakngHist
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	:
	 * @return 		: void
	 * @param takng
	 */
	
	public void insertTakngHist(TakngVO takng);

	/**
	 * @MethodName	: getRecentTakngList
	 * @author		: Boyoung
	 * @date 		: 2024.11.03
	 * @description	:
	 * @return 		: List<TakngVO>
	 * @param chldrn
	 * @return
	 */
	
	public List<TakngVO> getRecentTakngList(@Param("chldrn") Long chldrn);

	/**
	 * @MethodName	: insertSymptms
	 * @author		: Boyoung
	 * @date 		: 2024.11.18
	 * @description	: 사용자 증상 등록
	 * @return 		: void
	 * @param symptms
	 */
	public void insertSymptms(SymptmsVO symptms);

	/**
	 * @MethodName	: insertChldrnSymptms
	 * @author		: Boyoung
	 * @date 		: 2024.11.18
	 * @description	: 자녀증상등록
	 * @return 		: void
	 * @param chldrnSymptms
	 */
	public void insertChldrnSymptms(ChldrnSymptmsVO chldrnSymptms);

	/**
	 * @MethodName	: insertSymptmsFrsaid
	 * @author		: Boyoung
	 * @date 		: 2024.11.18
	 * @description	: 증상응급처치 등록
	 * @return 		: void
	 * @param symptmsFrsaid
	 */
	public void insertSymptmsFrsaid(SymptmsFrsaidVO symptmsFrsaid);


	/**
	 * @MethodName	: getChldrnInfo
	 * @author		: Boyoung
	 * @date 		: 2024.11.18
	 * @description	: 아이정보
	 * @return 		: ChldrnVO
	 * @param int1
	 * @return
	 */
	public ChldrnVO getChldrnInfo(@Param("chldrnNo") int chldrnNo);

	/**
	 * @MethodName	: getChldrnSymptms
	 * @author		: Boyoung
	 * @date 		: 2024.11.18
	 * @description	:
	 * @return 		: SymptmsVO
	 * @param num
	 * @return
	 */
	public List<SymptmsVO> getChldrnSymptms(@Param("chldrnNo") int chldrnNo);

	/**
	 * @MethodName	: getChldrnBdHeat
	 * @author		: Boyoung
	 * @date 		: 2024.11.18
	 * @description	:
	 * @return 		: BdHeatVO
	 * @param num
	 * @return
	 */
	public List<BdHeatVO> getChldrnBdHeat(@Param("chldrnNo") int chldrnNo);

	/**
	 * @MethodName	: getChldrnSleep
	 * @author		: Boyoung
	 * @date 		: 2024.11.18
	 * @description	:
	 * @return 		: List<SleepVO>
	 * @param num
	 * @return
	 */
	public List<SleepVO> getChldrnSleep(@Param("chldrnNo") int chldrnNo);

	/**
	 * @MethodName	: getChlrnMeal
	 * @author		: Boyoung
	 * @param mealTy 
	 * @date 		: 2024.11.19
	 * @description	:
	 * @return 		: List<MealVO>
	 * @param num
	 * @return
	 */
	public List<MealVO> getChldrnMeal(@Param("chldrnNo") int chldrnNo,@Param("mealTy") String mealTy);

	/**
	 * @MethodName	: getChldrnUrine
	 * @author		: Boyoung
	 * @date 		: 2024.11.19
	 * @description	:
	 * @return 		: List<UrineVO>
	 * @param num
	 * @return
	 */
	public List<UrineVO> getChldrnUrine(int num);

	/**
	 * @MethodName	: getChldrnMdexmnRcord
	 * @author		: Boyoung
	 * @date 		: 2024.11.19
	 * @description	:
	 * @return 		: MdexmnRcordVO
	 * @param num
	 * @return
	 */
	public MdexmnRcordVO getChldrnMdexmnRcord(@Param("chldrnNo") int chldrnNo);

	/**
	 * @MethodName	: getDrugList
	 * @author		: Boyoung
	 * @date 		: 2024.11.19
	 * @description	:
	 * @return 		: List<PrscrptnDrugVO>
	 * @param num
	 * @return
	 */
	public List<PrscrptnDrugVO> getDrugList(@Param("chldrnNo") int chldrnNo);

	/**
	 * @MethodName	: getChldrnVacntnRcord
	 * @author		: Boyoung
	 * @date 		: 2024.11.19
	 * @description	:
	 * @return 		: List<VacntnRcordVO>
	 * @param num
	 * @return
	 */
	public List<VacntnRcordVO> getChldrnVacntnRcord(@Param("chldrnNo") int chldrnNo);

	/**
	 * @MethodName	: getChldrnSignificant
	 * @author		: Boyoung
	 * @date 		: 2024.11.19
	 * @description	:
	 * @return 		: List<SignificantVO>
	 * @param num
	 * @return
	 */
	public List<SignificantVO> getChldrnSignificant(@Param("chldrnNo") int chldrnNo);

	

}
