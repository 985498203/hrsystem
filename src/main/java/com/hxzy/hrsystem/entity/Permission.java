package com.hxzy.hrsystem.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Pattern;

public class Permission implements Serializable {
	private static final long serialVersionUID = -912119834241803878L;
	private Integer permId;// 权限ID
	@Pattern(regexp = "(^[a-zA-Z0-9_-]{2,50}$)|(^[\\u2E80-\\u9FFF]{2,20}$)", message = "权限名必须为2-20汉字或者2-50数字字母的组合")
	private String permName;// 权限名称
	@Pattern(regexp = "^[^\\u4e00-\\u9fa5]{2,1999}+$", message = "URL不能包含汉字且长度必须大于1")
	private String url;// 权限对应url
	private boolean open;// 树节点是否打开
	private Permission parent;// 上级权限
	private Set<Permission> children = new HashSet<Permission>();// 下级权限

	Set<RolePerm> rolePermSet = new HashSet<RolePerm>();// 配置与RolePerm一对多的关系

	public Permission(String permName, String url, Permission parent) {
		super();
		this.permName = permName;
		this.url = url;
		this.parent = parent;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public Permission() {
		super();
	}

	public Permission getParent() {
		return parent;
	}

	public void setParent(Permission parent) {
		this.parent = parent;
	}

	public Set<Permission> getChildren() {
		return children;
	}

	public void setChildren(Set<Permission> children) {
		this.children = children;
	}

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
