package hrsystem;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import com.hxzy.hrsystem.entity.User;
import com.hxzy.hrsystem.service.UserService;

public class UserTest extends BaseTest {
	private UserService userService;

	@Resource(name = "userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Test
	public void addUser() {
		User user = new User();
		user.setUsername("aa");
		user.setPassword("王五");
		userService.addUser(user);
		System.out.println("添加成功");
	}

	@Test
	public void findAllUser() {

		List<User> userList = userService.finAllUser();
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
