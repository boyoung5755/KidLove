package com.KidLove.chldrn.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.chldrn.dto.ChldrnProfileRequest;
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
    		@RequestBody ChldrnProfileRequest chldrnRequest) {
		try {
			return chldrnService.createChldrnInfo(chldrnRequest );
		} catch (Exception e) {
			return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST,e.getMessage(),""));	
		}
    }
	

}
