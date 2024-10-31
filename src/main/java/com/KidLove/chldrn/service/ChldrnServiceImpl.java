package com.KidLove.chldrn.service;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KidLove.chldrn.dao.ChldrnDAO;
import com.KidLove.chldrn.dto.ChldrnProfileRequest;
import com.KidLove.chldrn.vo.ChldrnAllrgyVO;
import com.KidLove.chldrn.vo.ChldrnInfoVO;
import com.KidLove.chldrn.vo.ChldrnMemoVO;
import com.KidLove.chldrn.vo.ChldrnSymptmsVO;
import com.KidLove.chldrn.vo.ChldrnVO;
import com.KidLove.comm.utils.RandomStringGenerator;
import com.KidLove.comm.utils.SQLErrorMessage;
import com.KidLove.comm.vo.ResultVO;

@Service
public class ChldrnServiceImpl implements ChldrnService {
	
	@Inject
	private ChldrnDAO chldrnDAO;
	
	@Inject
	private SQLErrorMessage sqlErrorMessage;
	
	@Transactional
	@Override
	public ResponseEntity<ResultVO<Object>> createChldrnInfo(ChldrnProfileRequest chldrnRequest ) {
		try {
			String loginMberId = SecurityContextHolder.getContext().getAuthentication().getName();
			
			String makeFileCode = RandomStringGenerator.generateRandomString(15);
			String makeCnrsCode = RandomStringGenerator.generateRandomString(10);
			
			//1.프로필
			ChldrnVO chdlrn = ChldrnVO.builder()
					.chldrnTy(chldrnRequest.getChldrnTy())
					.chldrnNm(chldrnRequest.getChldrnNm())
					.mberId(loginMberId)
					.atchCode(makeFileCode)
					.cnrsCd(makeCnrsCode)
					.build();
			chldrnDAO.insertChldrn(chdlrn);
			
			//2.정보
			ChldrnInfoVO chldrnInfo = ChldrnInfoVO.builder()
					.chldrnBdwgh(chldrnRequest.getChldrnBdwgh())
					.chldrnHeight(chldrnRequest.getChldrnHeight())
					.chldrnHead(chldrnRequest.getChldrnHead())
					.chldrnNo(chdlrn.getChldrnNo())
					.build();
			chldrnDAO.insertChldrnInfo(chldrnInfo);
			
			//3.알레르기
			for(String allergy : chldrnRequest.getAllrgyNm()) {
				Long allergyId = chldrnDAO.getAllergyIdByName(allergy);
				
				if(allergyId == null) {
					allergyId = chldrnDAO.insertAllergy(allergy);
				}
				
				ChldrnAllrgyVO chldrnAllrgy = ChldrnAllrgyVO.builder()
						.chldrnNo(chdlrn.getChldrnNo())
						.allrgyNo(allergyId)
						.build();
				chldrnDAO.insertChldrnAllergy(chldrnAllrgy);
			}
			
			//4.질환
			for(String symptms : chldrnRequest.getSymptmsNm()) {
				Long symptmsId = chldrnDAO.getSymptmsIdByName(symptms);
				
				if(symptmsId == null) {
					symptmsId = chldrnDAO.insertSymptms(symptms);
				}
				
				ChldrnSymptmsVO chldrnSymptms = ChldrnSymptmsVO.builder()
						.chldrnNo(chdlrn.getChldrnNo())
						.symptmsNo(symptmsId)
						.symptmsTy("PROFILE")
						.build();
				chldrnDAO.insertChldrnSymptms(chldrnSymptms);
			}
			
			//5.메모
			ChldrnMemoVO memo  = ChldrnMemoVO.builder()
					.chldrnNo(chdlrn.getChldrnNo())
					.chldrnMemo(chldrnRequest.getChldrnMemo())
					.build();
			chldrnDAO.insertChldrnMemo(memo);
			
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",chdlrn));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		} catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "create Failed", ""));
		}	 
	}

}
