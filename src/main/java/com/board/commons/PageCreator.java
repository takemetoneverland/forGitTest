package com.board.commons;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


public class PageCreator {

	private PageVO paging; //페이지 번호, 한 페이지 들어갈 게시물 수
	private int articleTotalCount; //총 게시물 갯수
	private int beginPage; //시작 페이지 번호
	private int endPage; //끝 페이지 번호
	private boolean prev; //이전 페이지 활성화 여부
	private boolean next; //다음 페이지 활성화 여부
	
	//한 화면에 보여질 페이지 버튼 수
	private final int displayPageNum = 5;
	
	//URI 파라미터를 쉽게 만들어주는 유틸 메서드
	public String makeURI(int page) {
		UriComponents ucp = UriComponentsBuilder.newInstance().queryParam("page", page)
															  .queryParam("countPerPage", paging.getCountPerPage())
															  .queryParam("keyword", ((SearchVO) paging).getKeyword())
															  .queryParam("condition", ((SearchVO) paging).getCondition())
															  .build();
		return ucp.toUriString();
	}
	
	//페이징 메서드
	private void calcDataOfPage() {
		
		endPage = (int) (Math.ceil(paging.getPage() / (double)displayPageNum) * displayPageNum);

		//시작페이지 번호 계산
		beginPage = (endPage - displayPageNum) + 1;

		//이전버튼 활성화, 비활성화 여부
		prev = (beginPage == 1) ? false : true;

		//다음 버튼 활성, 비활성 여부
		next = (endPage * paging.getCountPerPage()) >= articleTotalCount ? false : true;


		//끝 페이지 보정
		if(!next) {
			endPage = (int) Math.ceil(articleTotalCount / (double)paging.getCountPerPage());
		}
	}

	public void setArticleTotalCount(int articleTotalCount) {
		this.articleTotalCount = articleTotalCount;
		calcDataOfPage();
	}

	public PageVO getPaging() {
		return paging;
	}

	public void setPaging(PageVO paging) {
		this.paging = paging;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getArticleTotalCount() {
		return articleTotalCount;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}
	
	public PageCreator() {}

	public PageCreator(PageVO paging, int articleTotalCount, int beginPage, int endPage, boolean prev, boolean next) {
		this.paging = paging;
		this.articleTotalCount = articleTotalCount;
		this.beginPage = beginPage;
		this.endPage = endPage;
		this.prev = prev;
		this.next = next;
	}

	@Override
	public String toString() {
		return "PageCreator [paging=" + paging + ", articleTotalCount=" + articleTotalCount + ", beginPage=" + beginPage
				+ ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + ", displayPageNum=" + displayPageNum
				+ "]";
	}
	
}
