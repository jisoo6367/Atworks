package com.demo.ant.sample.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.ant.sample.service.SampleService;

@Controller
public class SampleController {

	private static final Logger log = LoggerFactory.getLogger(SampleController.class);

	@Autowired
	SampleService	sampleService;
	
	@GetMapping(value={"/","main"})
	public ModelAndView index(HttpServletRequest req) throws Exception {
		System.out.println("컨트롤러까지 오긴 하는지?");

		log.info("smapleController index ###");
		
		sampleService.selectAtworks();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/main/main");
		return mv;
	};
	
	@GetMapping("/login")
	public String login() {
		return "/main/login";
	}
	
	@PostMapping("/check")
	public @ResponseBody String check(String userNm, String passWd) {
		System.out.println(userNm);
		return "왜 오류?";
	}
	
}
