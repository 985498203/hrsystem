package com.hxzy.hrsystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.hrsystem.entity.Worder;
import com.hxzy.hrsystem.service.WorderService;

@Controller
public class WorderController {
	private WorderService worderService;
	
	@Resource(name="worderServiceImpl")
	public void setWorderService(WorderService worderService) {
		this.worderService=worderService;
	}
	/**
	 * 
	 * 查询所有工单
	 * 
	 * @param mav
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/worder",method=RequestMethod.GET)
	public ModelAndView findWorderAll(ModelAndView mav, HttpServletRequest request) {
		System.out.println("1");
		List<Worder> worder = (List<Worder>) worderService.findWorderAll();
		mav.setViewName("worder");
		mav.addObject("worder" , worder);
		return mav;
	}
	
	
	
	/**
	 * 
	 * 
	 * @param worder
	 * @return
	 */
	@RequestMapping(value="/addWorder",method=RequestMethod.POST)
	public String addWorder(Worder worder) {
		worderService.addWorder(worder);
		return "redirect:addWorder";
	}
	
	
	/**
	 * 
	 * 
	 */
	@RequestMapping(value = "/updateWorder",method=RequestMethod.GET)
	public String updateWorder(Worder worder) {
		System.out.println(worder.toString());
		worderService.updataWorder(worder);
		return "redirect:updateWorder";
	}
	

	/**
	 * 
	 * 
	 */
	@RequestMapping(value = "/deleteWorder/{id}",method=RequestMethod.DELETE)
	public String deleteWorder(Worder id) {
		worderService.deleteWorder(id);
		return "redirect:deleteWorder";
		
	}
	
	
}