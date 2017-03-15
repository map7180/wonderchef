package com.mk.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.shoppingbackend.dao.CategoryDAO;
import com.mk.shoppingbackend.dto.Category;
@Controller
public class DataController {


	@Autowired
	private CategoryDAO categoryDAO;
	
	
	// accessing categories list
	@GetMapping(value = { "/all/category" })
	public @ResponseBody List<Category> showAll() {
		return categoryDAO.list();
	}
}
