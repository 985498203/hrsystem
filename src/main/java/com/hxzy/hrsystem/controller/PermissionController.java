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

import com.hxzy.hrsystem.entity.NodeTree;
import com.hxzy.hrsystem.entity.PageInfo;
import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.param.PermissionParam;
import com.hxzy.hrsystem.service.PermissionService;
import com.hxzy.hrsystem.service.RoleService;
import com.hxzy.hrsystem.util.JsonData;

@Controller
public class PermissionController {

	private PermissionService permissionService;
	private RoleService roleService;

	@Resource(name = "permissionServiceImpl")
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@Resource(name = "roleServiceImpl")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
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
	@ResponseBody
	public JsonData permissionInfo(@PathVariable(name = "id", required = true) int id) {
		System.out.println("id:" + id);
		Permission permission = permissionService.getPermissionById(id);
		return JsonData.success(permission);
	}

	@RequestMapping(value = "/perm/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public JsonData deletePermission(@PathVariable(name = "id", required = true) int id) {
		try {
			permissionService.deletePermissionById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonData.fail();
		}
		return JsonData.success();
	}

	@RequestMapping(value = "/perm", method = RequestMethod.POST)
	@ResponseBody
	public JsonData addPermission(@Valid Permission permission, BindingResult result) {
		if (result.hasErrors()) {
			// 校验失败，返回失败信息，在模态框中显示校验错误信息
			Map<String, Object> errorMap = new HashMap<>();
			List<FieldError> fieldErrors = result.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return JsonData.fail().add("errorInfo", errorMap);
		}
//		if (parentId > -1 && null != parentId) {

//			Permission permission2 = permissionService.getPermissionById(parentId);
//			if (null != permission2) {
//				permission.setParent(permission2);
//			} else {
//				return JsonData.fail();// 父id不存在
//			}
//		}
		permissionService.addPermission(permission);// 添加数据
		int zys = permissionService.getTotalPages(5);// 得到总页数
		return JsonData.success(zys);// 返回处理结果

	}

	@RequestMapping(value = "/perm/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public JsonData updatePermission(@ModelAttribute Permission permission) {
		if (null != permission.getPermId()) {
			Permission permission2 = permissionService.getPermissionById(permission.getPermId());
			permission2.setPermName(permission.getPermName());
			permission2.setUrl(permission.getUrl());
			permissionService.updatePermission(permission2);
			return JsonData.success();
		}
		return JsonData.fail();
	}

	/**
	 * 获取所有的顶级权限
	 * 
	 * @return
	 */
	@RequestMapping(value = "/superperm", method = RequestMethod.GET)
	public @ResponseBody JsonData getSuperPerm() {
		List<Permission> list = permissionService.getAllRootPermission();
		if (null == list) {
			return JsonData.fail("没有顶级权限");
		} else {
			List<PermissionParam> paramList = new ArrayList<PermissionParam>();
			for (Permission permission : list) {
				PermissionParam parem = new PermissionParam(permission.getPermId(), permission.getPermName(),
						permission.getUrl(), null == permission.getParent() ? 0 : permission.getParent().getPermId(),
						true);// 简化参数
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

	@RequestMapping(value = "empower", method = RequestMethod.GET)
	public ModelAndView tograntperm(ModelAndView mav) {
		// 查询角色信息
		mav.setViewName("empower");// 跳转至授权页面
		return mav;
	}

	/**
	 * 加载顶级权限节点
	 * 
	 * @return
	 */
	@RequestMapping(value = "permtree", method = RequestMethod.POST)
	@ResponseBody
	private Object getRootPerm() {
		List<NodeTree> list = permissionService.getNodeTree();
//		List<Permission> rootPerm = permissionService.getAllRootPermission();
//		
//		for (Permission permission : rootPerm) {
//			List<Permission> childrenPerm = permissionService.getAllPermissionByPid(permission.getPermId());//通过父id查询子权限
//			Set<Permission> childrenPerms  = new HashSet<Permission>(childrenPerm);//List转Set
//			permission.setChildren(childrenPerms);//设置
//			rootPerm.add(permission);
//		}
		return list;
	}

	@RequestMapping(value = "permtrees", method = RequestMethod.GET)
	@ResponseBody
	public List<PermissionParam> getPermTree() {
		List<Permission> perms = permissionService.findAllPermission();
		List<PermissionParam> perms2 = new ArrayList<PermissionParam>();
		for (Permission permission : perms) {
			PermissionParam permissionParam = new PermissionParam(permission.getPermId(), permission.getPermName(),
					permission.getUrl(), permission.getParent() == null ? 0 : permission.getParent().getPermId(), true);
			perms2.add(permissionParam);
		}
		return perms2;
	}

	@RequestMapping(value = "assignperm/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonData doAssignPerm(@PathVariable(name = "id", required = true) Integer roleId, Integer[] permIds) {
		try {
			roleService.doAssignPerm(roleId, permIds);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonData.fail();
		}
		return JsonData.success();
	}
	@RequestMapping(value = "loadassigndata/{id}", method = RequestMethod.GET)
	@ResponseBody
	public JsonData loadAssignData(@PathVariable(name = "id", required = true) Integer roleId) {
		List<Permission> roles= null;
		List<Integer> permIds = null;
		List<PermissionParam> perms2 = new ArrayList<PermissionParam>();//简化的权限信息
		try {
			List<Permission> perms = permissionService.findAllPermission();//得到所有的权限信息
			roles= roleService.findAllPermissionByRoleId(roleId);//得到当前的角色所有的权限
			permIds = new ArrayList<Integer>();//当前的角色所有的权限ID
			
			for (int i=0;i<roles.size();i++) {
				Permission permission = roles.get(i);
				permIds.add(permission.getPermId());//从权限中得到所有的权限ID
			}
			
			for (Permission permission : perms) {
				PermissionParam permissionParam = new PermissionParam(permission.getPermId(), permission.getPermName(),
						permission.getUrl(), permission.getParent() == null ? 0 : permission.getParent().getPermId(), true);
				if(permIds.contains(permission.getPermId())) {
					permissionParam.setChecked(true);
				}else {
					permissionParam.setChecked(false);
				}
				perms2.add(permissionParam);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonData.fail();
		}
		return JsonData.success(perms2);
	}
	

}
