package com.demo.ant.sample.service;

import java.util.List;

import com.demo.ant.sample.vo.SampleVO;

public interface MemberService {

	public String registerMember(SampleVO member) throws Exception;
	
	public List<SampleVO> getMemberList() throws Exception;
}
