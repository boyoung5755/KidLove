/**
 * 
 */
package com.KidLove.report.web;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.chldrn.vo.BdHeatVO;
import com.KidLove.chldrn.vo.ChldrnInfoVO;
import com.KidLove.chldrn.vo.MealVO;
import com.KidLove.chldrn.vo.SleepVO;
import com.KidLove.chldrn.vo.TakngVO;
import com.KidLove.chldrn.vo.UrineVO;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.report.service.ReportService;

import lombok.AllArgsConstructor;

/**
 * @packageName	: com.KidLove.report.web
 * @since		: 2024.11.01
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.01		Boyoung			최초생성
 */

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/report")
public class ReportController {

	private final ReportService  reportService;
	
	
	@GetMapping("/getBabyHome")
	public ResponseEntity<ResultVO<Object>> getBabyHome ( @RequestParam("chldrnNo")  String chldrnNo) {
		try {
			return reportService.getBabyHome(chldrnNo);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	} 
	
	
	@PostMapping("/createSymptms")
	public ResponseEntity<ResultVO<Object>> createSymptms (@RequestBody Map<String, String> param) {
		try {
			return reportService.createSymptms(param);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	} 
	
	
	@DeleteMapping("/removeRecord")
	public ResponseEntity<ResultVO<Object>> removeRecord (@RequestBody Map<String, Object> paramMap) {
		try {
			return reportService.removeRecord(paramMap);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	
	@PostMapping("/createMealHist")
	public ResponseEntity<ResultVO<Object>> createMealHist ( @RequestBody MealVO meal) {
		try {
			return reportService.createMealHist(meal);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	@PostMapping("/createTakngHist")
	public ResponseEntity<ResultVO<Object>> createTakngHist ( @RequestBody TakngVO takng) {
		try {
			return reportService.createTakngHist(takng);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	@PostMapping("/createbdHeatHist")
	public ResponseEntity<ResultVO<Object>> createbdHeatHist( @RequestBody BdHeatVO heat) {
		try {
			return reportService.createbdHeatHist(heat);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	@PostMapping("/createUrineHist")
	public ResponseEntity<ResultVO<Object>> createUrineHist( @RequestBody UrineVO urine) {
		try {
			return reportService.createUrineHist(urine);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	@PostMapping("/createSleepHist")
    public ResponseEntity<ResultVO<Object>> createSleepHist( @RequestBody SleepVO sleep) {
		try {
			return reportService.createSleepHist(sleep);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
    }
	
	@PostMapping("/createHeWgh")
	public ResponseEntity<ResultVO<Object>> createHeWgh( @RequestBody ChldrnInfoVO info) {
		try {
			return reportService.createHeWgh(info);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	@GetMapping("/getRecentHeWghList")
	public ResponseEntity<ResultVO<Object>> getRecentHeWghList( @RequestParam("chldrnNo")  String chldrnNo) {
		try {
			return reportService.getRecentHeWghList(chldrnNo);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	@GetMapping("/getRecentSleepList")
	public ResponseEntity<ResultVO<Object>> getRecentSleepList( @RequestParam("chldrnNo")  String chldrnNo) {
		try {
			return reportService.getRecentSleepList(chldrnNo);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	@GetMapping("/getRecentUrineList")
	public ResponseEntity<ResultVO<Object>> getRecentUrineList( @RequestParam("chldrnNo")  String chldrnNo) {
		try {
			return reportService.getRecentUrineList(chldrnNo);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	@GetMapping("/getRecentMealList")
	public ResponseEntity<ResultVO<Object>> getRecentMealList( @RequestParam("chldrnNo")  String chldrnNo) {
		try {
			return reportService.getRecentMealList(chldrnNo);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	@GetMapping("/getRecentBdHeatList")
	public ResponseEntity<ResultVO<Object>> getRecentBdHeatList( @RequestParam("chldrnNo")  String chldrnNo) {
		try {
			return reportService.getRecentBdHeatList(chldrnNo);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	@GetMapping("/getRecentTakngList")
	public ResponseEntity<ResultVO<Object>> getRecentTakngList( @RequestParam("chldrnNo")  String chldrnNo) {
		try {
			return reportService.getRecentTakngList(chldrnNo);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
}
