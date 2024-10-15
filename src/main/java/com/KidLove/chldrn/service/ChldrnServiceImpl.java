package com.KidLove.chldrn.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.KidLove.chldrn.dao.ChldrnDAO;

@Service
public class ChldrnServiceImpl implements ChldrnService {
	
	@Inject
	private ChldrnDAO chldrnDAO;

}
