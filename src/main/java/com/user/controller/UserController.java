package com.user.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	//회원가입 페이지 이동
	@GetMapping("/joinForm")
	public void joinForm() {}
	
	//회원가입폼 등록
	@PostMapping("/regist")
	public String regist(String userName, String userId, String userPw) {
		
		System.out.println("/user/regist: POST");

		HashMap<String, String> userMap = new HashMap<>();
		userMap.put("userName", userName);
		userMap.put("userId", userId);
		userMap.put("userPw", userPw);
		
		service.regist(userMap);
		
		return "redirect:/";
		
	}
	
	//로그인 페이지 이동
	@GetMapping("/loginPage")
	public void loginPage() {
	}
	
	//로그인 요청
	@PostMapping("/login")
	public String login(String userId, String userPw, Model model, HttpSession session) {
		
		System.out.println("/user/login: POST");
		
		if(userId.matches("[\\w]*") == false || userPw.matches("[\\w]*") == false) {
			throw new IllegalArgumentException();
		}
		
		service.login(userId, userPw);
		
		HashMap<String, String> userMap = service.login(userId, userPw);

		if(userMap != null) {
			model.addAttribute("user", userMap);
			session.setAttribute("loginSession", userMap);
			return "redirect:/";
		} else {
			return "redirect:/user/login";
		}
		
	}

	//회원정보 수정 페이지 이동
	@GetMapping("/modify")
	public void modify() {
		
		System.out.println("/user/modify: GET");
		
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		System.out.println("/user/logout: GET");
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
}








