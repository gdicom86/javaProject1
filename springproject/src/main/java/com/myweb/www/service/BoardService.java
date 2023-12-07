package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.UserVO;

public interface BoardService {

	// int register(BoardVO bvo);

	List<BoardVO> getAllList();

	BoardVO getDetail(int bno);

	int modify(BoardVO bvo);

	int delete(int bno);

	int count(int bno);

	int register(BoardDTO bdto);

	List<BoardDTO> getMyBdtoList(String id);

	BoardDTO getDetailDto(int bno);

	int modifyDTO(UserVO uvo, BoardDTO bdto);

	int removeFile(String uuid);

	List<BoardDTO> getDetail(String searchType_a, String searchType_b, int pageSize);

	List<BoardDTO> getDetailMore(String searchType_a, String searchType_b, int pageSize, int page);
	
	List<BoardDTO> searchDTOList(String searchKeyword, int pageSize);
	
	List<BoardDTO> searchDTOListMore(String searchKeyword, int pageSize, int page);

}
