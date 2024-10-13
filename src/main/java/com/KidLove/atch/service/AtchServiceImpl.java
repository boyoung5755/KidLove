package com.KidLove.atch.service;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.KidLove.atch.dao.AtchDAO;
import com.KidLove.atch.vo.AtchVO;
import com.KidLove.comm.vo.ResultVO;


@Service
public class AtchServiceImpl implements AtchService {
	
	@Value("${imagePath}")
	private String uploadDir;
	
	@Inject
	private AtchDAO atchDao;
	
	
	//단일파일
	@Override
	@Transactional
	public  void saveFile (MultipartFile file, AtchVO atch) {
		if (file.isEmpty()) {
            throw new IllegalStateException("빈 파일을 업로드할 수 없습니다.");
        }
		
		try {
			String originalFilename = file.getOriginalFilename();
			String extension = "";
			
			if (originalFilename != null && originalFilename.contains(".")) {
				extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			}
			
			String uuidFileNm = UUID.randomUUID().toString();
			String storedFilename = uuidFileNm + "." + extension;
			
			Path uploadPath = Paths.get(uploadDir+"/"+ String.valueOf(atch.getAtchTy()));
			
			// uploadPath 디렉토리가 존재하지 않으면 생성
	        if (!Files.exists(uploadPath)) {
	            Files.createDirectories(uploadPath);
	        }
	        
	        // 최종 파일 경로 설정
	        Path filePath = uploadPath.resolve(storedFilename);
	        
	        // 파일을 파일 시스템에 저장
	        try (InputStream inputStream = file.getInputStream()) {
	            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
	        }
			
	        String setFlpth = 
	        		"uploads"+File.separatorChar + String.valueOf(atch.getAtchTy()) +File.separatorChar+storedFilename;
			
			AtchVO makeAtch = AtchVO.builder()
		                    .atchOrginlnm(originalFilename)
		                    .atchExtsn(extension)
		                    .atchCode(atch.getAtchCode())
		                    .atchFlpth(setFlpth)
		                    .atchSz((int) file.getSize())
		                    .atchTy(atch.getAtchTy())
		                    .build();
			
			atchDao.save(makeAtch);
			
		} catch (Exception e) {
			throw new IllegalStateException("파일 저장 중 오류가 발생했습니다.", e);
		}
	}
}
