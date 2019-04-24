package com.hxzy.hrsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.hrsystem.entity.User;
import com.hxzy.hrsystem.service.UserService;

@Controller
public class UserController {
	private UserService us;

	@Resource(name = "userServiceImpl")
	public void setUs(UserService us) {
		this.us = us;
	}

	/** 查询员工列表 **/
	@RequestMapping(method = RequestMethod.GET, value = "finduser")
	public ModelAndView findUser(@RequestParam("pageNo") String pageNo, ModelAndView mod) {
		int size = 5;// 每次显示条数
		int dno = pageNo == null ? 1 : Integer.parseInt(pageNo);// 当前页数
		int pageCount = us.pageNo(size);// 总页数
		int start = (dno - 1) * size;// 开始条数
		List<User> list = us.findUserAllByIndex(start, size);
		if (us.findUserAllByIndex(start, size) != null) {
			mod.addObject("list", list);// 员工信息集合
			mod.addObject("pageNo", pageCount);// 总页数
			mod.addObject("dno", dno);// 当前页数
			mod.setViewName("index");
		} else {
			mod.setViewName("index");
		}
		return mod;
	}

	/** 修改员工列表 **/
	@RequestMapping(method = RequestMethod.POST, value = "updateuser")
	public ModelAndView updateUser(@ModelAttribute User user, ModelAndView mod) {
		User user2 = us.getUserById(user.getUserId());
		user2.setUserId(user.getUserId());
		user2.setName(user.getName());
		user2.setAge(user.getAge());
		user2.setPhone(user.getPhone());
		user2.setEmail(user.getEmail());
		us.updateUsre(user2);
		mod.setViewName("index");
		return mod;
	}

	/** 删除员工列表 **/
	@RequestMapping(method = RequestMethod.POST, value = "deluser")
	public ModelAndView deleteUser(@RequestParam("one") String a, ModelAndView mod) {
		String[] array = a.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			list.add(Integer.parseInt(array[i]));
		}
		us.deleteUserAll(list);
		mod.setViewName("index");
		return mod;
	}

	/** 添加员工列表 **/
	@RequestMapping(method = RequestMethod.POST, value = "adduser")
	public ModelAndView addUser(@ModelAttribute User user, ModelAndView mod) {
		us.addUser(user);
		mod.setViewName("index");
		return mod;
	}
}
