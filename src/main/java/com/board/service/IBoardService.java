package com.board.service;

import java.util.List;

import com.board.commons.SearchVO;
import com.board.model.BoardVO;

public interface IBoardService {

	//게시글 리스트 불러오기
	List<BoardVO> getArticleList(SearchVO search);
	
	//게시글 수 조회
	int countArticles(SearchVO search);
	
	//게시글 보기
	BoardVO selectArticle(int bno);
	
	//글 등록
	void regist(BoardVO article);
	
	//글 삭제
	void delete(int bno);
	
	//글 수정
	void update(BoardVO article);
	
}
