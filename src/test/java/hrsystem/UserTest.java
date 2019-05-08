package hrsystem;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hxzy.hrsystem.entity.User;
import com.hxzy.hrsystem.service.UserService;

public class UserTest extends BaseTest {
	
	private UserService userService;
	@Resource(name="userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Test
	public void updateUser() {
		User user = userService.getUserByName("u3");
		//哈希算法+盐
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode("123"));
		userService.updateUsre(user);
		
	}
	
}
