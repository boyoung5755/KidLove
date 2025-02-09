/**
 * 
 */
package com.KidLove.report.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
				
			String makeFileCode = RandomStringGenerator.generateRandomString(15);
			
			ChldrnSymptmsVO chldrnSymptms = ChldrnSymptmsVO.builder()
					.chldrnNo(Long.parseLong(param.get("chldrnNo"))) 
					.symptmsBgndt(LocalDateTime.parse(param.get("symptmsBgndt"), formatter))
					.symptmsEnddt(LocalDateTime.parse(param.get("symptmsEnddt"), formatter))
					.symptmsNo(userSymptms)
					.symptmsVisitdt(LocalDateTime.parse(param.get("symptmsVisitdt"), formatter))
					.hsptlNo(Long.parseLong(param.get("hsptlNo")))
					.atchCode(makeFileCode)
					.symptmsSeverity(param.get("symptmsSeverity"))
					.build();
			
			reportDAO.insertChldrnSymptms(chldrnSymptms);
			
			SymptmsFrsaidVO symptmsFrsaid = SymptmsFrsaidVO.builder()
					.chldrnSymptmsNo(chldrnSymptms.getChldrnSymptmsNo())
					.frsaidCn(param.get("frsaidCn"))
					.build();
			
			HsptlVO hsptl = HsptlVO.builder()
					.hsptlDrctr(param.get("hsptlDrctr"))
					.id(Long.parseLong(param.get("hsptlNo")))
					.chldrnSymptmsNo(chldrnSymptms.getChldrnSymptmsNo())
					.build();
			
			mdexmnDAO.insertHsptl(hsptl);
			
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
	public ResponseEntity<ResultVO<Object>> getBabyHome(Map<String, String> param) {
		Map<String, Object> combinedMap =  new HashMap<String, Object>();
		
		int num = Integer.parseInt(param.get("chldrnNo"));
		String mealTy = param.get("mealTy");
		
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
		List<MealVO> meal  = reportDAO.getChldrnMeal(num,mealTy);
		combinedMap.put("meal", meal);
		
		//6.배뇨횟수
		List<UrineVO> urine  = reportDAO.getChldrnUrine(num);
		combinedMap.put("urine", urine);
		
		//7.치료기록  8.약국기록
		MdexmnRcordVO mdexmnRcord = reportDAO.getChldrnMdexmnRcord(num);
		combinedMap.put("mdexmnRcord", mdexmnRcord);
		
		//8.1 처방약목록
		List<PrscrptnDrugVO> prscrptnDrug = reportDAO.getDrugList(num);
		combinedMap.put("prscrptnDrugList", prscrptnDrug);
		
		//9.접종기록
		List<VacntnRcordVO> vacntnRcord = reportDAO.getChldrnVacntnRcord(num);
		combinedMap.put("vacntnRcord", vacntnRcord);
		
		//10.특이사항기록
		List<SignificantVO> significant = reportDAO.getChldrnSignificant(num);
		combinedMap.put("significant", significant);
		
		
		return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",combinedMap));
	}

	@Override
	@Transactional
	public ResponseEntity<ResultVO<Object>> createEmotion(Map<String, String> param) {
		
		try {
			reportDAO.insertEmotion(param);
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",param));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "create Failed", ""));
		}	 
	}

	@Override
	public ResponseEntity<ResultVO<Object>> getTotHist(Map<String, Object> param) {
		
		List<Map<String, Object>>  resultMap =  new ArrayList<>();
		List<Map<String, Object>> scheduleList = new ArrayList<>();
		
		try {
			
			resultMap = reportDAO.getTotHist(param);
			
			String searchDt = (String) param.get("searchDt");
			
			if(! searchDt.equals("")) {
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date searchDate = format.parse(searchDt); 
				resultMap = resultMap.stream()
						.filter(item -> {
							try {
								String itemDate = (String) item.get("date");
								Date itemParsedDate = format.parse(itemDate);
								return !itemParsedDate.after(searchDate); // searchDt 이후의 데이터는 제외
							} catch (ParseException e) {
								return false; // 날짜 형식이 잘못된 경우 제외
							}
						})
						.collect(Collectors.toList());
			}
			
			Map<String, List<Map<String, Object>>> groupedByDate = resultMap.stream()
	                .collect(Collectors.groupingBy(item -> (String) item.get("date")));
			
			for (Map.Entry<String, List<Map<String, Object>>> entry : groupedByDate.entrySet()) {
	            String date = entry.getKey();
	            List<Map<String, Object>> items = entry.getValue();

	            // 날짜를 '일요일' 같은 형식으로 변환하는 부분
	            String dayOfWeek = getDayOfWeek(date); 

	            // 각 날짜에 대해 schedule 항목 생성
	            Map<String, Object> scheduleItem = new HashMap<>();
	            scheduleItem.put("date", date);
	            scheduleItem.put("dayOfWeek", dayOfWeek);
	            scheduleItem.put("items", items);

	            // scheduleList에 추가
	            scheduleList.add(scheduleItem);
	        }
			
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK, "success", scheduleList));
			
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "create Failed", ""));
		}	 
	}
	
	
	private String getDayOfWeek(String date) {
	    try {
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date parsedDate = format.parse(date);

	        SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE", Locale.KOREAN); // 한글 요일
	        return dayOfWeekFormat.format(parsedDate);
	    } catch (ParseException e) {
	        return "Unknown"; // 날짜 형식이 잘못된 경우
	    }
	}


}
