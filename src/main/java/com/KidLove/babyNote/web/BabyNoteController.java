package com.KidLove.babyNote.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.babyNote.Service.BabyNoteService;
import com.KidLove.chldrn.vo.ChldrnVO;
import com.KidLove.comm.vo.ResultVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/babyNote")
@RequiredArgsConstructor
public class BabyNoteController {
	
	@Inject
	private final BabyNoteService babyNoteService;
	
	
	@GetMapping("/getBabyNote")
    public ResponseEntity<ResultVO<Object>> getBabyNote(@ModelAttribute  ChldrnVO chldrnRequest) {
		try {
			return babyNoteService.getBabyNote(chldrnRequest );
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
    }

}
