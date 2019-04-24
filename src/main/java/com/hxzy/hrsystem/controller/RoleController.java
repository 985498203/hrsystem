package com.hxzy.hrsystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	private RoleService roleService;

	@RequestMapping("roleServiceImpl")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<Role> roleList(ModelAndView mav) {
		List<Role> list = roleService.findAllRole();
		return list;
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ModelAndView roleInfo(@PathVariable(name = "id", required = true) int id, ModelAndView mav) {
		mav.setViewName("userinfo");
		mav.addObject("user", roleService.getRoleById(id));
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ModelAndView delRole(@PathVariable(name = "id", required = true) int id, ModelAndView mav) {
		mav.setViewName("redirect:/list");
		roleService.deleteRoleById(id);
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addRole(@ModelAttribute Role role, ModelAndView mav) {
		mav.setViewName("redirect:/list");
		roleService.addRole(role);
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ModelAndView updateRole(@ModelAttribute Role role, ModelAndView mav) {
		mav.setViewName("redirect:/list");
		roleService.updateRole(role);
		return mav;
	}

}
