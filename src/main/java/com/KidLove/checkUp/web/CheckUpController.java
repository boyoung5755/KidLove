package com.KidLove.checkUp.web;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.checkUp.service.CheckUpService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/checkUp")
@RequiredArgsConstructor
public class CheckUpController {
	
	@Inject
	private final CheckUpService checkUpService;
}
