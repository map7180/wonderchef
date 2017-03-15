package com.mk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mk.shoppingbackend.dao.AddressDAO;
import com.mk.shoppingbackend.dao.UserRegDAO;
import com.mk.shoppingbackend.dto.Address;

public class AddressTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static AddressDAO addressDAO;
	private static UserRegDAO userregDAO;
	private Address address;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mk.shoppingbackend");
		context.refresh();
		addressDAO = (AddressDAO) context.getBean("addressDAO");
		userregDAO=(UserRegDAO) context.getBean("userregDAO");
	}
	
	@Test
	public void testAddress()
	{
		address = new Address();
		address.setAddress1("Mumbai");
		address.setAddress2("snatacruz");
		address.setCity("Mumbai");
		address.setCode("448988");
		address.setUserreg(userregDAO.get(1));
		assertEquals("Successfully added in the table", true, addressDAO.add(address));
	}
	
}
