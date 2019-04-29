package com.hxzy.hrsystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.hrsystem.entity.PageInfo;
import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.service.RoleService;
import com.hxzy.hrsystem.util.JsonData;

@Controller
public class RoleController {

	private RoleService roleService;

	@RequestMapping("roleServiceImpl")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ModelAndView getPermissions(@RequestParam(value = "pn", defaultValue = "1") Integer pn, ModelAndView mav) {
		System.out.println("dssssssssssssssssssssssssssss");
		
		
		int zys = roleService.getTotalPages(5);// 得到总页数
		if (null != pn && !"".equals(pn)) {
			if (pn > zys) {// 如果传过来页数大于总页数，就显示最后一页
				pn = zys;
			} else if (pn <= 0) {// 如果传过来页数小于0，就显示第一页
				pn = 1;
			}
		}
		PageInfo pageInfo = roleService.getPageInfo(pn);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName("admin/role");
		return mav;
	}

	@RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
	@ResponseBody
	public JsonData roleInfo(@PathVariable(name = "id", required = true) int id) {
		System.out.println("id:" + id);
		Role role = roleService.getRoleById(id);
		return JsonData.success(role);
	}

	@RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public JsonData delRole(@PathVariable(name = "id", required = true) int id) {
		try {
			roleService.deleteRoleById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonData.fail();
		}
		return JsonData.success();
	}

	@RequestMapping(value = "/role", method = RequestMethod.POST)
	public ModelAndView addRole(@ModelAttribute Role role, ModelAndView mav) {
		mav.setViewName("redirect:/list");
		roleService.addRole(role);
		return mav;
	}

	@RequestMapping(value = "/role/{id}", method = RequestMethod.PUT)
	public ModelAndView updateRole(@PathVariable(name = "id", required = true) int id,@ModelAttribute Role role, ModelAndView mav) {
		mav.setViewName("redirect:/list");
		roleService.updateRole(role);
		return mav;
	}

}
