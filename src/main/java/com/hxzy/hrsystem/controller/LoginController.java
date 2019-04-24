package com.hxzy.hrsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public ModelAndView Login(ModelAndView mav) {
		System.out.println("你好");
		mav.setViewName("hello");
		return mav;
	}
}