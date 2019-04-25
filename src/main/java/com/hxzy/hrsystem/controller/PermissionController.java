package com.hxzy.hrsystem.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.hrsystem.entity.PageInfo;
import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.service.PermissionService;

@Controller
public class PermissionController {

	private PermissionService permissionService;

	@Resource(name = "permissionServiceImpl")
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@RequestMapping(value = "/perms", method = RequestMethod.GET)
	public ModelAndView getpermissions(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			ModelAndView mav) {
		System.out.println("进来");
		PageInfo pageInfo = permissionService.getPageInfo(pn);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName("admin/perm");
		return mav;
	}
	@RequestMapping(value = "/perm/{id}", method = RequestMethod.GET)
	public ModelAndView permissionInfo(@PathVariable(name = "id", required = true) int id, ModelAndView mav) {
		mav.setViewName("userinfo");
		mav.addObject("user", permissionService.getPermissionById(id));
		return mav;
	}
	@RequestMapping(value = "/perm/{id}", method = RequestMethod.DELETE)
	public ModelAndView delPermission(@PathVariable(name = "id", required = true) int id, ModelAndView mav) {
		mav.setViewName("redirect:/list");
		permissionService.deletePermissionById(id);
		return mav;
	}

	@RequestMapping(value = "/perms", method = RequestMethod.POST)
	public ModelAndView addPermission(@ModelAttribute Permission permission, ModelAndView mav) {
		mav.setViewName("redirect:/list");
		permissionService.addPermission(permission);
		return mav;
	}

	@RequestMapping(value = "/perms{id}", method = RequestMethod.PUT)
	public ModelAndView updatePermission(@ModelAttribute Permission permission, ModelAndView mav) {
		mav.setViewName("redirect:/list");
		permissionService.updatePermission(permission);
		return mav;
	}

}
