package com.hxzy.hrsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView toLogin(ModelAndView mav) {
		mav.setViewName("login");// 跳转至登录页面
		return mav;
	}

	@RequestMapping(value = "error", method = RequestMethod.GET)
	public ModelAndView toError(ModelAndView mav) {
		mav.setViewName("error");// 跳转至错误页面
		return mav;
	}

	@RequestMapping(value = "403", method = RequestMethod.GET)
	public ModelAndView to403(ModelAndView mav) {
		mav.setViewName("403");// 跳转至403页面
		return mav;
	}
}
