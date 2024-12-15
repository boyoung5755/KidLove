/**
 * 
 */
package com.KidLove.hsptl.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KidLove.comm.utils.SQLErrorMessage;
import com.KidLove.comm.vo.HsptlVO;
import com.KidLove.comm.vo.PageVO;
import com.KidLove.comm.vo.ResultVO;
import com.KidLove.hsptl.dao.HsptlDAO;

/**
 * @packageName	: com.KidLove.hsptl.service
 * @since		: 2024.11.25
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.25		Boyoung			최초생성
 */

@Service
public class HsptlServiceImpl implements HsptlService {
	
	@Inject
	private SQLErrorMessage sqlErrorMessage;
	
	@Inject
	private HsptlDAO hsptlDAO;

	
	@Override
	@Transactional
	public ResponseEntity<ResultVO<Object>> saveHsptlMdcnc(List<HsptlVO> hsptl) {
		try {
			
			for( HsptlVO ele : hsptl ) {
				
				HsptlVO isExisting = hsptlDAO.checkHsptlId(ele.getId());
			
				if(isExisting == null) {
					hsptlDAO.insertHsptl(ele);
				}
			}
			
			return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",hsptl.size()+"건 등록완료"));
			
		} catch (RuntimeException e) {
			String sqlErrorMsg = sqlErrorMessage.extractSqlErrorMessage(e.getMessage());
            throw new RuntimeException(sqlErrorMsg, e);
		}catch (Exception e) {
			 return ResponseEntity.ok(ResultVO.res(HttpStatus.BAD_REQUEST, "create Failed", ""));
		}
	}


	@Override
	public ResponseEntity<ResultVO<Object>> getAllHsptl(PageVO page) {
		
		int totRecCnt = hsptlDAO.getAllHsptlRecordTotRecCnt(page);
		PageVO newPage = new PageVO(page.getPage(), page.getPageSize(),totRecCnt,null, null);
		
		List<HsptlVO> hspltList = hsptlDAO.getAllHsptl(newPage);
		
		Map<String, Object> map  = new HashMap<>();
		map.put("pageInfo", newPage);
		map.put("list", hspltList);
		
		return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",map));
	}


	@Override
	public ResponseEntity<ResultVO<Object>> getHsptlByRegion(PageVO page) {
		int totRecCnt = hsptlDAO.getHsptlByRegionRecordTotRecCnt(page);
		PageVO newPage = new PageVO(page.getPage(), page.getPageSize(),totRecCnt,page.getType1(), page.getType2());
		
		newPage.setSearchStr(page.getSearchStr());
		newPage.setSort(page.getSort());
		
		List<HsptlVO> hspltList = hsptlDAO.getHsptlByRegion(newPage);
		
		Map<String, Object> map  = new HashMap<>();
		map.put("pageInfo", newPage);
		map.put("list", hspltList);
		
		return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",map));
	}


	@Override
	public ResponseEntity<ResultVO<Object>> getHsptlByName(PageVO page) {
		
		int totRecCnt = hsptlDAO.getHsptlByNameRecordTotRecCnt(page);
		PageVO newPage = new PageVO(page.getPage(), page.getPageSize(),totRecCnt,page.getType1(), page.getType2());
		
		newPage.setSearchStr(page.getSearchStr());
		newPage.setSort(page.getSort());
		
		List<HsptlVO> hspltList = hsptlDAO.getHsptlByName(newPage);
		
		Map<String, Object> map  = new HashMap<>();
		map.put("pageInfo", newPage);
		map.put("list", hspltList);
		
		return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",map));
	}


	@Override
	public ResponseEntity<ResultVO<Object>> getNearHsptl(PageVO page) {
		
		int totRecCnt = hsptlDAO.getNearHsptlRecordTotRecCnt(page);
		PageVO newPage = new PageVO(page.getPage(), page.getPageSize(),totRecCnt,null, null);
		
		newPage.setLat(page.getLat());
		newPage.setLon(page.getLon());
		newPage.setLimit(page.getLimit());
		
		List<HsptlVO> hspltList = hsptlDAO.getNearHsptl(newPage);
		
		Map<String, Object> map  = new HashMap<>();
		map.put("pageInfo", newPage);
		map.put("list", hspltList);
		
		return ResponseEntity.ok(ResultVO.res(HttpStatus.OK,"success",map));
	}
}
