package com.demo.ant.sample.dao;

import java.util.List;

import com.demo.ant.sample.vo.SampleVO;
import com.demo.data.annotation.PrimaryMapperRepository;

@PrimaryMapperRepository
public interface MemberMapper {
	
	public int insertMember(SampleVO member);
	
	public List<SampleVO> selectMemberBoardList();
	
	public SampleVO selectMember(int user_id);
	
	public int updateMember(SampleVO member);

	public int deleteMember(List<Integer> member);
}
