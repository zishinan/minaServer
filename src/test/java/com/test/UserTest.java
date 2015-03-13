package com.test;

import org.junit.Test;

import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class UserTest {
	@Test
	public void testAdd() throws Exception {
		User user = new User();
		user.setClazz(1);
		user.setGreate(1);
		user.setName("yangxi");
		user.setPassword("yangxi");
		user.setSchNum("2015020202");
		user.setType(1);
		UserService service = new UserServiceImpl();
		service.add(user);
	}
}
