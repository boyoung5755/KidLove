/**
 * 
 */
package com.KidLove.comm.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @packageName	: com.KidLove.comm.vo
 * @since		: 2024.11.14
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.14		Boyoung			최초생성
 */

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageVO {

	private int page;
    private int pageSize;
    private int totRecCnt;
    private int totPage;
    private int startIndexNo;
    private int curScrStartNo;
    private int blockSize;
    private int curBlock;
    private int lastBlock;
    

    private String searchStr;
    private String category;
    
    private String type1;
    private String type2;
    
    // paging 기본 설정 함수
    private void fn_basicPaging() {
        this.totPage = (totRecCnt % pageSize) == 0 ? totRecCnt / pageSize : (totRecCnt / pageSize) + 1;
        this.startIndexNo = (page - 1) * pageSize;
        this.curScrStartNo = totRecCnt - startIndexNo;
        this.blockSize = 3;
        this.curBlock = (page - 1) / blockSize;
        this.lastBlock = (totPage - 1) / blockSize;
    }
    
    public PageVO(int page, int pageSize, int totRecCnt, String type1, String type2){
        this.page = page;
        this.pageSize = pageSize;
        this.totRecCnt = totRecCnt;
        this.type1 = type1;
        this.type2 = type2;

        fn_basicPaging();
    }
}
