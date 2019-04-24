package com.hxzy.hrsystem.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 角色表
 */
public class Role implements Serializable {

	private static final long serialVersionUID = -8126774522037041059L;
	private Integer roleId;// 角色ID
	private String roleName;// 角色名
	private String remarks;// 角色备注

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	Set<UserRole> userRoleSet = new HashSet<UserRole>();// 配置与UserRole一对多的关系
	Set<RolePerm> rolePermSet = new HashSet<RolePerm>();// 配置与RolePerm一对多的关系

	public Set<RolePerm> getRolePermSet() {
		return rolePermSet;
	}

	public void setRolePermSet(Set<RolePerm> rolePermSet) {
		this.rolePermSet = rolePermSet;
	}

	public Set<UserRole> getUserRoleSet() {
		return userRoleSet;
	}

	public void setUserRoleSet(Set<UserRole> userRoleSet) {
		this.userRoleSet = userRoleSet;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
