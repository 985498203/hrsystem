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

import com.hxzy.hrsystem.entity.Worder;
import com.hxzy.hrsystem.service.WorderService;

@Controller
public class WorderController {
	private WorderService ws;

	@Resource(name = "worderService")
	public void setWs(WorderService ws) {
		this.ws = ws;
	}

	/** 查询工单列表 **/
	@RequestMapping(method={RequestMethod.GET,RequestMethod.POST}, value = "findworder")
	public ModelAndView findWorder(@RequestParam("pageNo") String pageNo, ModelAndView mod) {
		int end = 5;// 每页显示条数
		int dno = pageNo == null ? 1 : Integer.parseInt(pageNo);// 当前页数
		int start = (dno - 1) * end;// 开始条数
		List<Worder> worder = ws.findAll(start, end);
		int pageCount = ws.pageNo(end);// 总页数
		if (ws.findAll(start, end) != null) {
			mod.addObject("worderlist", worder);
			mod.addObject("worderPageNo", pageCount);
			mod.addObject("dno", dno);
			mod.setViewName("gongdan");
		}
		return mod;
	}

	/** 修改工单列表 **/
	@RequestMapping(method = RequestMethod.PUT, value = "updateworder")
	@ResponseBody
	public String updateWorder(@ModelAttribute Worder worder) {
		boolean a = true;
		String json1 = "{\"msg\":1}";
		String json2 = "{\"msg\":2}";
		try {
			ws.updateAll(worder);
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
	@RequestMapping(method = RequestMethod.DELETE, value = "delworder")
	public String deleteWorder(@RequestParam("one") int a[]) {
		List<Integer> list = new ArrayList<Integer>();
		boolean b = true;
		String json1 = "{\"msg\":1}";
		String json2 = "{\"msg\":2}";
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
			list.add(a[i]);
		}
		try {
			ws.deleteAll(list);
		} catch (Exception e) {
			b = false;
		}
		if (b == true) {
			return json1;
		} else {
			return json2;
		}

	}

	/** 添加工单 **/
	@RequestMapping(method = RequestMethod.PUT, value = "addworder")
	public ModelAndView addWorder(@ModelAttribute Worder worder, ModelAndView mod) {
		ws.addAll(worder);
		mod.setViewName("gongdan");
		return mod;
	}

	@RequestMapping(method = RequestMethod.POST, value = "view")
	public ModelAndView view(ModelAndView mod) {
		mod.setViewName("gongdan");
		return mod;
	}
}
