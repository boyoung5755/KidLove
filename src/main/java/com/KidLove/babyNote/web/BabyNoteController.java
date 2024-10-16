package com.KidLove.babyNote.web;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KidLove.babyNote.Service.BabyNoteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/babyNote")
@RequiredArgsConstructor
public class BabyNoteController {
	
	@Inject
	private final BabyNoteService babyNoteService;

}
