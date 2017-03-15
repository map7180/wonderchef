package com.mk.shoppingbackend.dao;

import java.util.List;

import com.mk.shoppingbackend.dto.Category;

public interface CategoryDAO {

	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);

	void delete(int id);
	
}
