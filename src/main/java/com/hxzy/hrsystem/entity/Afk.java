package com.hxzy.hrsystem.entity;

import java.io.Serializable;

/**
 * 请假表afk
 *
 */
public class Afk implements Serializable {
	private static final long serialVersionUID = 7797143303530272908L;
	private Integer AfkId;//id
	private String beginAfk;//请假开始时间
	private String endAfk;//请假结束时间
	private String afkTime;//请假时间
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getAfkId() {
		return AfkId;
	}

	public void setAfkId(Integer afkId) {
		AfkId = afkId;
	}

	public String getBeginAfk() {
		return beginAfk;
	}

	public void setBeginAfk(String beginAfk) {
		this.beginAfk = beginAfk;
	}

	public String getEndAfk() {
		return endAfk;
	}

	public void setEndAfk(String endAfk) {
		this.endAfk = endAfk;
	}

	public String getAfkTime() {
		return afkTime;
	}

	public void setAfkTime(String afkTime) {
		this.afkTime = afkTime;
	}

}
