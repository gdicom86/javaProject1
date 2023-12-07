package com.myweb.www.service;

import com.myweb.www.domain.UserVO;

public interface UserService {

	int signUp(UserVO uvo);

	int idCheck(String id);

	UserVO existUser(String id, String pw);

	String searchId(String name, String phone);

	int searchPw(String id, String email);

	int updatePw(String id, String email, String key);

	int closeAccount(String userId);

	int editAccount(UserVO uvo);

}
