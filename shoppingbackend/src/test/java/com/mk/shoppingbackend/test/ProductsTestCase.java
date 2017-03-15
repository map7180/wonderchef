package com.mk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mk.shoppingbackend.dao.CategoryDAO;
import com.mk.shoppingbackend.dao.ProductsDAO;
import com.mk.shoppingbackend.dto.Products;
public class ProductsTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductsDAO productsDAO;
	private static CategoryDAO categoryDAO;
	private Products products;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mk");
		context.refresh();
		productsDAO=(ProductsDAO) context.getBean("productsDAO");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}
	
	@Test
	public void testAddProducts() {
		products = new Products();
		products.setPrdname("Granite Set");
		products.setPrdprice(1000);
		products.setPrdsize("100 x 100");
		products.setPrddisc("Wonderchef 4 Pc Blueberry WF");
		products.setPrdimgURL("hs2.jpg");
		products.setCategoryid(2);
		products.setCategory(categoryDAO.get(1));
		assertEquals("Successfully added a user inside a table", true, productsDAO.add(products));
	}
}
