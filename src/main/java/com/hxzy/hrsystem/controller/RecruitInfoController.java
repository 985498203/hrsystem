package com.hxzy.hrsystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.hrsystem.entity.RecruitInfo;
import com.hxzy.hrsystem.service.RecruitInfoService;


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
	@RequestMapping(value="{recruitInfo}",method=RequestMethod.GET)
	public ModelAndView findRecruitInfoAll(ModelAndView mav, HttpServletRequest request) {
		System.out.println("1");
		List<RecruitInfo> recruitInfo = (List<RecruitInfo>) recruitInfoService.findRecruitInfoAll();
		mav.setViewName("recruitInfo");
		mav.addObject("recruitInfo" , recruitInfo);
		return mav;
	}
	
	
	/**
	 * 
	 * 
	 * @param worder
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> addWorder(RecruitInfo recruitInfo) {
		try {
			recruitInfoService.addRecruitInfo(recruitInfo);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		return "redirect:addRecruitInfo";
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	
	/**
	 * 
	 * 
	 */
	@RequestMapping(value = "/updateRecruitInfo",method=RequestMethod.GET)
	public String updateRecruitInfo(RecruitInfo recruitInfo) {
		System.out.println(recruitInfo.toString());
		recruitInfoService.updataRecruitInfo(recruitInfo);
		return "redirect:updateRecruitInfo";
	}
	

	/**
	 * 
	 * 
	 */
	@RequestMapping(value = "/deleteRecruitInfo",method=RequestMethod.DELETE)
	public String deleteWorder(RecruitInfo id) {
		recruitInfoService.deleteRecruitInfo(id);
		return "redirect:deleteRecruitInfo";
	}
}