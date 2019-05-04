package com.hxzy.hrsystem.param;

import java.io.Serializable;

public class PermissionParam implements Serializable {

	private static final long serialVersionUID = 4274403739753328955L;
	private Integer permId;// 权限ID
	private String permName;// 权限名称
	private String url;// 权限对应url
	private Boolean open;// 节点是否打开
	private boolean checked = false;// 是否选中
	private Integer parentId;// 上级ID

	public Integer getPermId() {
		return permId;
	}

	public PermissionParam(Integer permId, String permName, String url, Integer parentId, Boolean open) {
		super();
		this.permId = permId;
		this.permName = permName;
		this.url = url;
		this.open = open;
		this.parentId = parentId;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
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

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public void setPermId(Integer permId) {
		this.permId = permId;
	}

}
