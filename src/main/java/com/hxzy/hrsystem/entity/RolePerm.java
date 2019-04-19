package com.hxzy.hrsystem.entity;

import java.io.Serializable;

public class RolePerm implements Serializable {
	private static final long serialVersionUID = -6877327325778034364L;
	private Integer rolePermId;// ID;

	private Permission permission;// 权限
	private Role role;// 职位
	
	public Integer getRolePermId() {
		return rolePermId;
	}
	public void setRolePermId(Integer rolePermId) {
		this.rolePermId = rolePermId;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}
