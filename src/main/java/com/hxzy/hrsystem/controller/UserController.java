package com.hxzy.hrsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@RequestMapping(method=RequestMethod.GET, value = "finduser")
	public ModelAndView findUser(@RequestParam("pageNo") String pageNo, ModelAndView mod) {
		int size = 5;// 每次显示条数
		int dno = pageNo == null ? 1 : Integer.parseInt(pageNo);// 当前页数
		int start = (dno - 1) * size;// 开始条数
		List<User> list = us.findUserAllByIndex(start, size);
		int pageCount = us.pageNo(size);// 总页数
		if (us.findUserAllByIndex(start, size) != null) {
			mod.addObject("list", list);// 员工信息集合
			mod.addObject("pageNo", pageCount);// 总页数
			mod.addObject("dno", dno);// 当前页数
			mod.setViewName("user");
		} else {
			mod.setViewName("user");
		}
		return mod;
	}

	/** 修改员工列表 **/
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, value = "updateuser")
	public String updateUser(@ModelAttribute User user) {
		boolean a = true;
		String json1 = "{\"msgs\":1}";
		String json2 = "{\"msgs\":2}";
		try {
			us.updateUsre(user);
		} catch (Exception e) {
			a = false;
		}
		if (a == true) {
			return json1;
		} else {
			return json2;
		}
	}

	/** 删除员工列表 **/
	@ResponseBody
	@RequestMapping(method = RequestMethod.DELETE, value = "deluser")
	public String deleteUser(@RequestParam("one") int a[]) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			list.add(a[i]);
		}
		boolean b = true;
		String json1 = "{\"msgs\":1}";
		String json2 = "{\"msgs\":2}";
		try {
			us.deleteUserAll(list);
		} catch (Exception e) {
			b = false;
		}
		if (b == true) {
			return json1;
		} else {
			return json2;
		}
	}

	/** 添加员工列表 **/
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, value = "adduser")
	public String addUser(@ModelAttribute User user) {
		boolean a = true;
		String json1 = "{\"msgs\":1}";
		String json2 = "{\"msgs\":2}";
		try {
			us.addUser(user);
		} catch (Exception e) {
			a = false;
		}
		if (a == true) {
			return json1;
		} else {
			return json2;
		}
	}
}
