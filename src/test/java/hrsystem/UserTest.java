package hrsystem;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.junit.Test;

import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.entity.User;
import com.hxzy.hrsystem.service.RoleService;
import com.hxzy.hrsystem.service.UserService;

public class UserTest extends BaseTest {
	private UserService userService;
	private RoleService roleService;

	@Resource(name = "userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Resource(name = "roleServiceImpl")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setUsername("周一");
		user.setPassword("1234");
		userService.addUser(user);
		System.out.println("添加成功");
	}
	@Test
	public void testAddRole() {
	
		User user = userService.getUserById(59);
		Role role = roleService.getRoleById(1);
		Role role2 = roleService.getRoleById(2);
		Role role3 = roleService.getRoleById(3);
		List<Role> list = new ArrayList<Role>();
		list.add(role);
		list.add(role2);
		list.add(role3);
		userService.addRole(user, list);

		System.out.println("添加成功");
	}
	

	@Test
	public void findAllUser() {

		List<User> userList = userService.findAllUser();
		for (User user : userList) {
			System.out.println("姓名：" + user.getUsername());
		}
	}

	@Test
	public void updateUser() {
		User user = userService.getUserById(14);

		user.setUsername("li");
		user.setPassword("z");
		userService.updateUsre(user);
		System.out.println("更新成功");
	}

	@Test
	public void deleteUser() {
		User user = userService.getUserById(14);
		userService.deleteUser(user);
		System.out.println("删除成功");
	}
}
