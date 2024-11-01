/**
 * 
 */
package com.KidLove.report.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.chldrn.vo.SleepVO;
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
	
	
	@PostMapping("/createSleepHist")
    public ResponseEntity<ResultVO<Object>> createSleepHist( @RequestBody SleepVO sleep) {
		try {
			return reportService.createSleepHist(sleep);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
    }
}
