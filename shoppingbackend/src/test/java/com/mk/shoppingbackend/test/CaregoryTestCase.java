package com.mk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mk.shoppingbackend.dao.CategoryDAO;
import com.mk.shoppingbackend.dto.Category;

public class CaregoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void inti() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mk");	
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	public void testAddCategory() {
		category = new Category();

		category.setName("Hot Set");
		category.setImgURL("hs1.jpg");

		/*category = new Category();

		category.setName("Western Wear");
		category.setDescription("This is western wear category");
		category.setImageUrl("image2.jpg");*/
		assertEquals("Successfully added a category inside a table", true, categoryDAO.add(category));

	}

	
	/*@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("hotsets");
		category.setImgURL("hs1.jpg");
		assertEquals("Successfully inserted the table", true, categoryDAO.add(category));
	}
	
	
	 * @Test
	public void testGetCategory()
	{
		category= categoryDAO.get(3);
		assertEquals("Successfully featched a single category from the table", "Appliances", category.getName());
	}
	
	@Test
	public void testUpdateCategory()
	{
		category= categoryDAO.get(3);
		category.setName("App");
		assertEquals("Successfully updated a single category from the table", true, categoryDAO.update(category));
	}
	
	@Test
	public void testDeleteCategory()
	{
		category= categoryDAO.get(3);
		assertEquals("Successfully updated a single category from the table", true, categoryDAO.delete(category));
	}
	
	
	@Test
	public void testListCategory()
	{
		
		assertEquals("Successfully featched list of category from the table",3, categoryDAO.list());
		
	}
	*/
	
	//@Test
	//public void testCRUDCategory(){
		
		//add operation
		/*category = new Category();
		category.setName("hotsets");
		category.setImgURL("hs1.jpg");
		assertEquals("Successfully inserted the table", true, categoryDAO.add(category));
		
		
		category = new Category();
		category.setName("Appliances");
		category.setImgURL("hs2.jpg");
		assertEquals("Successfully inserted the table", true, categoryDAO.add(category));
		
		//fetching and updating the category
		category= categoryDAO.get(2);
		category.setName("App");
		assertEquals("Successfully updated a single category from the table", true, categoryDAO.update(category));
*/		
		
		//delete the category 
	//	assertEquals("Successfully updated a single category from the table", true, categoryDAO.delete(1));
		
		//fetching list
		//assertEquals("Successfully featched list of category from the table",1, categoryDAO.list().size());
	//}
} 