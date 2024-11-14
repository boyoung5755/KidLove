/**
 * 
 */
package com.KidLove.mdexmn.web;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.KidLove.comm.vo.PageVO;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.mdexmn.service.MdexmnService;

import lombok.RequiredArgsConstructor;

/**
 * @packageName	: com.KidLove.mdexmn.web
 * @since		: 2024.11.12
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.12		Boyoung			최초생성
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mdexmn")
public class MdexmnController {
	
	@Inject
	private final MdexmnService mdexmnService;
	
	
	@GetMapping("/getMdexmnRecord")
	public ResponseEntity<ResultVO<Object>> getMdexmnRecord(PageVO page){
		try {
			return mdexmnService.getMdexmnRecord(page);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
		
	}
	
	@GetMapping("/getMdexmnDgnssNmHist")
	public ResponseEntity<ResultVO<Object>> getMdexmnDgnssNmHist(@RequestParam("chldrnNo") String chldrnNo){
		try {
			return mdexmnService.getMdexmnDgnssNmHist(chldrnNo);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
		
	}
	
	@GetMapping("/getHstplHist")
    public ResponseEntity<ResultVO<Object>> getHstplHist(@RequestParam("chldrnNo") String chldrnNo) {
		try {
			return mdexmnService.getHstplHist(chldrnNo);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
    }
	
	@PostMapping("/createMdexmnRecord")
	public ResponseEntity<ResultVO<Object>> createMdexmnRecord(
				@RequestParam Map<String, String> param
				,  @RequestPart(value="file", required = false) MultipartFile file
			){
		try {
			return mdexmnService.createMdexmnRecord(param , file);
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
    }
	

}
