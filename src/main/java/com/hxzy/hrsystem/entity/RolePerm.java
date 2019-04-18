package com.hxzy.hrsystem.entity;

import java.io.Serializable;

public class RolePerm implements Serializable {
	private static final long serialVersionUID = -6877327325778034364L;
	private Integer role_perm_id;// ID;
	private Integer role_id;// 职位id
	private Integer perm_id;// 权限id

	public Integer getRole_perm_id() {
		return role_perm_id;
	}

	public void setRole_perm_id(Integer role_perm_id) {
		this.role_perm_id = role_perm_id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getPerm_id() {
		return perm_id;
	}

	public void setPerm_id(Integer perm_id) {
		this.perm_id = perm_id;
	}

}
