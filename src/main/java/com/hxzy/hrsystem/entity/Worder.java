package com.hxzy.hrsystem.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 工单表
 *
 */
public class Worder implements Serializable {
	private static final long serialVersionUID = 4221986855064838179L;
	private Integer worderId;// id
	private String title;// 工单标题
	private String detail;// 工单详情
	private String state;// 工单状态

	private User user;// 用户，配置一对一
	
	private Set<WorderRecord> worderRecordSet = new HashSet<WorderRecord>();// 工单申请记录
	


	public Set<WorderRecord> getWorderRecordSet() {
		return worderRecordSet;
	}

	public void setWorderRecordSet(Set<WorderRecord> worderRecordSet) {
		this.worderRecordSet = worderRecordSet;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Integer getWorderId() {
		return worderId;
	}

	public void setWorderId(Integer worderId) {
		this.worderId = worderId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
