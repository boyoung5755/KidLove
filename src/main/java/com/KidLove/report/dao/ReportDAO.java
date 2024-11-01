/**
 * 
 */
package com.KidLove.report.dao;

import org.apache.ibatis.annotations.Mapper;

import com.KidLove.chldrn.vo.SleepVO;

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

}
