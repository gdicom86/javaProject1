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
public class UserVO {
	private String id;
	private String pw;
	private String name;
	private String address_postcode;
	private String address_primary;
	private String address_detail;
	private String phone;
	private String email;
	private String customerType;
}
