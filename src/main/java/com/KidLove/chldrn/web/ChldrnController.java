package com.KidLove.chldrn.web;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.chldrn.service.ChldrnService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/chldrn")
@RequiredArgsConstructor
public class ChldrnController {
	
	@Inject
	private final ChldrnService chldrnService;
	

}
