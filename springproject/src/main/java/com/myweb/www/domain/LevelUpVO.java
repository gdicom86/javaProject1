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
public class LevelUpVO {
	private int lno;
	private String id;
	private String phone;
	private String businessNumber;
	private String content;
	private String date;
}
