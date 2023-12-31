package com.myweb.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {
	private int cno;
	private int bno;
	private String writer;
	private String content;
	private String reg_date;
	private String mod_date;
	private float rate;
}
