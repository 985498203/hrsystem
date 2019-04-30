package com.hxzy.hrsystem.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxzy.hrsystem.service.EmailService;

@Controller
public class EmailController {
	private EmailService es;

	@Resource(name = "emailService")
	public void setEs(EmailService es) {
		this.es = es;
	}

	@RequestMapping(method = RequestMethod.POST, value = "tongzhi")
	@ResponseBody
	public String sendEmail(@RequestParam("email") String email, @RequestParam("name") String name) {
		String json1 = "{\"msg\":1}";
		String json2 = "{\"msg\":2}";
		if (es.sendEmails(email, name) == true) {
			return json1;
		} else {
			return json2;
		}
	}
}
