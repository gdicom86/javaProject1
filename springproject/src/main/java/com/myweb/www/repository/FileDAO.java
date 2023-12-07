package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.FileVO;

public interface FileDAO {

	int insertFile(FileVO file);

	List<FileVO> getFvoList(int bno);

	void deleteFilesByBno(int bno);

	int deleteFilesByUuid(String uuid);

}
