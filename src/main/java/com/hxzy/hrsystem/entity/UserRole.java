package com.hxzy.hrsystem.entity;

import java.io.Serializable;

/**
 * 员工职位中间表 tb_user_role
 */
public class UserRole implements Serializable {
	private static final long serialVersionUID = 6530626026356673685L;
	private Integer userRoleId;// id

	private User user;// 用户

	private Role role;// 职位

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

}
