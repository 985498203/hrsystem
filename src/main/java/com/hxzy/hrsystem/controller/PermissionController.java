package com.hxzy.hrsystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.service.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {

	private PermissionService permissionService;

	@RequestMapping("permissionServiceImpl")
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<Permission> permissionList(ModelAndView mav) {
		List<Permission> list = permissionService.findAllPermission();
		return list;
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ModelAndView permissionInfo(@PathVariable(name = "id", required = true) int id, ModelAndView mav) {
		mav.setViewName("userinfo");
		mav.addObject("user", permissionService.getPermissionById(id));
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ModelAndView delPermission(@PathVariable(name = "id", required = true) int id, ModelAndView mav) {
		mav.setViewName("redirect:/list");
		permissionService.deletePermissionById(id);
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addPermission(@ModelAttribute Permission permission, ModelAndView mav) {
		mav.setViewName("redirect:/list");
		permissionService.addPermission(permission);
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ModelAndView updatePermission(@ModelAttribute Permission permission, ModelAndView mav) {
		mav.setViewName("redirect:/list");
		permissionService.updatePermission(permission);
		return mav;
	}

}
