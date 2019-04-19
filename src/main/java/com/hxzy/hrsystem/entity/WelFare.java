package com.hxzy.hrsystem.entity;

import java.io.Serializable;

/**
 * 福利表tb_welfare
 * 
 * 
 * @author Administrator
 *
 */
public class WelFare implements Serializable {
	private static final long serialVersionUID = 3493014090333518341L;

	private Integer welfareId;

	private Funds funds;// 公基金表funds

	private Social social;// 社保表social

	public Integer getWelfareId() {
		return welfareId;
	}

	public void setWelfareId(Integer welfareId) {
		this.welfareId = welfareId;
	}

	public Funds getFunds() {
		return funds;
	}

	public void setFunds(Funds funds) {
		this.funds = funds;
	}

	public Social getSocial() {
		return social;
	}

	public void setSocial(Social social) {
		this.social = social;
	}
}
