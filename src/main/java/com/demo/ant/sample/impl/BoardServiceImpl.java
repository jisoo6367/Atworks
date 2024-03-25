package com.demo.ant.sample.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ant.sample.dao.BoardMapper;
import com.demo.ant.sample.service.BoardService;
import com.demo.ant.sample.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;

	@Override
	public List<BoardVO> getBoardList() {
		
		List<BoardVO> boardList = boardMapper.selectBoardList();
		System.out.println("서비스임플에서 boardList : " + boardList);
		
		return boardList;
	}
	

	@Override
	public BoardVO getBoard(int idx) {
		BoardVO board = boardMapper.selectBoard(idx);
		System.out.println("서비스임플에서 board : " + board);
		
		return board;
	}

	
	@Override
	public String registerBoard(BoardVO board) {
		
		int result = boardMapper.insertBoard(board);
		return (result == 1 ) ? "successRegister" : "failRegister";
	}


	@Override
	public String modifyBoard(BoardVO board) {
		
		int result = boardMapper.updateBoard(board);
		return (result == 1) ? "successModify" : "failModify";
	}


	@Override
	public String deleteBoard(int idx) {
		
		int result = boardMapper.deleteBoard(idx);
		return  (result == 1) ? "successDelete" : "failDelete";
	}

	
}
