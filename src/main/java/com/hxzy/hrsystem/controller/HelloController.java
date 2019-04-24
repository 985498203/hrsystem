package com.hxzy.hrsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView Login(ModelAndView mav) {
		System.out.println("主页");
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping(value = "/a", method = RequestMethod.GET)
	public ModelAndView Logina(ModelAndView mav) {
		System.out.println("主页");
		mav.setViewName("a");
		return mav;
	}
}
