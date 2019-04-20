package com.hxzy.hrsystem.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.hrsystem.dao.UserDao;
import com.hxzy.hrsystem.entity.User;
import com.hxzy.hrsystem.service.UserService;

@Controller
public class LoginController {

	private UserService userService;

	@Resource(name = "userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView Login(ModelAndView mav) {
		System.out.println("你好");
		mav.setViewName("hello");
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		System.out.println("ADD");

		User user = new User();
		user.setUsername("张三");
		user.setPassword("李四");
		userService.addUser(user);
		
		return "hello";
	}

}
