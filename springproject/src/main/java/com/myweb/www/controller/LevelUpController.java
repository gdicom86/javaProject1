package com.myweb.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myweb.www.domain.LevelUpVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.handler.PagingHandler;
import com.myweb.www.service.LevelUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/levelUp/*")
@Controller
public class LevelUpController {
	
	@Autowired
	private LevelUpService lsv;
	
	@GetMapping("/register")
	public String getLevelUp() {
		return "levelUp/register";
	}
	
	@PostMapping("/register")
	public String postLevelUp(LevelUpVO lvo) {
		log.info("lvo: " + lvo);
		int isOk = lsv.register(lvo);
		String result = isOk > 0 ? "등록 성공" : "등록 실패";
		log.info(result);
		
		return "home";
	}
	
	@GetMapping("/needConfirm")
	public String getNeedConfirm(Model model, PagingVO pvo) {
		log.info("pageNo: " + pvo.getPageNo());
		List<LevelUpVO> lvoList = lsv.getList(pvo);
		log.info(lvoList.toString());
		model.addAttribute("lvoList", lvoList);
		int totalCount = lsv.getTotalCount();
		PagingHandler ph = new PagingHandler(pvo, totalCount);
		model.addAttribute("ph", ph);
		return "levelUp/needConfirm";
	}
	
	@PostMapping("/proceeding")
	public String proceeding(@RequestParam("lno") int lno, @RequestParam("id") String id) {
		log.info("lno: " + lno);
		log.info("id: " + id);
		int isOk = lsv.updateConfirm(lno, id);
		String result = isOk > 0 ? "업데이트 성공" : "업데이트 실패";
		log.info(result);
		return "redirect:/levelUp/needConfirm";
	}
	
}