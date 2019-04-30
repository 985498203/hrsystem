package com.hxzy.hrsystem.dao.impl;

import java.util.Properties;

import javax.mail.Session;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.dao.EmailDao;

@Component("emailDao")
public class EmailDaoimpl implements EmailDao {
	private static final String EMAIL = "Liu2971621368@163.com";// 发件人邮箱
	private static final String SMTP = "smtp.163.com";// smtp服务
	private static final String PWD = "liu15111412428";// 163授权码
	private static final String SUBJECT = "转正通知";// 邮件标题

	/** 发送邮件 **/
	public boolean sendEmails(String email, String name) {
		boolean a = true;
		try {
			System.out.println("来了？");
			JavaMailSenderImpl sender = new JavaMailSenderImpl();
			sender.setHost(SMTP);
			sender.setPort(25);
			sender.setUsername(EMAIL);
			sender.setPassword(PWD);
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			Session session = Session.getInstance(props);
			sender.setSession(session);
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(email);
			mail.setSubject("转正通知!");
			mail.setFrom(EMAIL);
			mail.setText(name + "您好！，由于您在本公司，实习期间表现优异，提前转正!，请于2019年4月25日到软件部报道，谢谢!");
			sender.send(mail);
		} catch (Exception e) {
			a = false;
			e.getStackTrace();
		}
		return a;
	}
}
