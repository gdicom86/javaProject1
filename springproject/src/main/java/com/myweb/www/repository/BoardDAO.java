package com.myweb.www.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myweb.www.domain.BoardVO;

public interface BoardDAO {

	int register(BoardVO bvo);

	List<BoardVO> getAllList();

	BoardVO getDetail(int bno);

	int modify(BoardVO bvo);

	int delete(int bno);

	int count(int bno);

	int selectBno();

	List<BoardVO> getBvoList(String id);

	int updateBoard(BoardVO bvo);

	List<BoardVO> getBvoListByType(@Param("searchType_a") String searchType_a, @Param("searchType_b") String searchType_b, @Param("pageSize") int pageSize);

	List<BoardVO> getBvoListByTypeMore(@Param("searchType_a") String searchType_a, @Param("searchType_b") String searchType_b, @Param("pageSize") int pageSize, @Param("page") int page);
	
	List<BoardVO> getBvoListByKeyword(@Param("searchKeyword") String searchKeyword, @Param("pageSize") int pageSize);
	
	List<BoardVO> getBvoListByKeywordMore(@Param("searchKeyword") String searchKeyword, @Param("pageSize") int pageSize, @Param("page") int page);

}
