package com.myweb.www.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PagingVO {
	private int pageNo; // 현재 화면에 출력된 페이지 번호
	private int qty; // 한 페이지당 보여지는 게시글 수
	
	public PagingVO(int pageNo, int qty) {
		this.pageNo = pageNo;
		this.qty = qty;
	}
	
	public PagingVO() {
		this(1, 10);
	}
	
	public int getPageStart() {
		return (this.pageNo-1)*qty;
	}
}
