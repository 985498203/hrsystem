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
		user.setUsername("张三");
		user.setPassword("李四");
		userService.addUser(user);
		System.out.println("添加成功");
	}
	@Test
	public void findAllUser() {
		
		List<User> userList = userService.finAllUser();
		for (User user : userList) {
			System.out.println("姓名："+user.getUsername());
		}
		
		System.out.println("添加成功");
	}
}
