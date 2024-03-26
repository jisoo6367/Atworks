package com.demo.ant.sample.vo;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;



public class SampleVO {

	private 	int userId;
	private		String	userNm;
	private		String	passWd;
	private		String	nick;
	private		String	email;
	private		String	phone;
	
	private		String	admin;
	
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}

    // 이 메서드는 Collection<? extends GrantedAuthority>를 반환해야 합니다.
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // admin 정보를 이용하여 SimpleGrantedAuthority 객체로 변환하여 authorities에 추가합니다.
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(admin));
        // 만약 더 복잡한 권한 처리 로직이 필요하다면 여기에 추가해야 합니다.
        return authorities;
    }
	
	
	
	private List<Integer> selectedUserIds;
	

	
	public List<Integer> getSelectedUserIds() {
		return selectedUserIds;
	}
	public void setSelectedUserIds(List<Integer> selectedUserIds) {
		this.selectedUserIds = selectedUserIds;
	}

	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "SampleVO [userId=" + userId + ", userNm=" + userNm + ", passWd=" + passWd + ", nick=" + nick
				+ ", email=" + email + ", phone=" + phone + ", getUserId()=" + getUserId() + ", getUserNm()="
				+ getUserNm() + ", getPassWd()=" + getPassWd() + ", getNick()=" + getNick() + ", getEmail()="
				+ getEmail() + ", getPhone()=" + getPhone() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}	
	
}
