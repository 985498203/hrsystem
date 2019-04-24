package com.hxzy.hrsystem.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.hxzy.hrsystem.service.UserService;

@Controller
public class LoginController {
	private UserService userService;
	
	@Resource(name = "userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

//	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
//	public ModelAndView Login(ModelAndView mav) {
//		System.out.println("你好");
//		mav.setViewName("login");
//		return mav;
//	}

	
//	@RequestMapping(value = "/add", method = RequestMethod.GET)
//	public ModelAndView login(ModelAndView mav) {
//		User user = new User();
//		user.setUsername("bb");
//		user.setPassword("cc");
//		userService.addUser(user);
//		System.out.println("添加成功");
//		mav.setViewName("main");
//		System.out.println("添加用户controller");
//		return mav;
//	}

}
