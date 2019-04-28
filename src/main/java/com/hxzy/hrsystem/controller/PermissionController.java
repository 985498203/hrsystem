package com.hxzy.hrsystem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.hrsystem.entity.PageInfo;
import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.param.PermissionParam;
import com.hxzy.hrsystem.service.PermissionService;
import com.hxzy.hrsystem.util.JsonData;

@Controller
public class PermissionController {

	private PermissionService permissionService;

	@Resource(name = "permissionServiceImpl")
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@RequestMapping(value = "/perms", method = RequestMethod.GET)
	public ModelAndView getPermissions(@RequestParam(value = "pn", defaultValue = "1") Integer pn, ModelAndView mav) {
		int zys = permissionService.getTotalPages(5);// 得到总页数
		if (null != pn && !"".equals(pn)) {
			if (pn > zys) {// 如果传过来页数大于总页数，就显示最后一页
				pn = zys;
			} else if (pn <= 0) {// 如果传过来页数小于0，就显示第一页
				pn = 1;
			}
		}
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

	@RequestMapping(value = "/perm", method = RequestMethod.POST)
	@ResponseBody
	public JsonData addPermission(@RequestParam("parentId") Integer parentId, @Valid Permission permission,
			BindingResult result) {
		if (parentId != 0 && null != parentId) {
			if (result.hasErrors()) {
				// 校验失败，返回失败信息，在模态框中显示校验错误信息
				Map<String, Object> errorMap = new HashMap<>();
				List<FieldError> fieldErrors = result.getFieldErrors();
				for (FieldError fieldError : fieldErrors) {
					System.out.println("错误的字段：" + fieldError.getField());
					System.out.println("错误的信息：" + fieldError.getDefaultMessage());
					errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
				}
				return JsonData.fail("fdsafsdafsda").add("errorInfo", errorMap);
			}
			Permission permission2 = permissionService.getPermissionById(parentId);
			if (null != permission2) {
				permission.setParent(permission2);
			}
		}
		permissionService.addPermission(permission);// 添加数据
		int zys = permissionService.getTotalPages(5);// 得到总页数
		return JsonData.success(zys);// 返回处理结果
	}

	@RequestMapping(value = "/perms{id}", method = RequestMethod.PUT)
	public ModelAndView updatePermission(@ModelAttribute Permission permission, ModelAndView mav) {
		mav.setViewName("redirect:/list");
		permissionService.updatePermission(permission);
		return mav;
	}

	/**
	 * 获取所有的顶级权限
	 * 
	 * @return
	 */
	@RequestMapping(value = "/superperm", method = RequestMethod.GET)
	public @ResponseBody JsonData getSuperPerm() {
		List<Permission> list = permissionService.findAllSuperPermission();
		if (null == list) {
			return JsonData.fail("没有顶级权限");
		} else {
			List<PermissionParam> paramList = new ArrayList<PermissionParam>();
			for (Permission permission : list) {
				PermissionParam parem = new PermissionParam(permission.getPermId(), permission.getPermName(),
						permission.getUrl(), null == permission.getParent() ? 0 : permission.getParent().getPermId());// 简化参数
				paramList.add(parem);
			}
			return JsonData.success(paramList);
		}
	}

	/**
	 * 检查权限名是否重复
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/checkpermname")
	public @ResponseBody JsonData checkPermName(@RequestParam("permName") String permName) {
		String regex = "(^[a-zA-Z0-9_-]{2,50}$)|(^[\\u2E80-\\u9FFF]{2,20}$)";
		if (!permName.matches(regex)) {
			return JsonData.fail("权限名必须为2~20汉字或者2~50数字字母的组合");
		} else {
			if (permissionService.checkPermName(permName)) {
				return JsonData.successSendMsg("权限名可用");
			} else {
				return JsonData.fail("权限名不可用");
			}
		}
	}

	/**
	 * 检查url是否重复
	 * 
	 * @param url
	 * @return
	 */
	@RequestMapping("/checkpermurl")
	public @ResponseBody JsonData checkPermUrl(@RequestParam("url") String url) {

		String regex = "^[^\\u4e00-\\u9fa5]+$";
		if (!url.matches(regex) || url.length() < 2) {
			return JsonData.fail("URL不能包含汉字且长度必须大于1");
		} else {
			if (permissionService.checkPermUrl(url)) {
				return JsonData.successSendMsg("URL可用");
			} else {
				return JsonData.fail("URL不可用");
			}
		}
	}

}
