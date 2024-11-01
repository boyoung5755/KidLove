/**
 * 
 */
package com.KidLove.report.service;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KidLove.chldrn.vo.SleepVO;
import com.KidLove.comm.utils.SQLErrorMessage;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.report.dao.ReportDAO;

/**
 * @packageName	: com.KidLove.report.service
 * @since		: 2024.11.01
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.01		Boyoung			최초생성
 */

@Service
public class ReportServiceImpl implements ReportService {
	
	@Inject
	private ReportDAO  reportDAO;
	
	@Inject
	private SQLErrorMessage sqlErrorMessage;
  
	@Override
	@Transactional
	public ResponseEntity<ResultVO<Object>> createSleepHist(SleepVO sleep) {
		try {
			reportDAO.insertSleepHist(sleep);
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",sleep));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "create Failed", ""));
		}	 
	}

}
