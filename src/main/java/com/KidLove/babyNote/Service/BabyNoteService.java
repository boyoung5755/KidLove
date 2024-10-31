package com.KidLove.babyNote.Service;

import org.springframework.http.ResponseEntity;

import com.KidLove.chldrn.vo.ChldrnVO;
import com.KidLove.comm.vo.ResultVO;

public interface BabyNoteService {

	ResponseEntity<ResultVO<Object>> getBabyNote(ChldrnVO chldrnRequest);

}
