/**
 * 
 */
package com.KidLove.mdexmn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.KidLove.checkUp.vo.MdexmnRcordVO;
import com.KidLove.checkUp.vo.PrscrptnDrugVO;
import com.KidLove.checkUp.vo.PrscrptnVO;
import com.KidLove.comm.vo.HsptlVO;
import com.KidLove.comm.vo.PageVO;

/**
 * @packageName	: com.KidLove.mdexmn.dao
 * @since		: 2024.11.12
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.12		Boyoung			최초생성
 */

@Mapper
public interface MdexmnDAO {

	/**
	 * @MethodName	: getHstplHist
	 * @author		: Boyoung
	 * @date 		: 2024.11.12
	 * @description	: 다녀온 병원 기록 조회
	 * @return 		: Object
	 * @param loginMberId
	 * @return
	 */
	List<MdexmnRcordVO> getHstplHist(@Param("chldrnNo") int chldrnNo);


	/**
	 * @MethodName	: insertHsptl
	 * @author		: Boyoung
	 * @date 		: 2024.11.14
	 * @description	: 병원저장
	 * @return 		: void
	 * @param hsptl
	 */
	void insertHsptl(HsptlVO hsptl);


	/**
	 * @MethodName	: insertMdexmn
	 * @author		: Boyoung
	 * @date 		: 2024.11.14
	 * @description	: 진료기록 저장
	 * @return 		: void
	 * @param mdexmn
	 */
	void insertMdexmn(MdexmnRcordVO mdexmn);


	/**
	 * @MethodName	: insertPrscrptn
	 * @author		: Boyoung
	 * @date 		: 2024.11.14
	 * @description	: 처방전 저장
	 * @return 		: void
	 * @param prscrptn
	 */
	void insertPrscrptn(PrscrptnVO prscrptn);


	/**
	 * @MethodName	: getMdexmnDgnssNmHist
	 * @author		: Boyoung
	 * @date 		: 2024.11.14
	 * @description	: 병명 불러오기
	 * @return 		: Object
	 * @param num
	 * @return
	 */
	List<MdexmnRcordVO> getMdexmnDgnssNmHist(@Param("chldrnNo") int chldrnNo);


	/**
	 * @MethodName	: insertDrug
	 * @author		: Boyoung
	 * @date 		: 2024.11.14
	 * @description	: 처방약 등록
	 * @return 		: void
	 * @param drug
	 */
	void insertDrug(PrscrptnDrugVO drug);


	/**
	 * @MethodName	: getMdexmnHsptlRecordTotRecCnt
	 * @author		: Boyoung
	 * @date 		: 2024.11.14
	 * @description	: 진료기록 목록 총 레코드 수 (병원)
	 * @return 		: int
	 * @param page
	 * @return
	 */
	int getMdexmnHsptlRecordTotRecCnt(PageVO page);


	/**
	 * @MethodName	: getMdexmnHsptlRecord
	 * @author		: Boyoung
	 * @date 		: 2024.11.14
	 * @description	: 진료처방기록 목록 (병원)
	 * @return 		: List<MdexmnRcordVO>
	 * @param newPage
	 * @return
	 */
	List<MdexmnRcordVO> getMdexmnHsptlRecord(PageVO newPage);


	/**
	 * @MethodName	: getMdexmnParmacyRecord
	 * @author		: Boyoung
	 * @date 		: 2024.11.14
	 * @description	: 진료처방기록 목록 (약국)
	 * @return 		: List<MdexmnRcordVO>
	 * @param newPage
	 * @return
	 */
	List<MdexmnRcordVO> getMdexmnParmacyRecord(PageVO newPage);

}
