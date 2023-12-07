package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.LevelUpVO;
import com.myweb.www.domain.PagingVO;

public interface LevelUpService {

	int register(LevelUpVO lvo);

	List<LevelUpVO> getList(PagingVO pvo);

	int updateConfirm(int lno, String id);

	int getTotalCount();

}
