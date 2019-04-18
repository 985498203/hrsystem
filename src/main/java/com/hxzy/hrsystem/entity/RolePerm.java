package com.hxzy.hrsystem.entity;

import java.io.Serializable;

public class RolePerm implements Serializable {
	private static final long serialVersionUID = -6877327325778034364L;
	private Integer role_perm_id;// ID;

	private Permission permission;// 权限
	private Role role;// 职位
	
	public Integer getRole_perm_id() {
		return role_perm_id;
	}
	public void setRole_perm_id(Integer role_perm_id) {
		this.role_perm_id = role_perm_id;
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
