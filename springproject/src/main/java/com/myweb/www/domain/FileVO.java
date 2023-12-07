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
public class FileVO {
	private String uuid;
	private String save_dir;
	private String file_name;
	private int file_type;
	private long file_size;
	private int bno;
	private int fileCategoryNum;
}
