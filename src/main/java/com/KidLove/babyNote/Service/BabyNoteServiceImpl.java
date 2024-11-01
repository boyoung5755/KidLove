package com.KidLove.babyNote.Service;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.KidLove.babyNote.dao.BabyNoteDAO;
import com.KidLove.chldrn.vo.ChldrnVO;
import com.KidLove.comm.utils.SQLErrorMessage;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.comm.vo.VacntnVO;

@Service
public class BabyNoteServiceImpl implements BabyNoteService {
	
	@Inject
	private BabyNoteDAO babyNoteDAO;
	
	@Inject
	private SQLErrorMessage sqlErrorMessage;

	@Override
	public ResponseEntity<ResultVO<Object>> getBabyNote(ChldrnVO chldrnRequest) {
		try {
			VacntnVO  vacntnVO = babyNoteDAO.getBabyNote(chldrnRequest);
			return  ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",vacntnVO));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		}catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "create Failed", ""));
		}	 
	}

}
