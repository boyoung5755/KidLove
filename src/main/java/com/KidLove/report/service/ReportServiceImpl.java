/**
 * 
 */
package com.KidLove.report.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KidLove.chldrn.vo.BdHeatVO;
import com.KidLove.chldrn.vo.ChldrnInfoVO;
import com.KidLove.chldrn.vo.ChldrnSymptmsVO;
import com.KidLove.chldrn.vo.ChldrnVO;
import com.KidLove.chldrn.vo.MealVO;
import com.KidLove.chldrn.vo.SleepVO;
import com.KidLove.chldrn.vo.SymptmsFrsaidVO;
import com.KidLove.chldrn.vo.SymptmsVO;
import com.KidLove.chldrn.vo.TakngVO;
import com.KidLove.chldrn.vo.UrineVO;
import com.KidLove.comm.utils.RandomStringGenerator;
import com.KidLove.comm.utils.SQLErrorMessage;
import com.KidLove.comm.vo.HsptlVO;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.mdexmn.dao.MdexmnDAO;
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
	private MdexmnDAO mdexmnDAO;
	
	@Inject
	private SQLErrorMessage sqlErrorMessage;
	
	private  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  
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

	@Override
	@Transactional
	public ResponseEntity<ResultVO<Object>> createSymptms(Map<String, String> param) {
		try {
			
			Long userSymptms ;
			if( ! param.get("symptms").isEmpty()) {
				SymptmsVO symptms = SymptmsVO.builder()
						.symptmsNm(param.get("symptms"))
						.build();
				
				reportDAO.insertSymptms(symptms);
				userSymptms = symptms.getSymptmsNo();
				
			}else {
				userSymptms = Long.parseLong(param.get("symptmsNo"));
			}
			
			Long userHsptlNo;
			if( param.get("hsptlNo").isEmpty()) {
				
				HsptlVO hsptl = HsptlVO.builder()
						.hsptlNm(param.get("hsptlNm"))
						.hsptlDrctr(param.get("hsptlDrctr"))
						.hsptlAddr(param.get("hsptlAddr"))
						.build();
				
				mdexmnDAO.insertHsptl(hsptl);
				userHsptlNo = hsptl.getHsptlNo();
				
			}else {
				userHsptlNo = Long.parseLong(param.get("hsptlNo"));
			}
			
			String makeFileCode = RandomStringGenerator.generateRandomString(15);
			
			ChldrnSymptmsVO chldrnSymptms = ChldrnSymptmsVO.builder()
					.chldrnNo(Long.parseLong(param.get("chldrnNo"))) 
					.symptmsBgndt(LocalDateTime.parse(param.get("symptmsBgndt"), formatter))
					.symptmsEnddt(LocalDateTime.parse(param.get("symptmsEnddt"), formatter))
					.symptmsNo(userSymptms)
					.symptmsVisitdt(LocalDateTime.parse(param.get("symptmsVisitdt"), formatter))
					.hsptlNo(userHsptlNo)
					.atchCode(makeFileCode)
					.build();
			
			reportDAO.insertChldrnSymptms(chldrnSymptms);
			
			SymptmsFrsaidVO symptmsFrsaid = SymptmsFrsaidVO.builder()
					.chldrnSymptmsNo(chldrnSymptms.getChldrnSymptmsNo())
					.frsaidCn(param.get("frsaidCn"))
					.build();
			
			reportDAO.insertSymptmsFrsaid(symptmsFrsaid);
			
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",param));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "create Failed", ""));
		}	 
	}

	@Override
	public ResponseEntity<ResultVO<Object>> getBabyHome(String chldrnNo) {
		Map<String, Object> combinedMap =  new HashMap<String, Object>();
		
		int num = Integer.parseInt(chldrnNo);
		
		//1.아이정보
		ChldrnVO chldrn = reportDAO.getChldrnInfo(num);
		combinedMap.put("info", chldrn);
		
		//2.아이증상
		List<SymptmsVO> symptms = reportDAO.getChldrnSymptms(num);
		combinedMap.put("symptms", symptms);
		
		//3.체온기록
		List<BdHeatVO>  bdHeat = reportDAO.getChldrnBdHeat(num);
		combinedMap.put("bdHeat", bdHeat);
		
		//4.수면패턴
		List<SleepVO> sleep = reportDAO.getChldrnSleep(num);
		combinedMap.put("sleep", sleep);
		
		//5.식사패턴
		//6.배뇨횟수
		//7.치료기록
		//8.약국기록
		//9.접종기록
		//10.특이사항기록
		
		return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",combinedMap));
	}

}
