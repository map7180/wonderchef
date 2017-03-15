package com.mk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mk.shoppingbackend.dao.CartDAO;
import com.mk.shoppingbackend.dao.UserRegDAO;
import com.mk.shoppingbackend.dto.Cart;

public class CartTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CartDAO cartDAO;
	private static UserRegDAO userregDAO;
	private Cart cart;


	
	@BeforeClass
	public static void inti() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mk");
		context.refresh();
		cartDAO = (CartDAO) context.getBean("cartDAO");
		userregDAO=(UserRegDAO) context.getBean("userregDAO");
	}

	@Test
	public void testCart() {
		cart = new Cart();
		cart.setTotalitems(1);
//		cart.setTotalvalueofitems(100);
		cart.setUser(userregDAO.get(1));
		cart.setGrandTotal(1000);
	assertEquals("Successfully added in the table", true, cartDAO.add(cart));
	}

}
