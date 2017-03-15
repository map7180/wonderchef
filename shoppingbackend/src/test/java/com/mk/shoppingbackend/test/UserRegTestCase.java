package com.mk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mk.shoppingbackend.dao.UserRegDAO;
import com.mk.shoppingbackend.dto.UserReg;

public class UserRegTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserRegDAO userRegDAO;
	private UserReg userreg;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mk");
		context.refresh();
		userRegDAO = (UserRegDAO) context.getBean("userRegDAO");
	}

	@Test
	public void testAddUserReg() {
		userreg = new UserReg();
		userreg.setName("madhavi");
		userreg.setEmid("map7180@gmail.com");
		userreg.setRole("Admin");
		userreg.setUsername("mk");
		userreg.setPwd("bk");
		assertEquals("Successfully inserted the table", true, userRegDAO.add(userreg));
	
	}
}