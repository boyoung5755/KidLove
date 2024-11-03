/**
 * 
 */
package com.KidLove.report.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KidLove.chldrn.vo.BdHeatVO;
import com.KidLove.chldrn.vo.ChldrnInfoVO;
import com.KidLove.chldrn.vo.MealVO;
import com.KidLove.chldrn.vo.SleepVO;
import com.KidLove.chldrn.vo.TakngVO;
import com.KidLove.chldrn.vo.UrineVO;
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
	
	@Transactional
	@Override
	public ResponseEntity<ResultVO<Object>> createHeWgh(ChldrnInfoVO info) {
		try {
			reportDAO.insertHeWgh(info);
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",info));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "create Failed", ""));
		}	 
	}

	@Override
	public ResponseEntity<ResultVO<Object>> getRecentHeWghList(String chldrnNo) {
		try {
			Long chldrn = Long.parseLong(chldrnNo);
			List<ChldrnInfoVO> infoVO  =  reportDAO.getRecentHeWghList(chldrn);
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",infoVO));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "retrieve Failed", ""));
		}	 
	}

	@Transactional
	@Override
	public ResponseEntity<ResultVO<Object>> createUrineHist(UrineVO urine) {
		try {
			reportDAO.insertUrine(urine);
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",urine));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "create Failed", ""));
		}	 
	}
	
	@Transactional
	@Override
	public ResponseEntity<ResultVO<Object>> createMealHist(MealVO meal) {
		try {
			reportDAO.insertMeal(meal);
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",meal));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "create Failed", ""));
		}	 
	}

	@Override
	public ResponseEntity<ResultVO<Object>> getRecentSleepList(String chldrnNo) {
		try {
			Long chldrn = Long.parseLong(chldrnNo);
			List<SleepVO> sleep  =  reportDAO.getRecentSleepList(chldrn);
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",sleep));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "retrieve Failed", ""));
		}	 
	}

	@Override
	public ResponseEntity<ResultVO<Object>> getRecentUrineList(String chldrnNo) {
		try {
			Long chldrn = Long.parseLong(chldrnNo);
			List<UrineVO> urine  =  reportDAO.getRecentUrineList(chldrn);
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",urine));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "retrieve Failed", ""));
		}	 
	}

	@Override
	public ResponseEntity<ResultVO<Object>> getRecentMealList(String chldrnNo) {
		try {
			Long chldrn = Long.parseLong(chldrnNo);
			List<MealVO> meal  =  reportDAO.getRecentMealList(chldrn);
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",meal));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "retrieve Failed", ""));
		}	 
	}

	@Override
	@Transactional
	public ResponseEntity<ResultVO<Object>> removeRecord(Map<String, Object> paramMap) {
		try {
			String table = (String)paramMap.get("type");
			
			Long pk;
	        Object deletePkValue = paramMap.get("deletePk");
	        
	        if (deletePkValue instanceof Integer) {
	            pk = ((Integer) deletePkValue).longValue();
	        } else if (deletePkValue instanceof Long) {
	            pk = (Long) deletePkValue;
	        } else {
	            pk = Long.parseLong((String) deletePkValue);
	        }
			
			// 수면, 배변, 수유,체온,성장
			switch (table) {
			case "수면":
				table = "sleep";
				break;
			case "배변":
				table = "urine";
				break;
			case "수유":
				table = "meal";
				break;
			case "체온":
				table = "bdheat";
				break;
			case "성장":
				table = "chldrn_info";
				break;
			case "복용":
				table = "takng";
				break;
			default:
				break;
			}
			reportDAO.deleteRecord(table,pk);
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",table+" remove"));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "remove Failed", ""));
		}	 
	}
	
	@Transactional
	@Override
	public ResponseEntity<ResultVO<Object>> createbdHeatHist(BdHeatVO heat) {
		try {
			reportDAO.insertBdHeat(heat);
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",heat));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "create Failed", ""));
		}	 
	}

	@Override
	public ResponseEntity<ResultVO<Object>> getRecentBdHeatList(String chldrnNo) {
		try {
			Long chldrn = Long.parseLong(chldrnNo);
			List<BdHeatVO> heat  =  reportDAO.getRecentBdHeatList(chldrn);
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",heat));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "retrieve Failed", ""));
		}	 
	}

	@Override
	@Transactional
	public ResponseEntity<ResultVO<Object>> createTakngHist(TakngVO takng) {
		try {
			reportDAO.insertTakngHist(takng);
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",takng));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "create Failed", ""));
		}	 
	}

	@Override
	public ResponseEntity<ResultVO<Object>> getRecentTakngList(String chldrnNo) {
		try {
			Long chldrn = Long.parseLong(chldrnNo);
			List<TakngVO> takng  =  reportDAO.getRecentTakngList(chldrn);
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",takng));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "retrieve Failed", ""));
		}	 
	}

}
