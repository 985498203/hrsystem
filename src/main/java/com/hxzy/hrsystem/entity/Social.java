package com.hxzy.hrsystem.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 社保表social
 * 
 * @author Administrator
 *
 */
public class Social implements Serializable{

	private static final long serialVersionUID = -1640619429644395440L;
	private Integer socialId;// id
	private Double money;// 金额
	private User user; // 员工

	
	public Integer getSocialId() {
		return socialId;
	}

	public void setSocialId(Integer socialId) {
		this.socialId = socialId;
	}

	/* 配置与福利表Welfare一对多的关系 */
	private Set<WelFare> welFareSet = new HashSet<WelFare>();
	public Set<WelFare> getWelFareSet() {
		return welFareSet;
	}

	public void setWelFareSet(Set<WelFare> welFareSet) {
		this.welFareSet = welFareSet;
	}

	

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
