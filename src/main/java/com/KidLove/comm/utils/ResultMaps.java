/**
 * 
 */
package com.KidLove.comm.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @packageName	: com.KidLove.comm.utils
 * @since		: 2024.08.19
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.08.19		Boyoung			최초생성
 */
public class ResultMaps {

	public static Map<String, Object> json(Object... params) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", params[0]);
        map.put("msg", params[1]);
        if(params.length == 3) {
            map.put("data", params[2]);
        }
        return map;
    }
}
