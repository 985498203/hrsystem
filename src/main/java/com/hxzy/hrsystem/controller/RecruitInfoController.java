package com.hxzy.hrsystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.hrsystem.entity.RecruitInfo;
import com.hxzy.hrsystem.service.RecruitInfoService;
import com.hxzy.hrsystem.util.JsonData;


@Controller
public class RecruitInfoController {
	private RecruitInfoService recruitInfoService;
	
	@Resource(name="recruitInfoServiceImpl")
	public void setWorderService(RecruitInfoService recruitInfoService) {
		this.recruitInfoService=recruitInfoService;
	}
	/**
	 * 
	 * 查询所有
	 * 
	 * @param mav
	 * @param request
	 * @return
	 */
	@RequestMapping(value="recruitInfo",method=RequestMethod.GET)
	public ModelAndView findRecruitInfoAll(ModelAndView mav, HttpServletRequest request) {
		System.out.println("1");
		List<RecruitInfo> recruitInfo = (List<RecruitInfo>) recruitInfoService.findRecruitInfoAll();
		for (RecruitInfo recruitInfo2 : recruitInfo) {
			System.out.println(recruitInfo2);
		}
		
		mav.setViewName("recruitInfo/recruitInfo");
		mav.addObject("recruitInfo" , recruitInfo);
		return mav;
	}
	/**
	 * 
	 * 添加
	 * @param worder
	 * @return
	 */
	@RequestMapping(value="recruitInfo", method=RequestMethod.POST)
	public @ResponseBody JsonData addWorder(RecruitInfo recruitInfo) {
		try {
			recruitInfoService.addRecruitInfo(recruitInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return  JsonData.fail();
		}
		return  JsonData.success();
		
		
//		try {
//			recruitInfoService.addRecruitInfo(recruitInfo);
//			return ResponseEntity.status(HttpStatus.CREATED).build();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
////		return "redirect:addRecruitInfo";
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	
	/**
	 * 
	 * 
	 */
	@RequestMapping(value = "/recruitInfo/{id}",method = RequestMethod.PUT)
	@ResponseBody
	public JsonData updateRecruitInfo(RecruitInfo recruitInfo) {
		try {
			recruitInfoService.updataRecruitInfo(recruitInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return  JsonData.fail();
		}
		return  JsonData.success();
	}

	/**
	 * 
	 * 
	 */
	@RequestMapping(value = "/recruitinfo/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public JsonData deleteWorder(@PathVariable(name = "id", required = true) int id) {
		try {
			System.out.println("id:"+id);
			recruitInfoService.deleteRecruitInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonData.fail();
		}
		return JsonData.success();
	}
}