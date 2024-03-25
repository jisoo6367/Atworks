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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.ant.sample.service.BoardService;
import com.demo.ant.sample.service.MemberService;
import com.demo.ant.sample.vo.BoardVO;
@RequestMapping("/board")
@Controller
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardService boardService;
	
	@GetMapping(value={"/list"})
	public ModelAndView index(HttpServletRequest req, Model model,
			@RequestParam(value = "result", required = false) String result) throws Exception {
		System.out.println("==========게시판 컨트롤러");

		log.info("boardController index ###");
		
		List<BoardVO> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		System.out.println("==========컨트롤러에서 boardList : " + boardList );
		
		model.addAttribute("result", result);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/main/boardList");
		return mv;
	};
	
	
	@GetMapping("/detail")
	public String showBoardDetail(int idx, Model model) {
		System.out.println("==========게시판 디테일 컨트롤러");
		System.out.println("게시판 인덱스 잘 넘어오나? " + idx);
		
		BoardVO board = boardService.getBoard(idx);
		System.out.println("컨트롤러에서 board : " + board);
		
		model.addAttribute( "board",board);
		return "/main/boardDetail";
	}

	
	@GetMapping("/register")
	public String showRegisterForm() {
		System.out.println("==========게시글 등록 페이지로");
		return "/main/boardRegister";
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		System.out.println("==========DB로 inser하러");
		String result = boardService.registerBoard(board);
		
		rttr.addAttribute("result", result);
		
		return "redirect:/board/list";
	}
	
	
	@GetMapping("/modify")
	public String showModifyForm(int idx, Model model) {
		System.out.println("==========게시글 수정 페이지로");
		
		BoardVO board = boardService.getBoard(idx);
		model.addAttribute( "board",board);
		
		return "/main/boardModify";
	}
	
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		System.out.println("==========DB로 update하러");
		
		String result = boardService.modifyBoard(board);
		rttr.addAttribute("result", result);
		
		return "redirect:/board/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(int idx, RedirectAttributes rttr) {
		System.out.println("==========게시글 삭제 메서드");
		
		String result = boardService.deleteBoard(idx);
		rttr.addAttribute("reuslt" ,result);
		
		return "redirect:/board/list";
	}
}
