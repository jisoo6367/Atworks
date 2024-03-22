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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.ant.sample.service.MemberService;
import com.demo.ant.sample.service.SampleService;
import com.demo.ant.sample.vo.SampleVO;
@RequestMapping("/member")
@Controller
public class MemberController {

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService memberService;
	
	
	// 회원가입 페이지로 이동
	@GetMapping(value={"/register"})
	public ModelAndView showJoinForm(HttpServletRequest req) throws Exception {
		System.out.println("회원가입 컨트롤러==========");

		log.info("MemberController memberRegister ###");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/main/joinForm");
		return mv;
	};
	
	
	// 회원가입 DB작업
	@PostMapping("/join")
	public String memberRegister (SampleVO sampleVO, RedirectAttributes rttr) throws Exception {
		
		String nickName = memberService.registerMember(sampleVO);
		
		rttr.addFlashAttribute("nickName", nickName);
		
		return "redirect:/";
	}
	
	
	// 유저 게시판 첫화면 (모든 멤버 정보리스트)
	@GetMapping(value={"/list"})
	public ModelAndView showMemberBoard(Model model) throws Exception {
		System.out.println("유저 게시판 컨트롤러==========");


		List<SampleVO> memberList = memberService.getMemberList();
		
		model.addAttribute("memberList",memberList);
		System.out.println("==========멤버리스트 : " + memberList);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/main/memberBoard");
		return mv;
	};
	
	
	
	// 특정 회원 상세 정보 
	@GetMapping("/detail")
	public String showMemberDetail(int userId, Model model) {
		System.out.println("유저 디테일 컨트롤러 ==========");
		
		System.out.println("jsp->컨트롤러 값 넘어오나확인 : " + userId);
		
		SampleVO member = memberService.getMember(userId);
		
		model.addAttribute("member", member);
		System.out.println("컨트롤러에서 멤버정보 : " + member);
		
		return "/main/memberDetail";
	}
	
	
	// 수정된 정보 받아와서 DB작업
	@PostMapping("/modify")
	public String memberModify(SampleVO member, RedirectAttributes rttr) {
		System.out.println("유저 정보 수정 컨트롤러==========");

		System.out.println("회원 고유 번호 : " + member.getUserId());
		System.out.println("수정한 비밀 번호 : " +member.getPassWd());
		
		int result = memberService.modifyMember(member);
		System.out.println("성공 여부 : " + result);
		
		int userId = member.getUserId();
		rttr.addAttribute("userId",userId);
		
		
		return "redirect:/member/detail";
	}
	
	@PostMapping("/delete")
	public String memberDelete(@RequestBody SampleVO member, Model model) {
		System.out.println("유저 삭제 컨트롤러==========");

        List<Integer> selectedUserIds = member.getSelectedUserIds();

        System.out.println("체크된 회원고유번호 : " + selectedUserIds);
        
        int result = memberService.deleteMember(member.getSelectedUserIds());
        System.out.println("삭제 결과 : " + result);
        
        model.addAttribute("result", result);
        
		return "/main/memberBoard";
	}
	
	
	
}
