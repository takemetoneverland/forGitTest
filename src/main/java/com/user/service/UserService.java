package com.user.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.repository.IUserMapper;

@Service
public class UserService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserMapper mapper;
	
	//회원가입
	public void regist(HashMap<String, String> userMap) {
		
		//비밀번호 암호화 인코딩
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		logger.info("암호화 하기 전 비밀번호: {}", userMap.get("userPw"));
		
		//비밀번호를 암호화해서 userMap에 다시 저장하기
		String securePw = encoder.encode(userMap.get("userPw"));
		logger.info("암호화 후 비밀번호: {}", securePw);
		userMap.put("userPw", securePw);
		
		mapper.regist(userMap);
	}
	
	//로그인
	public HashMap<String, String> login(String userId, String userPw) {
		HashMap<String, String> userMap = mapper.login(userId, userPw);
		return userMap;
	}

}
