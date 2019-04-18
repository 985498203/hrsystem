package com.hxzy.hrsystem.entity;

import java.io.Serializable;

public class Permission implements Serializable {
	private static final long serialVersionUID = 4610103042039300230L;
	private Integer role_id;// 权限ID
	private String perm_name;//权限名称
	private String url;//权限对应url
	
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getPerm_name() {
		return perm_name;
	}
	public void setPerm_name(String perm_name) {
		this.perm_name = perm_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


}
