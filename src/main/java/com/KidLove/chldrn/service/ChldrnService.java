package com.KidLove.chldrn.service;

import org.springframework.http.ResponseEntity;

import com.KidLove.chldrn.vo.ChldrnVO;
import com.KidLove.comm.vo.ResultVO;

public interface ChldrnService {
	ResponseEntity<ResultVO<Object>> createChldrnInfo(ChldrnVO chldrnRequest);
}
