package com.demo.ant.sample.web;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.ant.sample.service.MemberService;
@RequestMapping("/board")
@Controller
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	MemberService memberService;
	
	@GetMapping(value={"/list"})
	public ModelAndView index(HttpServletRequest req) throws Exception {
		System.out.println("==========게시판 컨트롤러");

		log.info("boardController index ###");
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/main/boardList");
		return mv;
	};
	
}
