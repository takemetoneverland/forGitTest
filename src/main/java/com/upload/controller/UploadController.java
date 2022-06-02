package com.upload.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/upload")
	public void form() {}
	
	@PostMapping("/upload_ok")
	public String upload(@RequestParam("file") MultipartFile file, HttpServletResponse response) { //파라미터 이름과 변수명이 같을 경우 @RequestParam 생략 가능
		
		String fileOriginName = file.getOriginalFilename(); //파일명
		//fileOriginName = fileOriginName.replaceAll("\\.", "").replaceAll("/", "").replaceAll("\\\\", "");
		long size = file.getSize(); //파일 사이즈
		
		//System.out.println("파일명: " + fileOriginName);
		//System.out.println("사이즈: " + size);
		logger.info("파일명: {}", fileOriginName);
		logger.info("파일사이즈: {}", size);
		
		//서버에서 저장할 파일 이름
		//파일오리진네임의 .부터 파일오리진네임의 끝까지 추출
		String fileExtension = fileOriginName.substring(fileOriginName.lastIndexOf("."), fileOriginName.length());
		fileExtension = fileExtension.toLowerCase();
		String uploadFolder = "C:\\test\\upload";
		
		if(!"gif".equals(fileExtension) && !"jpg".equals(fileExtension) && !"png".equals(fileExtension) && !"bmp".equals(fileExtension)) {
			
			
			UUID uuid = UUID.randomUUID();
			System.out.println(uuid.toString());
			String[] uuids = uuid.toString().split("-");
			String uniqueName = uuids[0];
			
			//System.out.println("생성된 고유 문자열: " + uniqueName);
			//System.out.println("확장자명: " + fileExtension);
			logger.info("생성된 고유 문자열: {}", uniqueName);
			logger.info("확장자명: {}", fileExtension);
			
			//java.io 패키지 file
			File saveFile = new File(uploadFolder + "\\" + fileOriginName + uniqueName + fileExtension);
			
			//실제 파일 저장 메서드
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			try {
				PrintWriter out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				
				out.print("<script>");
				out.print("alert('업로드 불가능한 파일입니다.')");
				out.print("</script>");
				out.flush();
				out.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		return "upload/upload_ok";
	}
	
}













