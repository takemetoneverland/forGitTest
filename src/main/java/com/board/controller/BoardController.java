package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.commons.PageCreator;
import com.board.commons.SearchVO;
import com.board.model.BoardVO;
import com.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService service;
	
	//게시판 리스트 요청(게시판 첫 화면 + 검색)
	@GetMapping("/list")
	public String list(SearchVO search, Model model) {
		
		System.out.println("/board/list");
		
		List<BoardVO> list = service.getArticleList(search);
		
		PageCreator pc = new PageCreator();
		pc.setPaging(search);
		pc.setArticleTotalCount(service.countArticles(search));
		
		model.addAttribute("articles", list);
		model.addAttribute("pc", pc);
		
		return "board/list";
	
	}
	
	//게시글 상세보기
	@GetMapping("/content")
	public String content(int bno, Model model) {
		
		System.out.println("/board/content");
		
		BoardVO article = service.selectArticle(bno);
		
		model.addAttribute("article", article);
		
		return "board/content";
		
	}
	
	//글 쓰기 페이지 이동 요청
	@GetMapping("/write")
	public void write() {
		System.out.println("/board/write");
	}
	
	//글 등록 요청
	@PostMapping("/regist")
	public String regist(BoardVO article) {
		
		String content = article.getContent();
		String title = article.getTitle();
		String writer = article.getWriter();
		
		if(content.matches("[\\w]*") == false || title.matches("[\\w]*") == false || writer.matches("[\\w]*") == false) {
			throw new IllegalArgumentException();
		}
		
		System.out.println("/board/regist");
		service.regist(article);
		
		return "redirect:/board/list";
	}
	
	//글 삭제 요청
	@GetMapping("/delete")
	public String delete(int bno) {
		
		System.out.println("/board/delete");
		service.delete(bno);
		
		return "redirect:/board/list";
		
	}
	
	//글 수정 페이지 이동 요청
	@GetMapping("/modify")
	public ModelAndView modify(int bno) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", service.selectArticle(bno));
		mav.setViewName("/board/modify");
		
		return mav;
	}
	
	//글 수정 등록
	@GetMapping("/update")
	public String update(int bno, String writer, String title, String content) {
		
		System.out.println("/board/update");
		BoardVO article = new BoardVO();
		
		if(writer.matches("[\\w]*") == false || title.matches("[\\w]*") == false || content.matches("[\\w]*")) {
			throw new IllegalArgumentException();
		} else {
			article.setBno(bno);
			article.setWriter(writer);
			article.setTitle(title);
			article.setContent(content);
			service.update(article);
		}
		
		return "redirect:/board/list";
		
	}
	
}
