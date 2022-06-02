package com.board.commons;


public class SearchVO extends PageVO {
	
	private String keyword;
	private String condition;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public SearchVO(String keyword, String condition) {
		this.keyword = keyword;
		this.condition = condition;
	}
	
	@Override
	public String toString() {
		return "SearchVO [keyword=" + keyword + ", condition=" + condition + "]";
	}

}
