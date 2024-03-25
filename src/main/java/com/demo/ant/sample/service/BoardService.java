package com.demo.ant.sample.service;

import java.util.List;

import com.demo.ant.sample.vo.BoardVO;

public interface BoardService {

	// 모든 리스트 가져오는 첫 페이지
	public List<BoardVO> getBoardList();
	
	// 특정 게시글 detail
	public BoardVO getBoard (int idx);
	
	// 게시글 등록
	public String registerBoard(BoardVO board) ;
	
	// 게시글 수정
	public String modifyBoard(BoardVO board);
	
	//게시글 삭제
	public String deleteBoard(int idx);
}
