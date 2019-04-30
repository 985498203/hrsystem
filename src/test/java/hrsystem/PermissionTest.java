package hrsystem;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.hxzy.hrsystem.dao.PermissionDao;
import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.service.PermissionService;
import com.hxzy.hrsystem.service.RoleService;

public class PermissionTest extends BaseTest {

	private PermissionService permissionService;
	@Resource(name="permissionServiceImpl")
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	// @Test
//	public void testAddUser() {
//		Role role = new Role();
//		role.setRoleName("人事");
//		roleService.addRole(role);
//		System.out.println("添加职位成功");
//	}
//
	@Test
	public void findAllTest() {
		List<Permission> list = permissionService.findAllPermission();
		for (Permission permission : list) {
			System.out.println("id:" + permission.getUrl());
			
			
			
		}
	}

//	@Test
//	public void update() {
//		Role role = roleService.getRoleById(4);
//		role.setRoleName("HR");
//		roleService.updateRole(role);
//		System.out.println("更新职位成功");
//	}
//
//	@Test
//	public void delete() {
//		Role role = roleService.getRoleById(4);
//		roleService.deleteRole(role);
//		System.out.println("删除角色成功");
//	}
//
//
//	@Test
//	public void findPermissionByRoleid() {
//		List<Permission> findAllRoleByUserId = roleService.findAllPermissionByRoleId(1);
//		for (Permission permission : findAllRoleByUserId) {
//			System.out.println("id:" + permission.getPermId() + ";" + "名:" + permission.getPermName()+";URL："+permission.getUrl());
//		}
//		System.out.println("查询权限成功");
//	}

}
