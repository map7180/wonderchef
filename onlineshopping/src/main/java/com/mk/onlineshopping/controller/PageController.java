package com.mk.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mk.shoppingbackend.dao.CategoryDAO;
import com.mk.shoppingbackend.dao.ProductsDAO;
import com.mk.shoppingbackend.dto.Category;
import com.mk.shoppingbackend.dto.Products;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductsDAO productsDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		// passing list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Login");
		mv.addObject("userClickLogin", true);
		return mv;
	}
	/*
	 * @RequestMapping(value = "/register") public ModelAndView register() {
	 * ModelAndView mv = new ModelAndView("page"); mv.addObject("title",
	 * "Register"); mv.addObject("userClickRegister", true); return mv; }
	 */
	/*
	 * @RequestMapping(value = "/memberlogin") public ModelAndView memberlogin()
	 * { ModelAndView mv = new ModelAndView("page"); mv.addObject("title",
	 * "Member Login"); mv.addObject("userClickMemberLogin", true); return mv; }
	 */
	// display the login view
	/*
	 * @GetMapping("/login") public String login(@RequestParam(value = "error",
	 * required = false) String error, Model model) { if (error != null) {
	 * model.addAttribute("error",
	 * "Authentication Failed - Invalid credentials!"); }
	 * model.addAttribute("title", "login");
	 * model.addAttribute("userClickLogin", true); return "page"; }
	 * 
	 */ /*
		 * //this is admin part login ******************************************
		 * 
		 * @RequestMapping(value = "/admin") public ModelAndView admin() {
		 * ModelAndView mv = new ModelAndView("page"); mv.addObject("title",
		 * "Admin"); mv.addObject("userClickAdmin", true); return mv; }
		 */
	// *********************************************************************************

	/*
	 * methods to load the products and based on category
	 */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		// passing list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("products", productsDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to feth a single category
		Category category = null;
		category = categoryDAO.get(id);

		mv.addObject("title", category.getName());

		// passing list of categories
		mv.addObject("categories", categoryDAO.list());

		// passing single category list
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	/*
	 * For individual products
	 */

	@RequestMapping(value = "/show/{id}/products")
	public ModelAndView showSingleProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("singleproduct");
		Products products = null;
		products = productsDAO.get(id);
		mv.addObject("title", products.getPrdname());
		// passing the single product
		mv.addObject("products", products);
		mv.addObject("userClickedSingleProduct", true);
		return mv;
	}

	@RequestMapping(value = "/products")
	public ModelAndView userproducts() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@GetMapping("/allproducts")
	@ResponseBody
	public List<Products> allProducts() {

		return productsDAO.list();
	}

	@RequestMapping(value = "showproducts/{id}")
	public ModelAndView getProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("showproducts");
		mv.addObject("prd", productsDAO.getProduct(id));
		return mv;
	}
}
