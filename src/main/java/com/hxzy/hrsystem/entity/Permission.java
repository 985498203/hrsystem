package com.hxzy.hrsystem.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Permission implements Serializable {
	private static final long serialVersionUID = -912119834241803878L;
	private Integer permId;// 权限ID
	private String permName;//权限名称
	private String url;//权限对应url
	
	Set<RolePerm> rolePermSet = new HashSet<RolePerm>();// 配置与RolePerm一对多的关系
	
	public Set<RolePerm> getRolePermSet() {
		return rolePermSet;
	}
	public void setRolePermSet(Set<RolePerm> rolePermSet) {
		this.rolePermSet = rolePermSet;
	}
	public Integer getPermId() {
		return permId;
	}
	public void setPermId(Integer permId) {
		this.permId = permId;
	}
	public String getPermName() {
		return permName;
	}
	public void setPermName(String permName) {
		this.permName = permName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


}
