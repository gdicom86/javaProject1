package com.myweb.www.repository;

import org.apache.ibatis.annotations.Param;

import com.myweb.www.domain.UserVO;

public interface UserDAO {

	int signUp(UserVO uvo);

	int idCheck(String id);

	UserVO getUser(String id);

	String searchId(@Param("name") String name, @Param("phone") String phone);

	int searchPw(@Param("id") String id, @Param("email") String email);

	int updatePw(@Param("id") String id, @Param("email") String email, @Param("encodePw") String encodePw);

	int closeAccount(String userId);

	int editAccount(UserVO uvo);

	int updateCustomerType(String id);
	
}