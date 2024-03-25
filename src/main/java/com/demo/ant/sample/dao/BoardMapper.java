package com.demo.ant.sample.dao;


import java.util.List;

import com.demo.ant.sample.vo.BoardVO;
import com.demo.data.annotation.PrimaryMapperRepository;

@PrimaryMapperRepository
public interface BoardMapper {
	

	public List<BoardVO> selectBoardList();

	public BoardVO selectBoard(int idx);
	
	public int insertBoard (BoardVO board);
	
	public int updateBoard (BoardVO board);
	
	public int deleteBoard (int idx);
	
	
	

}
