package com.demo.ant.sample.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ant.sample.dao.MemberMapper;
import com.demo.ant.sample.dao.SampleMapperDao;
import com.demo.ant.sample.service.MemberService;
import com.demo.ant.sample.service.SampleService;
import com.demo.ant.sample.vo.SampleVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberMapper memberMapper;

	@Override
	public String registerMember(SampleVO member) throws Exception {
		memberMapper.insertMember(member);
		return member.getNick();
	}
	
	@Override
	public List<SampleVO> getMemberList() throws Exception {
		List<SampleVO> memberList = memberMapper.selectMemberBoardList();
		System.out.println("서비스임플에서 memberList : " + memberList);
		
		return memberList;
	}

	
}
