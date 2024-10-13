package com.KidLove.atch.service;

import org.springframework.web.multipart.MultipartFile;

import com.KidLove.atch.vo.AtchVO;

public interface AtchService {

	public void saveFile(MultipartFile file , AtchVO atch);

}
