package com.mk.onlineshopping.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mk.shoppingbackend.dao.CategoryDAO;
import com.mk.shoppingbackend.dao.ProductsDAO;
import com.mk.shoppingbackend.dto.Category;
import com.mk.shoppingbackend.dto.Products;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	ProductsDAO productsDAO;

	@Autowired
	HttpServletRequest request;

	private Object products;
	// To get the category
	@GetMapping(value ="/listProducts")
	public ModelAndView listProduct() {
		ModelAndView mv = new ModelAndView("/listProduct");
		mv.addObject("products", this.categoryDAO.getClass());
		mv.addObject("userClickAdmin", true);
		return mv;
	}
	// will called it on path -> admin
	@RequestMapping(method = RequestMethod.GET)
	public String newCategory(ModelMap model) {
		Category category = new Category();
		model.addAttribute("category", category);
		model.addAttribute("userClickAdmin", true);
		return "page";

	}

	// accessing categories list
	@GetMapping(value = { "/all/category" })
	@ResponseBody
	public List<Category> showAll() {
		return categoryDAO.list();
	}

	// Adding new category
	// @PostMapping("/add/category")
	@RequestMapping(value = "/save/category", method = RequestMethod.POST)
	public String saveCategory(@Valid Category category, BindingResult result, ModelMap model) {
		try {
			System.out.println("inside save");
			if (result.hasErrors()) {
				model.addAttribute("category", category);
				model.addAttribute("userClickAdmin", true);
				return "page";
			} else{
				if (category.getId() == 0) {
					System.out.println("add category inserted");

					// Creating full directory string where we need to save
					// categories images.
					String realPathToUploads = request.getServletContext().getRealPath("/assets/images/");

					// Creating file object for the location given above
					File folderToUpload = new File(realPathToUploads);

					// check if the directory does not exist then create it
					if (!folderToUpload.exists()) {
						folderToUpload.mkdirs();
					}

					MultipartFile file = category.getFile();

					// creating the file name i.e. categoryname.jpg
					String fileToUpload = realPathToUploads + category.getName() + ".jpg";

					File destination = new File(fileToUpload);

					System.out.println("Entire file path is " + destination.toString());

					// Finally transferring multipart data to destination
					// created
					// above
					System.out.println(destination);
					file.transferTo(destination);

					// set the imageurl field of category model
					category.setImgURL(destination.getName());

					if (categoryDAO.add(category)) {
						model.addAttribute("success", "Category Addded");
					}
				} else {
					if (categoryDAO.update(category)) {
						model.addAttribute("success", "Category Addded");
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return "redirect:/admin";
	}

	// To get the category
	@GetMapping(value = { "/show/category/{id}" })
	public ModelAndView getCategoryById(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("category", categoryDAO.get(id));
		mv.addObject("userClickAdmin", true);
		return mv;
	}

	// To delete the category
	@RequestMapping(value = { "delete/{id}/category" })
	public String deleteCategoryById(@PathVariable Integer id) {
		categoryDAO.delete(id);
		return "redirect:/admin";
	}
	
	// - Product
	
	@RequestMapping("products/allproducts")
	public @ResponseBody List<Products> allproduct() {

		return productsDAO.list();
	}

	@RequestMapping(value={"/Products"})
	public String newProduct(ModelMap model) {
		Products products = new Products();
		model.addAttribute("products", products);
		model.addAttribute("userClickProducts", true);

		return "page";
	}

	@RequestMapping(value = "/save/Products", method = RequestMethod.POST)
	public String submitForm(@Valid Products product, BindingResult result, ModelMap model) {
		try {
			System.out.println("inside save");
			if (result.hasErrors()) {
				System.out.println("entered errors");
				model.addAttribute("products", products);
				model.addAttribute("userClickProduct", true);
				return "page";
			} else {
				System.out.println("enterd if");
				if (product.getPrdid() == 0) {
					System.out.println("entering into else if prdkfas");
					String realPath = request.getServletContext().getRealPath("/assets/images/");
					File folderToUpload = new File(realPath);

					if (!folderToUpload.exists()) {
						folderToUpload.mkdirs();
					}
					MultipartFile file = product.getFile();
					// creating the file name categoryname.jpg
					String fileToUpload = realPath + product.getPrdname() + ".jpg";

					File destination = new File(fileToUpload);

					System.out.println("file path is:" + destination.toString());
					// transfering multipart data to destination
					file.transferTo(destination);
					// set the i,ageurl field od category model
					product.setPrdimgURL(destination.getName());

					if (productsDAO.add(product)) {
						model.addAttribute("success", "product added");

					}
				} else {
					if (productsDAO.update(product)) {
						model.addAttribute("success", "product added");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/admin/Products";
	}

	@GetMapping("/displayproducts")
	
	public @ResponseBody List<Products> allproducts() {
		System.out.println("products list"+productsDAO.list());
		return productsDAO.list();
	}

	@GetMapping("/admin/products/allproducts")
	@ResponseBody
	public List<Products> allproducts1() {
		return productsDAO.list();
	}

	@RequestMapping(value={"/delete/{id}"})
	public String deleteProduct(@PathVariable Integer id) {
		productsDAO.delete(id);
		return "redirect:/product";
	}

	@GetMapping(value = {"/showproduct/{id}"})
	public ModelAndView getProductsById(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("prd", productsDAO.getProduct(id));
		mv.addObject("userClickProduct", true);
		return mv;
	}

}
