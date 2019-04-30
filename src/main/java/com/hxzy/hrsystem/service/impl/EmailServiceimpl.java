package com.hxzy.hrsystem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.dao.EmailDao;
import com.hxzy.hrsystem.dao.impl.EmailDaoimpl;
import com.hxzy.hrsystem.service.EmailService;

@Component("emailService")
public class EmailServiceimpl implements EmailService {
	private EmailDao ed;

	@Resource(name = "emailDao")
	public void setEd(EmailDaoimpl ed) {
		this.ed = ed;
	}

	/** 发送邮件 **/
	public boolean sendEmails(String email, String name) {
		return ed.sendEmails(email, name);
	}

}
