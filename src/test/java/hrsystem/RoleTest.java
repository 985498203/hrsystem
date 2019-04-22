package hrsystem;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.service.RoleService;

public class RoleTest extends BaseTest {

	private RoleService roleService;

	@Resource(name = "roleServiceImpl")
	public void setUserService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Test
	public void testAddUser() {
		Role role = new Role();
		role.setRoleName("人事");
		roleService.addRole(role);
		System.out.println("添加职位成功");
	}

	@Test
	public void findAllRole() {
		List<Role> roleList = roleService.finAllRole();
		for (Role role : roleList) {
			System.out.println("id:" + role.getRoleId() + ";" + "名：" + role.getRoleName());
		}
	}

	@Test
	public void updateRole() {
		Role role = roleService.getRoleById(4);
		role.setRoleName("HR");
		roleService.updateRole(role);
		System.out.println("更新职位成功");
	}

	@Test
	public void deleteRole() {
		Role role = roleService.getRoleById(4);
		roleService.deleteRole(role);
		System.out.println("删除角色成功");
	}

	@Test
	public void findRoleByUserId() {
		List<Role> findAllRoleByUserId = roleService.findAllRoleByUserId(16);
		for (Role role : findAllRoleByUserId) {
			System.out.println("id:" + role.getRoleId() + ";" + "名:" + role.getRoleName());
		}
		System.out.println("查询角色成功");
	}
	@Test
	public void findPermissionByRoleid() {
		List<Permission> findAllRoleByUserId = roleService.findAllPermissionByRoleId(1);
		for (Permission permission : findAllRoleByUserId) {
			System.out.println("id:" + permission.getPermId() + ";" + "名:" + permission.getPermName()+";URL："+permission.getUrl());
		}
		System.out.println("查询权限成功");
	}

}
