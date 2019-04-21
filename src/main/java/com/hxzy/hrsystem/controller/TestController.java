package com.hxzy.hrsystem.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.hrsystem.dao.RoleDao;
import com.hxzy.hrsystem.param.TestVo;
import com.hxzy.hrsystem.util.BeanValidator;

@Controller
public class TestController {
	public RoleDao roleDao;

	@Resource(name = "roleDaoImpl")
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public ModelAndView testRole(ModelAndView mav) {
		roleDao.findAllRoleByUserId(16);
		mav.setViewName("main");
		return mav;
	}

	@RequestMapping(value = "/testvo", method = RequestMethod.GET)
	public ModelAndView test(ModelAndView mav, TestVo vo) {

		try {
			Map<String, String> maps = BeanValidator.validateObject(vo);
			if (null != maps && maps.keySet().size() > 0) {
				for (Map.Entry<String, String> entry : maps.entrySet()) {
					System.out.println("KEY:" + entry.getKey() + "值：" + entry.getValue());
				}
			}
		} catch (Exception e) {
		}
		mav.setViewName("main");
		return mav;
	}
}
