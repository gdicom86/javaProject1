package com.myweb.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardVO {
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String reg_date;
	private int read_count;
	private String searchType_a;
	private String searchType_b;
	private String searchType_add1;
	private String searchType_add2;
}
