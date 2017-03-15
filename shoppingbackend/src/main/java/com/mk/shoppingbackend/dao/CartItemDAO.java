package com.mk.shoppingbackend.dao;

import java.util.List;

import com.mk.shoppingbackend.dto.CartItem;

public interface CartItemDAO {
	
	CartItem get(int id);
	List<CartItem> list();
	boolean add(CartItem cartitem);
	//boolean update(CartItem cartItem);
	/*boolean delete(int id);	
	public CartItem getCartByUserId(int userId); 
	public CartItem getCartByUserIdAndProduct(int userId, int productId); */

	boolean update(CartItem cartItem);
	void delete(int id);
	
}
