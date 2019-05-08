package com.hxzy.hrsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.entity.User;
import com.hxzy.hrsystem.service.PermissionService;
import com.hxzy.hrsystem.service.RoleService;
import com.hxzy.hrsystem.service.UserService;

@Controller
public class HelloController {
	public RoleService roleService;
	public PermissionService permissionService;
	public UserService userService;
	
	@Resource(name="userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Resource(name="roleServiceImpl")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	@Resource(name="permissionServiceImpl")
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView Login(ModelAndView mav) {
		System.out.println("主页");
		
		//得到当前登录用户的信息
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();//拿到UserDetailsService对象
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping(value = "/a", method = RequestMethod.GET)
	public ModelAndView Logina(ModelAndView mav) {
		System.out.println("主页");
		mav.setViewName("a");
		return mav;
	}
	@RequestMapping(value="/install",method = RequestMethod.GET)
	public void install() {
		//初始化数据
		//角色表数据
		Role role = new Role("ROLE_ADMIN","管理员");
		Role role2 = new Role("ROLE_HR","人事");
		Role role3 = new Role("ROLE_USER","普通用户");
		roleService.addRole(role);
		roleService.addRole(role2);
		roleService.addRole(role3);
		//用户表数据
		User user = new User("admin","admin","张三",21,1,"198547881546","985748@qq.com",1);
		User user2 = new User("hr","hr","李四",20,2,"178948446","978458@qq.com",1);
		User user3 = new User("user","user","小吴",18,2,"12345678","5566488@qq.com",1);
		User user4 = new User("u1","u1","小花",19,2,"18745164588","778452@qq.com",1);
		
		userService.addUser(user);
		userService.addUser(user2);
		userService.addUser(user3);
		userService.addUser(user4);
		
		
		List<Permission> permissions = new ArrayList<Permission>();
		
		//权限表数据
		Permission  permission = new Permission("用户管理","/admin/users",null);
		Permission  permission2 = new Permission("权限管理","/admin/perms",null);
		Permission  permission3 = new Permission("角色管理","/admin/roles",null);
		Permission  permission4 = new Permission("首页","/index",null);
		
		Permission  permission5 = new Permission("添加用户","/admin/adduser",permission);
		Permission  permission6 = new Permission("删除用户","/admin/deleteuser",permission);
		Permission  permission7 = new Permission("修改用户","/admin/updateuser",permission);
		
		Permission  permission8 = new Permission("添加权限","/admin/addperm",permission2);
		Permission  permission9 = new Permission("删除权限","/admin/deleteperm",permission2);
		Permission  permission10 = new Permission("修改权限","/admin/updateperm",permission2);
		
		Permission  permission11 = new Permission("添加角色","/admin/addrole",permission3);
		Permission  permission12 = new Permission("删除角色","/admin/deleterole",permission3);
		Permission  permission13 = new Permission("修改角色","/admin/updaterole",permission3);

		permissions.add(permission4);
		permissions.add(permission5);
		permissions.add(permission6);
		permissions.add(permission7);
		permissions.add(permission8);
		permissions.add(permission9);
		permissions.add(permission10);
		permissions.add(permission11);
		permissions.add(permission12);
		permissions.add(permission13);
		
		
		permissionService.addAll(permissions);
		
		//给用户添加角色
		userService.addRoleById(1,1);
		userService.addRoleById(1,2);
		userService.addRoleById(1,3);
		userService.addRoleById(2,2);
		userService.addRoleById(3,3);
		userService.addRoleById(4,3);
		
		//给角色添加权限
		List<Integer> permIdList=new ArrayList<Integer>();
		permIdList.add(1);
		permIdList.add(3);
		permIdList.add(7);
		permIdList.add(11);
		Integer[] ids= {1,3,7,11};
		
		roleService.addPermAllById(1, ids);
		roleService.addPermById(2, 1);
		roleService.addPermById(2, 3);
		roleService.addPermById(3, 1);
		
	}
	
	
	
}
