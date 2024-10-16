package com.KidLove.chldrn.service;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KidLove.chldrn.dao.ChldrnDAO;
import com.KidLove.chldrn.vo.ChldrnVO;
import com.KidLove.comm.vo.ResultVO;

@Service
public class ChldrnServiceImpl implements ChldrnService {
	
	@Inject
	private ChldrnDAO chldrnDAO;
	
	
	@Transactional
	@Override
	public ResponseEntity<ResultVO<Object>> createChldrnInfo(ChldrnVO chldrnRequest ) {
		try {
			System.out.println(chldrnRequest);
			return null;
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException("Failed to create user", e);
		} 
	}

}
