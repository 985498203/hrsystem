package com.hxzy.hrsystem.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 公基金表tb_funds
 * 
 * @author Administrator
 *
 */
public class Funds implements Serializable{
	private static final long serialVersionUID = -488581616586003210L;
	private Integer fundsId;// id
	private Double money;// 金额
	private User user; // 员工
	
	/* 配置与福利表Welfare一对多的关系 */
	private Set<WelFare> welFareSet = new HashSet<WelFare>();
	
	public Set<WelFare> getWelFareSet() {
		return welFareSet;
	}
	public void setWelFareSet(Set<WelFare> welFareSet) {
		this.welFareSet = welFareSet;
	}
	
	public Integer getFundsId() {
		return fundsId;
	}
	public void setFundsId(Integer fundsId) {
		this.fundsId = fundsId;
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
