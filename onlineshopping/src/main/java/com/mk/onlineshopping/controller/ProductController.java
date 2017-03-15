package com.mk.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mk.shoppingbackend.dao.CategoryDAO;
import com.mk.shoppingbackend.dao.ProductsDAO;
import com.mk.shoppingbackend.dto.Category;
import com.mk.shoppingbackend.dto.Products;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductsDAO productsDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	HttpServletRequest request;

	@RequestMapping(method = RequestMethod.GET)
	public String newProduct(ModelMap model) {
		Products products = new Products();
		Category category = new Category();
		model.addAttribute("products", products);

		model.addAttribute("userClickProducts", true);

		return "page";
	}

	@GetMapping("/allproducts")
	@ResponseBody
	public List<Products> allproducts() {

		return productsDAO.list();
	}

	/*
	 * @RequestMapping(value = "/allproduct") public ModelAndView showproducts()
	 * { ModelAndView mv = new ModelAndView("page"); mv.addObject("title",
	 * "Product"); mv.addObject("userClickProduct", true); return mv; }
	 */

	/*
	 * @RequestMapping("product/{id}") public Product
	 * getProduct(@PathVariable("id") int id) { return
	 * productdao.getProduct(id); }
	 */
	

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		productsDAO.delete(id);
		return "redirect:/allproducts";
	}

	@RequestMapping(value = "/showproduct/{id}")
	public ModelAndView getProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("showproduct");
		mv.addObject("prd", productsDAO.getProduct(id));
		return mv;
	}

}
