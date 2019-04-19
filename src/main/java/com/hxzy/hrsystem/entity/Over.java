package com.hxzy.hrsystem.entity;

import java.io.Serializable;

/**
 * 加班表over
 *
 */
public class Over implements Serializable {
	private static final long serialVersionUID = -8906433778514894583L;
	private Integer overId;
	private User user;
	private String overTime;

	public Integer getOverId() {
		return overId;
	}

	public void setOverId(Integer overId) {
		this.overId = overId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOverTime() {
		return overTime;
	}

	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}


}
