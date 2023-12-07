package com.myweb.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/comment/*")
@Controller
public class CommentController {
	
	@Autowired
	private CommentService csv;
	
	@PostMapping(value = "/post", consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> post(@RequestBody CommentVO cvo) {
		log.info("cvo: " + cvo);
		int isOk = csv.post(cvo);
		return isOk > 0 ? new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/{bno}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<CommentVO>> spreadComment(@PathVariable("bno") int bno) {
		log.info("this comment list bno: " + bno);
		List<CommentVO> cvoList = csv.getList(bno);
		return new ResponseEntity<List<CommentVO>> (cvoList, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{cno}", consumes = "application/json", 
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> editComment(@PathVariable("cno") int cno, @RequestBody CommentVO cvo) {
		log.info("edit cno: " + cno);
		log.info("edit cvo: " + cvo);
		
		int isOk = csv.editComment(cvo);
		return isOk > 0 ? new ResponseEntity<String>("1", HttpStatus.OK) 
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value = "/{cno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> removeComment(@PathVariable("cno") int cno) {
		log.info("remove cno: " + cno);
		int isOk = csv.removeComment(cno);
		return isOk > 0 ? new ResponseEntity<String>("1", HttpStatus.OK) 
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
