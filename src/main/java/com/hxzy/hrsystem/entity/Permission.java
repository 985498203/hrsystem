package com.hxzy.hrsystem.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Permission implements Serializable {
	private static final long serialVersionUID = -912119834241803878L;
	private Integer perm_id;// 权限ID
	private String perm_name;//权限名称
	private String url;//权限对应url
	
	Set<RolePerm> rolePermSet = new HashSet<RolePerm>();// 配置与RolePerm一对多的关系
	
	public Set<RolePerm> getRolePermSet() {
		return rolePermSet;
	}
	public void setRolePermSet(Set<RolePerm> rolePermSet) {
		this.rolePermSet = rolePermSet;
	}
	
	public Integer getPerm_id() {
		return perm_id;
	}
	public void setPerm_id(Integer perm_id) {
		this.perm_id = perm_id;
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
