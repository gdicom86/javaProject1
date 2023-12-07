package com.myweb.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myweb.www.domain.UserVO;
import com.myweb.www.repository.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserDAO udao;
	
	@Autowired
	BCryptPasswordEncoder passwordencoder;
	
	@Override
	public int signUp(UserVO uvo) {
		log.info("회원가입 서비스 진입");
		String pw = uvo.getPw(); // get으로 입력받은 값 가져오기
		String encodePw = passwordencoder.encode(pw); // 가져온 암호 encode
		uvo.setPw(encodePw); // encode된 암호 set
		int isOk = udao.signUp(uvo);
		log.info("isOk: " + isOk);
		return isOk;
	}

	@Override
	public int idCheck(String id) {
		int cnt = udao.idCheck(id);
		log.info("cnt: " + cnt);
		return cnt;
	}

	@Override
	public UserVO existUser(String id, String pw) {
		log.info("로그인 서비스 진입");
		// id를 주고 해당 id에 일치하는 객체를 DB에서 호출
		UserVO uvo = udao.getUser(id);
		// id가 일치하는 객체가 없을 경우 return null
		if(uvo == null) { return null; }
		// passwordencoder.matches(원래비번, 암호화된 비번) 매치된다면 true 반환
		if(passwordencoder.matches(pw, uvo.getPw())) {
			return uvo;
		} else {
			return null;
		}
		
	}

	@Override
	public String searchId(String name, String phone) {
		log.info("아이디 찾기 서비스 진입");	
        String result = udao.searchId(name, phone);
        log.info("result: " + result);
		return result;
	}

	@Override
	public int searchPw(String id, String email) {
		log.info("비밀번호 찾기 서비스 진입");
		int result = udao.searchPw(id, email);
		// 아이디는 중복이 안되게 만들어서 mapper에서 카운트 리턴 값은 0, 1 밖에 없다.
		log.info("result: " + result);
		return result;
	}

	@Override
	public int updatePw(String id, String email, String key) {
		log.info("비밀번호 업데이트 서비스 진입");
		String encodePw = passwordencoder.encode(key); // 가져온 암호 encode
		int result = udao.updatePw(id, email, encodePw);
		log.info("result: " + result);
		return result;
	}

	@Override
	public int closeAccount(String userId) {
		log.info("계정해지 서비스 진입");
		int isOk = udao.closeAccount(userId);
		return isOk;
	}

	@Override
	public int editAccount(UserVO uvo) {
		log.info("정보수정 서비스 진입");
		String pw = uvo.getPw(); // get으로 입력받은 값 가져오기
		String encodePw = passwordencoder.encode(pw); // 가져온 암호 encode
		uvo.setPw(encodePw); // encode된 암호 set
		int isOk = udao.editAccount(uvo);
		log.info("isOk: " + isOk);
		return isOk;
	}
	
}