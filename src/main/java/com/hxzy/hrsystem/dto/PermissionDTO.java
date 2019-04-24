package com.hxzy.hrsystem.dto;

import java.io.Serializable;

public class PermissionDTO implements Serializable {

	private static final long serialVersionUID = -6992320254277211938L;
	private Integer permId;// 权限ID
	private String permName;// 权限名称
	private String url;// 权限对应url

	public PermissionDTO(Integer permId, String permName, String url) {
		super();
		this.permId = permId;
		this.permName = permName;
		this.url = url;
	}

	public PermissionDTO() {
		super();
		// TODO Auto-generated constructor stub
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
