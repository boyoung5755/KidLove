/**
 * 
 */
package com.KidLove.comm;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

/**
 * @packageName	: com.KidLove.comm
 * @since		: 2024.11.12
 * @author		: Boyoung
 * @description	: 테스트컨트롤러
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.11.12		Boyoung			최초생성
 */

@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class TestController {
	
	
	@GetMapping("/html")
	public String goTestHtml(Model model) {
        return "<img  src='/imagePath/16948f3b-e375-4aeb-8b88-12a9fafaeef6.jpg'>";
    }
	
}
