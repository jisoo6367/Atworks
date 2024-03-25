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

	@Override
	public SampleVO getMember(int user_id) {
		
		SampleVO member = memberMapper.selectMember(user_id);
		System.out.println("서비스임플에서 member정보 : "+ member);
		
		return member;
	}

	@Override
	public String modifyMember(SampleVO member) {
		int result = memberMapper.updateMember(member);
		
		return (result == 1) ? "1" : "0";
	}
	

	@Override
	public int deleteMember(List<Integer> member) {
		int result = memberMapper.deleteMember(member);
		return result;
	}

	
}
