package com.hxzy.hrsystem.entity;

import java.io.Serializable;

/**
 * 工单申请记录表worderRecord
 *
 * 
 */
public class WorderRecord implements Serializable {
	private static final long serialVersionUID = -7708357315346185125L;
	private Integer worderRecordId;// id
	private Integer nameId;// 申请人id

	private Worder worder;// 工单
	private User user;// 用户

	public Worder getWorder() {
		return worder;
	}

	public void setWorder(Worder worder) {
		this.worder = worder;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private Integer worder_id;// 对应工单id
	private Integer time;// 申请时间

	public Integer getWorderRecordId() {
		return worderRecordId;
	}

	public void setWorderRecordId(Integer worderRecordId) {
		this.worderRecordId = worderRecordId;
	}

	public Integer getNameId() {
		return nameId;
	}

	public void setNameId(Integer nameId) {
		this.nameId = nameId;
	}

	public Integer getWorder_id() {
		return worder_id;
	}

	public void setWorder_id(Integer worder_id) {
		this.worder_id = worder_id;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

}
