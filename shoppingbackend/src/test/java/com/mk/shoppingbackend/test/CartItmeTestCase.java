package com.mk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mk.shoppingbackend.dao.CartDAO;
import com.mk.shoppingbackend.dao.CartItemDAO;
import com.mk.shoppingbackend.dao.ProductsDAO;
import com.mk.shoppingbackend.dao.UserRegDAO;
import com.mk.shoppingbackend.dto.Cart;
import com.mk.shoppingbackend.dto.CartItem;
import com.mk.shoppingbackend.dto.Products;
import com.mk.shoppingbackend.dto.UserReg;

public class CartItmeTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CartItemDAO cartItemDAO;
	private static UserRegDAO userregDAO;
	private static CartDAO cartDAO;
	private static ProductsDAO productsDAO;

	
	@BeforeClass
	public static void inti() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.mk.shoppingbackend");
		context.refresh();
		cartItemDAO = (CartItemDAO) context.getBean("cartItemDAO");
		cartDAO = (CartDAO) context.getBean("cartDAO");
		productsDAO = (ProductsDAO) context.getBean("productsDAO");
		userregDAO = (UserRegDAO) context.getBean("userregDAO");
	}
	
	
	@Test
	public void testAddCartItem() {

		// get the user
		UserReg user = userregDAO.get(1); 
		Cart cart = user.getCart();
		Products product = productsDAO.getProduct(1);

		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItem.setQuantity(5);
		cartItem.setTotalPrice(product.getPrdprice() * cartItem.getQuantity());

		cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotalPrice());
		cart.setTotalitems(cart.getTotalitems() + 1);
		assertEquals("Successfully added the cart item!", true, cartItemDAO.add(cartItem));

	}


	
	

/*	@Test
	public void testAddCartItem() {

		// get the user
		UserReg userreg = userregDAO.get(1);
		// get the cart
		Cart cart = userreg.getCart();

		// get the product
		Products products = productsDAO.get(1);

		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProduct(products);
		cartItem.setQuantity(2);
		cartItem.setTotalprice(products.getPrdprice() * cartItem.getQuantity());

		cart.setTotalvalueofitems(cart.getTotalvalueofitems() + cartItem.getTotalprice());
		cart.setTotalvalueofitems(cart.getTotalvalueofitems()+1);
		assertEquals("Successfully added the cart item!", true, cartItemDAO.add(cartItem));

	}

*/	
	/*@Test
	public void testDeleteCartTtem() {
		// get the user
		UserRegDAO userreg = userregDAO.get(1);
		// get the cart
		Cart cart = userreg.getCart();

		// get the product
		Products products = productsDAO.get(1);

		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProduct(products);
		cartItem.setQuantity(2);
		cartItem.setTotalprice(products.getPrdprice() * cartItem.getQuantity());

		cart.setTotalvalueofitems(cart.getTotalvalueofitems() + cartItem.getTotalprice());
		cart.setTotalvalueofitems(cart.getTotalvalueofitems()+1);
		assertEquals("Successfully added the cart item!", true, cartItemDAO.add(cartItem));

		}

*/		
}
