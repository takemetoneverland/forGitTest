package com.board.commons;

public class PageVO {
	
	private int page; //사용자가 선택한 페이지 번호
	private int countPerPage; //한 화면에 보여질 게시물 수

	public PageVO() {
		this.page = 1;
		this.countPerPage = 5;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	@Override
	public String toString() {
		return "PageVO [page=" + page + ", countPerPage=" + countPerPage + "]";
	}

}
