package com.demo.ant.security.web.core.userdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.demo.ant.sample.dao.MemberMapper;
import com.demo.ant.sample.vo.SampleVO;
import com.demo.ant.security.core.userdetails.LoginUser;

public class DaoUserDetailsService implements UserDetailsService, LoginUserDetailsService {
    @Autowired
    private LoginUserDetailsService loginUserDetailsService;
    
    private MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
    	
    	SampleVO member = memberMapper.selectMember(Integer.parseInt(username));
    	UserDetails userDetail = new LoginUser(username, member.getPassWd(), member.getAuthorities());
    	System.out.println("=========로그인 userDetail : " + userDetail);
    	
    	//return loginUserDetailsService.loadUserByUsername(username);
    	return member == null ? null : userDetail;
    }
}
