package com.myweb.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.repository.CommentDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDAO cdao;

	@Override
	public int post(CommentVO cvo) {
		log.info("comment post service in");
		return cdao.insert(cvo);
	}

	@Override
	public List<CommentVO> getList(int bno) {
		log.info("comment getList service in");
		return cdao.getList(bno);
	}

	@Override
	public int editComment(CommentVO cvo) {
		log.info("comment editComment service in");
		return cdao.editComment(cvo);
	}

	@Override
	public int removeComment(int cno) {
		log.info("comment removeComment service in");
		return cdao.removeComment(cno);
	}
}
