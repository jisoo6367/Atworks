package com.demo.ant.sample.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.ant.sample.service.MemberService;
import com.demo.ant.sample.service.SampleService;
import com.demo.ant.sample.vo.SampleVO;

@Controller
public class MemberController {

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService memberService;
	
	@GetMapping(value={"/register/onLoad"})
	public ModelAndView showJoinForm(HttpServletRequest req) throws Exception {
		System.out.println("회원가입 컨트롤러==========");

		log.info("MemberController memberRegister ###");

		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/main/joinForm");
		return mv;
	};
	
	@PostMapping("/join")
	public String memberRegister (SampleVO sampleVO, RedirectAttributes rttr) throws Exception {
		
		String nickName = memberService.registerMember(sampleVO);
		
		rttr.addFlashAttribute("nickName", nickName);
		
		
		return "redirect:/";
	}
	
	@GetMapping(value={"/user/list"})
	public ModelAndView showUserBoard(Model model) throws Exception {
		System.out.println("유저 게시판  컨트롤러==========");


		List<SampleVO> memberList = memberService.getMemberList();
		
		model.addAttribute("memberList",memberList);
		System.out.println("==========멤버리스트 : " + memberList);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/main/memberBoard");
		return mv;
	};
	
	
	
}
