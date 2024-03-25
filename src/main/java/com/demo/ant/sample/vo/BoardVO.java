package com.demo.ant.sample.vo;

import java.util.Date;

public class BoardVO {

	private 	int idx;
	private		String	title;
	private		String	content;
	private		String	userId;
	private		String	viewCnt;
	private		Date insertTime;
	private		Date updateTime;
	
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(String viewCnt) {
		this.viewCnt = viewCnt;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", title=" + title + ", content=" + content + ", userId=" + userId + ", viewCnt="
				+ viewCnt + ", insertTime=" + insertTime + ", updateTime=" + updateTime + ", getIdx()=" + getIdx()
				+ ", getTitle()=" + getTitle() + ", getContent()=" + getContent() + ", getUserId()=" + getUserId()
				+ ", getViewCnt()=" + getViewCnt() + ", getInsertTime()=" + getInsertTime() + ", getUpdateTime()="
				+ getUpdateTime() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	


	
}
