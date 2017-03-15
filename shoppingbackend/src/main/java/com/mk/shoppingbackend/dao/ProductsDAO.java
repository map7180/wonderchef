package com.mk.shoppingbackend.dao;

import java.util.List;

import com.mk.shoppingbackend.dto.Products;

public interface ProductsDAO {
	
	Products get(int id);
	List<Products> list();
	boolean add(Products products);
	boolean update(Products products);

	void delete(int id);

	Products getProduct(int id);
} 
