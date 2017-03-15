package com.mk.shoppingbackend.dao;

import java.util.List;

import com.mk.shoppingbackend.dto.Cart;

public interface CartDAO {

	Cart get(int id);
	List<Cart> list();
	boolean add(Cart cart);
	boolean update(Cart cart);
	//boolean delete(int id);	
	void delete(int id);
	//public Cart getCartByUserId(int userId); 

}
