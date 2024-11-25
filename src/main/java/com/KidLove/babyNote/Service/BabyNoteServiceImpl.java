package com.KidLove.babyNote.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.KidLove.babyNote.dao.BabyNoteDAO;
import com.KidLove.babyNote.vo.VacntnRcordVO;
import com.KidLove.comm.utils.SQLErrorMessage;
import com.KidLove.comm.vo.HsptlVO;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.comm.vo.VacntnVO;
import com.KidLove.mdexmn.dao.MdexmnDAO;

@Service
public class BabyNoteServiceImpl implements BabyNoteService {
	
	@Inject
	private BabyNoteDAO babyNoteDAO;
	
	@Inject
	private MdexmnDAO mdexmnDAO;
	
	@Inject
	private SQLErrorMessage sqlErrorMessage;

	@Override
	@Transactional
	public ResponseEntity<ResultVO<Object>> getBabyNote(@RequestParam String chldrnNo) {
		try {
			Long chldrn = Long.parseLong(chldrnNo);
			List<VacntnVO> vacntnVO = babyNoteDAO.getBabyNote(chldrn);
			return  ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",vacntnVO));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		}catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "retrieve Failed", ""));
		}	 
	}

	@Override
	@Transactional
	public ResponseEntity<ResultVO<Object>> createVacntnRecord(Map<String, String> param) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		
		try {
			
			HsptlVO hsptl = new HsptlVO();
			
			VacntnRcordVO vacntn  = VacntnRcordVO.builder()
					.chldrnNo(Long.parseLong(param.get("chldrnNo"))) 
					.vacntnInoclDt(LocalDateTime.parse(param.get("vacntnInoclDt"), formatter)) 
					.vacntnNo(Long.parseLong(param.get("vacntnNo")))
					.hsptlNo(Long.parseLong(param.get("hsptlNo")))
					.build();
			
			babyNoteDAO.insertVacntnRcord(vacntn);
			
			param.put("vacntnRcordNo",String.valueOf(vacntn.getVacntnRcordNo()));
			
			hsptl = HsptlVO.builder()
					.hsptlDrctr(param.get("hsptlDrctr"))
					.id(Long.parseLong(param.get("hsptlNo")))
					.vacntnRcordNo(vacntn.getVacntnRcordNo())
					.build();
			
			mdexmnDAO.insertHsptl(hsptl);
			
			return  ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",param));
			
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		}catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "create Failed", ""));
		}	
	}

	@Override
	public ResponseEntity<ResultVO<Object>> getVacntnIctsdDtl(Map<String, String> param) {
		List<VacntnRcordVO>  vacntnRcord = babyNoteDAO.getVacntnIctsdDtl(param);
		return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",vacntnRcord));
	}

}
