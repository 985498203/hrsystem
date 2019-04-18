package com.hxzy.hrsystem.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 职位表
 */
public class Role implements Serializable {

	private static final long serialVersionUID = -8126774522037041059L;
	private Integer role_id;// 职位ID
	private String role_name;// 职位名

	Set<UserRole> userRoleSet = new HashSet<UserRole>();// 配置与UserRole一对多的关系

	public Set<UserRole> getUserRoleSet() {
		return userRoleSet;
	}

	public void setUserRoleSet(Set<UserRole> userRoleSet) {
		this.userRoleSet = userRoleSet;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
}
