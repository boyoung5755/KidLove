/**
 * 
 */
package com.KidLove.hsptl.web;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.comm.vo.HsptlVO;
import com.KidLove.comm.vo.PageVO;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.hsptl.service.HsptlService;

import lombok.RequiredArgsConstructor;

/**
 * @packageName	: com.KidLove.hsptl.web
 * @since		: 2024.11.25
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.25		Boyoung			최초생성
 */


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/data/hsptl")
public class HsptlSaveController {

	@Inject
	private final HsptlService hsptlService;
	
	
	@GetMapping("/getNearHsptl")
	public ResponseEntity<ResultVO<Object>> getNearHsptl(PageVO page){
		try {
			return hsptlService.getNearHsptl(page);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	
	
	@GetMapping("/getHsptlByName")
	public ResponseEntity<ResultVO<Object>> getHsptlByName(PageVO page){
		try {
			return hsptlService.getHsptlByName(page);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	
	
	@GetMapping("/getHsptlByRegion")
	public ResponseEntity<ResultVO<Object>> getHsptlByRegion(PageVO page){
		try {
			return hsptlService.getHsptlByRegion(page);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	
	@GetMapping("/getAllHsptl")
	public ResponseEntity<ResultVO<Object>> getAllHsptl(PageVO page){
		try {
			return hsptlService.getAllHsptl(page);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	@PostMapping("/saveHsptlMdcnc")
	public ResponseEntity<ResultVO<Object>> saveHsptlMdcnc(@RequestBody List<HsptlVO> hsptl){
		try {
			return hsptlService.saveHsptlMdcnc(hsptl);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	
}
