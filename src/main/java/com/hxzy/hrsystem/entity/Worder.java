package com.hxzy.hrsystem.entity;

import java.io.Serializable;

public class Worder implements Serializable{
	private static final long serialVersionUID = 4221986855064838179L;
	private Integer worder_id;// id
	private String title;// 工单标题
	private String detail;// 工单详情
	private String state;// 工单状态
	private String user_id;// 工单受理人
	
	public Integer getWorder_id() {
		return worder_id;
	}
	public void setWorder_id(Integer worder_id) {
		this.worder_id = worder_id;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
}
