package com.myweb.www.handler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.tika.Tika;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.myweb.www.domain.FileVO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Slf4j
@AllArgsConstructor
@Component
public class FileHandler {
	private final String UP_DIR = "D:\\Java\\fileUpload";
	
	public List<FileVO> uploadThumbnailFiles(MultipartFile[] files) {
        return uploadFiles(files, 1); // 1은 썸네일 파일 타입을 나타냄
    }

    public List<FileVO> uploadDetailFiles(MultipartFile[] files) {
        return uploadFiles(files, 0); // 0은 상세사진 파일 타입을 나타냄
    }
	
	public List<FileVO> uploadFiles(MultipartFile[] files, int fileCategoryNum) {
		LocalDate date = LocalDate.now();
		log.info("date: " + date);
		String today = date.toString(); // 2023-11-14 date 객체 스트링 변환
		// today => 폴더구조로 변경 2023\11\14(win) 2023/11/14(linux)
		today = today.replace("-", File.separator); 
		
		// today 폴더 구성
		File folders = new File(UP_DIR, today);
		
		// 폴더가 기존에 있다면 생성 X, 없다면 생성 O
		if(!folders.exists()) {
			folders.mkdirs();
		}
		
		// 경로 설정
		List<FileVO> fvoList = new ArrayList<FileVO>();
		for(MultipartFile file : files) {
			FileVO fvo = new FileVO();
			fvo.setSave_dir(today); // 파일 경로 설정
			fvo.setFile_size(file.getSize()); // 파일 사이즈 설정 
			// 실제 파일명만 추출
			String originalFileName = file.getOriginalFilename();
			String onlyFileName = originalFileName.substring(
					originalFileName.lastIndexOf(File.separator)+1); 
			log.info("onlyFileName: " + onlyFileName);
			fvo.setFile_name(onlyFileName);
			
			// UUID 생성
			UUID uuid = UUID.randomUUID();
			fvo.setUuid(uuid.toString());
			
			// fileCategoryNum 1번 list썸네일 0번 상세내용 사진	
			fvo.setFileCategoryNum(fileCategoryNum);
					
			// ------ 여기까지 fvo 저장할 정보 생성 fvo.set
			// 디스크에 파일 저장할 객체 생성 -> 저장
			String fullFileName = uuid.toString()+"_"+onlyFileName;
			File storeFile = new File(folders, fullFileName);
			
			// 썸네일 생성
			try {
				file.transferTo(storeFile); // 원본 객체 저장을 위한 형태의 객체로 복사
				// 파일 타입 결정 -> 이미지 파일이라면 썸네일 생성
				if(fileCategoryNum == 1 && isImageFile(storeFile)) {
					fvo.setFile_type(1);
					File thumbNail = new File(folders, uuid.toString()+"_th_"+onlyFileName);
					Thumbnails.of(storeFile).size(75, 75).toFile(thumbNail);
				}
			} catch (Exception e) {
				log.info(">>> file 생성 오류 > ");
				e.printStackTrace();
			}
			fvoList.add(fvo);
		}
		return fvoList;
	}
	// tika를 사용하여 파일 형식 체크 -> 이미지 파일이 맞는지 체크
	private boolean isImageFile(File storeFile) throws IOException {
		String mimeType = new Tika().detect(storeFile);
		return mimeType.startsWith("image")? true : false;
	}
}
