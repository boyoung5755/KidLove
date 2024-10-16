package com.KidLove.chldrn.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.chldrn.service.ChldrnService;
import com.KidLove.chldrn.vo.ChldrnVO;
import com.KidLove.comm.vo.ResultVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/chldrn")
@RequiredArgsConstructor
public class ChldrnController {
	
	@Inject
	private final ChldrnService chldrnService;
	
	@PostMapping("/createChldrnInfo")
    public ResponseEntity<ResultVO<Object>> createChldrnInfo(
    		@RequestBody ChldrnVO chldrnRequest , Authentication auth) {
		try {
			System.out.println(auth);
			ResponseEntity<ResultVO<Object>> result = chldrnService.createChldrnInfo(chldrnRequest );
			return result;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(ResultVO.res(HttpStatus.BAD_REQUEST, "Failed to create info", ""));
		}
    }
	

}
