package com.KidLove.atch.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.KidLove.atch.dao.AtchDAO;
import com.KidLove.atch.vo.AtchVO;


@Service
public class AtchServiceImpl implements AtchService {
	
	@Value("${imagePath}")
	private String uploadDir;
	
	@Inject
	private AtchDAO atchDao;
	
	
	//단일파일
	public AtchVO saveFile (MultipartFile file, AtchVO atch) {
		if (file.isEmpty()) {
            throw new IllegalStateException("빈 파일을 업로드할 수 없습니다.");
        }
		
		try {
			String originalFilename = file.getOriginalFilename();
			String extension = "";
			String uuidFileNm = UUID.randomUUID().toString();
			String storedFilename = uuidFileNm + "." + extension;
			
			Path uploadPath = Paths.get(uploadDir, "uploads", atch.getAtchTy());
			
			if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
			}	
			
			Path filePath = uploadPath.resolve(storedFilename);
			
			if (originalFilename != null && originalFilename.contains(".")) {
                extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            }
			
			AtchVO makeAtch = AtchVO.builder()
		                    .atchOrginlnm(originalFilename)
		                    .atchExtsn(extension)
		                    .atchCode(atch.getAtchCode())
		                    .atchFlpth(uploadPath.toString() + File.separator + storedFilename)
		                    .atchSz((int) file.getSize())
		                    .atchTy(atch.getAtchTy())
		                    .build();
			
			return atchDao.save(makeAtch);
			
		} catch (Exception e) {
			throw new IllegalStateException("파일 저장 중 오류가 발생했습니다.", e);
		}
		
	}
}
