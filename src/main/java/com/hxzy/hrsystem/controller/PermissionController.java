package com.hxzy.hrsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.hrsystem.dto.PermissionDTO;
import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.service.PermissionService;

@Controller
@RequestMapping("/perm")
public class PermissionController {

	private PermissionService permissionService;

	@Resource(name = "permissionServiceImpl")
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView getpermissions(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			ModelAndView mav) {
		List<Permission> prmlist = permissionService.findAllPermissionByIndex(pageNo, 5);
//		List<PermissionDTO> dtolist = new ArrayList<PermissionDTO>();
//		for (Permission permission : list) {
//			PermissionDTO dto = new PermissionDTO(permission.getPermId(),permission.getPermName(),permission.getUrl());
//			dtolist.add(dto);
//		}
		mav.addObject("prmlist", prmlist);
		mav.setViewName("admin/perm");

		return mav;
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
