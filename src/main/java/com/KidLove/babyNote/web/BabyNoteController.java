package com.KidLove.babyNote.web;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.babyNote.Service.BabyNoteService;
import com.KidLove.comm.vo.ResultVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/babyNote")
@RequiredArgsConstructor
public class BabyNoteController {
	
	@Inject
	private final BabyNoteService babyNoteService;


	@GetMapping("/getVacntnIctsdDtl")
	public ResponseEntity<ResultVO<Object>> getVacntnIctsdDtl(@RequestParam  Map<String, String> param) {
		try {
			return babyNoteService.getVacntnIctsdDtl(param );
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	
	@GetMapping("/getBabyNote")
	public ResponseEntity<ResultVO<Object>> getBabyNote(@RequestParam("chldrnNo")  String chldrnNo) {
		try {
			return babyNoteService.getBabyNote(chldrnNo );
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
	}
	
	@PostMapping("/createVacntnRecord")
    public ResponseEntity<ResultVO<Object>> createVacntnRecord(@RequestBody  Map<String, String> param) {
		try {
			return babyNoteService.createVacntnRecord(param );
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
    }

}
