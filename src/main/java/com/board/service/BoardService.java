package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.commons.SearchVO;
import com.board.model.BoardVO;
import com.board.repository.IBoardMapper;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	private IBoardMapper mapper;

	//게시글 목록
	@Override
	public List<BoardVO> getArticleList(SearchVO search) {
	
		String keyword = search.getKeyword();
		
		if(keyword != null) {
			search.setKeyword(keyword.toLowerCase());
		}
		
		List<BoardVO> list = mapper.getArticleList(search);
		
		return list;
	}

	//총 게시글 수(총 검색 결과 게시글 수)
	@Override
	public int countArticles(SearchVO search) {
		return mapper.countArticles(search);
	}

	//게시글 상세보기
	@Override
	public BoardVO selectArticle(int bno) {
		return mapper.selectArticle(bno);
	}

	//글 등록
	@Override
	public void regist(BoardVO article) {
		mapper.regist(article);
	}

	//글 삭제
	@Override
	public void delete(int bno) {
		mapper.delete(bno);
	}

	//글 수정
	@Override
	public void update(BoardVO article) {
		mapper.update(article);
	}

}
