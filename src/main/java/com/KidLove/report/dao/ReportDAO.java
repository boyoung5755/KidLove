/**
 * 
 */
package com.KidLove.report.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.KidLove.chldrn.vo.BdHeatVO;
import com.KidLove.chldrn.vo.ChldrnInfoVO;
import com.KidLove.chldrn.vo.MealVO;
import com.KidLove.chldrn.vo.SleepVO;
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

}
