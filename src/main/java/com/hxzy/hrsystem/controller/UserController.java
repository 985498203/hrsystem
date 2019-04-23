package com.hxzy.hrsystem.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.hrsystem.entity.User;
import com.hxzy.hrsystem.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	@Resource(name = "userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String userList(ModelAndView mav) {
		List<User> list = userService.findAllUser();
		for (User user : list) {
			user.setEmail("9999");
			System.out.println(user);
		}
		return list.toString();
	}
}
