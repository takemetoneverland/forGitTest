package com.user.repository;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

public interface IUserMapper {

	//회원가입
	void regist(HashMap<String, String> userMap);
	
	//로그인
	HashMap<String, String> login(@Param("userId") String userId, @Param("userPw") String userPw);
	
	//회원 정보 얻어오기
	HashMap<String, String> getUserInfo(String userId);
	
}
