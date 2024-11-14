/**
 * 
 */
package com.KidLove.mdexmn.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.KidLove.atch.service.AtchService;
import com.KidLove.atch.vo.AtchVO;
import com.KidLove.checkUp.vo.MdexmnRcordVO;
import com.KidLove.checkUp.vo.PrscrptnDrugVO;
import com.KidLove.checkUp.vo.PrscrptnVO;
import com.KidLove.comm.constant.FileTypeEnum;
import com.KidLove.comm.utils.RandomStringGenerator;
import com.KidLove.comm.utils.SQLErrorMessage;
import com.KidLove.comm.vo.HsptlVO;
import com.KidLove.comm.vo.PageVO;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.mdexmn.dao.MdexmnDAO;

/**
 * @packageName	: com.KidLove.mdexmn.service
 * @since		: 2024.11.12
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.12		Boyoung			최초생성
 */

@Service
public class MdexmnServiceImpl implements MdexmnService {
	
	@Inject
	private MdexmnDAO mdexmnDAO;
	
	@Inject
	private AtchService atchService;
	
	@Inject
	private SQLErrorMessage sqlErrorMessage;

	@Override
	public ResponseEntity<ResultVO<Object>> getHstplHist(String chldrnNo) {
		int num  = Integer.parseInt(chldrnNo);
		List<MdexmnRcordVO> mdexmnList = mdexmnDAO.getHstplHist(num);
		
		return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",mdexmnList));
	}

	@Override
	@Transactional
	public ResponseEntity<ResultVO<Object>> createMdexmnRecord(Map<String, String> param , MultipartFile file) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		String makeFileCode = RandomStringGenerator.generateRandomString(15);
		param.put("atchCode", makeFileCode);
		
		try {
			
			long hsptlNo = 0;
			
			if(param.get("hsptlNo").isEmpty()) {
				
				HsptlVO hsptl = HsptlVO.builder()
					.hsptlNm(param.get("hsptlNm"))
					.hsptlDrctr(param.get("hsptlDrctr"))
					.hsptlAddr(param.get("hsptlAddr"))
					.build();
				
				mdexmnDAO.insertHsptl(hsptl);
				hsptlNo = hsptl.getHsptlNo();
			}else {
				hsptlNo = Long.parseLong(param.get("hsptlNo"));
			}
			
			MdexmnRcordVO mdexmn = MdexmnRcordVO.builder()
					.chldrnNo(Long.parseLong(param.get("chldrnNo"))) 
					.mdexmnDgnssNm(param.get("mdexmnDgnssNm"))
					.mdexmnRcordDt(LocalDateTime.parse(param.get("mdexmnRcordDt"), formatter)) 
					.mdexmnMdlrt(param.get("mdexmnMdlrt"))
					.mdexmnMemo(param.get("mdexmnMemo"))
					.hsptlNo(hsptlNo)
					.mdexmnTy("CLNIC")  //일반진료
					.build();
			
			mdexmnDAO.insertMdexmn(mdexmn);
			param.put("mdexmnRcordNo",  String.valueOf(mdexmn.getMdexmnRcordNo()));
			
			if(! file.isEmpty()) {
				AtchVO atchVO = AtchVO.builder()
						.atchCode(makeFileCode)
						.atchTy(FileTypeEnum.PRSCRPTN)
						.build();
				atchService.saveFile(file, atchVO);
			}
			
			PrscrptnVO prscrptn = PrscrptnVO.builder()
					.atchCode(makeFileCode)
					.mdexmnRcordNo(mdexmn.getMdexmnRcordNo())
					.build();
			
			mdexmnDAO.insertPrscrptn(prscrptn);
			
			PrscrptnDrugVO drug = PrscrptnDrugVO.builder()
					.drugNm(param.get("drugNm"))
					.prscrptnNo(prscrptn.getPrscrptnNo())
					.build();
			
			mdexmnDAO.insertDrug(drug);
			
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",param));
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		}catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "create Failed", ""));
		}
	}

	@Override
	public ResponseEntity<ResultVO<Object>> getMdexmnDgnssNmHist(String chldrnNo) {
		int num  = Integer.parseInt(chldrnNo);
		List<MdexmnRcordVO> mdexmnList = mdexmnDAO.getMdexmnDgnssNmHist(num);
		return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",mdexmnList));
	}

	@Override
	public ResponseEntity<ResultVO<Object>> getMdexmnRecord(PageVO page) {

		//pageSize 고정
		page.setPageSize(10);
		
		PageVO newPage = new PageVO();
		List<MdexmnRcordVO> combinedList = new ArrayList<>();
		
		if(page.getType1().equals("ALL")) {
			page.setPageSize(page.getPageSize()/2);
			
			//병원기록
			int totRecCnt = mdexmnDAO.getMdexmnHsptlRecordTotRecCnt(page);
			newPage  = new PageVO(page.getPage(),page.getPageSize(),totRecCnt, page.getType1(), page.getType2());
			List<MdexmnRcordVO> mdexmnHsptlList = mdexmnDAO.getMdexmnHsptlRecord(newPage);
			combinedList.addAll(mdexmnHsptlList);
			
			/* 약국기록 아직 기획 미정  구현안함
			List<MdexmnRcordVO> mdexmnParmacyList = mdexmnDAO.getMdexmnParmacyRecord(newPage);
			combinedList.addAll(mdexmnParmacyList);
			*/
			
			 //정렬
	        combinedList = combinedList.stream()
	                .sorted(Comparator.comparing(MdexmnRcordVO::getMdexmnRcordDt).reversed())
	                .collect(Collectors.toList());
			
		}else if(page.getType1().equals("HSPTL")) {
			int totRecCnt = mdexmnDAO.getMdexmnHsptlRecordTotRecCnt(page);
			newPage  = new PageVO(page.getPage(),page.getPageSize(),totRecCnt, page.getType1(), page.getType2());
			combinedList = mdexmnDAO.getMdexmnHsptlRecord(newPage);
		
		}else if(page.getType1().equals("PARMACY")) {
			
			//아직 기획 미정  구현안함
		}
	
		return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",combinedList));
	}


}
