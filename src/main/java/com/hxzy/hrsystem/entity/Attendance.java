package com.hxzy.hrsystem.entity;

import java.io.Serializable;

/**
 * 考勤表attendance
 * 
 * @author Administrator
 *
 */
public class Attendance implements Serializable{
	private static final long serialVersionUID = 4990077416289687335L;
	private Integer attenId;// id
	private User user;// 员工
	private String beginTime;// 上班时间
	private String endTime;// 下班时间
	private Integer late;// 迟到记录
	private Integer absent;// 旷工次数
	public Integer getAttenId() {
		return attenId;
	}
	public void setAttenId(Integer attenId) {
		this.attenId = attenId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getLate() {
		return late;
	}
	public void setLate(Integer late) {
		this.late = late;
	}
	public Integer getAbsent() {
		return absent;
	}
	public void setAbsent(Integer absent) {
		this.absent = absent;
	}

	
}
