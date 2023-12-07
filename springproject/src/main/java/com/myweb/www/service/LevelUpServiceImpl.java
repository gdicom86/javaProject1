package com.myweb.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.www.domain.LevelUpVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.repository.LevelUpDAO;
import com.myweb.www.repository.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LevelUpServiceImpl implements LevelUpService {
	
	@Autowired
	private LevelUpDAO ldao;
	
	@Autowired
	private UserDAO udao;

	@Override
	public int register(LevelUpVO lvo) {
		 log.info(" LevelUpVO register LevelUpServiceImpl in");
		 int isOk = ldao.register(lvo);
		 return isOk;
	}

	@Override
	public List<LevelUpVO> getList(PagingVO pvo) {
		log.info(" List<LevelUpVO> getList LevelUpServiceImpl in");
		List<LevelUpVO> lvoList = ldao.getList(pvo);
		return lvoList;
	}

	@Override
	public int updateConfirm(int lno, String id) {		
		int result = 1;
		
		log.info(" updateConfirm LevelUpServiceImpl in");
		int updateUser = udao.updateCustomerType(id);
		log.info("updateUser: " + updateUser);
		result *= updateUser;
		// updateCustomerType에서 WHERE customerType = "third";의 조건을 만족해야 등업진행
		if (updateUser > 0) {
			int updateConfirm = ldao.updateConfirm(lno);
			log.info("updateConfirm: " + updateConfirm);		
			result *= updateConfirm;
		}
		log.info("result: " + result);
		return result;
	}

	@Override
	public int getTotalCount() {
		log.info(" getTotalCount LevelUpServiceImpl in");
		int result = ldao.getTotalCount();
		return result;
	}
}
