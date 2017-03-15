package com.mk.onlineshopping.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mk.shoppingbackend.dao.CartDAO;
import com.mk.shoppingbackend.dao.CartItemDAO;
import com.mk.shoppingbackend.dao.ProductsDAO;
import com.mk.shoppingbackend.dao.UserRegDAO;
import com.mk.shoppingbackend.dto.Cart;
import com.mk.shoppingbackend.dto.CartItem;
import com.mk.shoppingbackend.dto.Products;
import com.mk.shoppingbackend.dto.UserReg;



@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartItemDAO cartitemDAO;
	
	@Autowired
	private ProductsDAO productsDAO;
	
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private UserRegDAO userregDAO;

	private UserReg userreg;
	CartItem cartItem = new CartItem();

	@RequestMapping(value = "/customer/viewcart")
	public String userviewcart(Principal principal, Model model) {

		if (principal != null) {
			userreg = userregDAO.getUserByUserName(principal.getName());

			if (userreg.getRole().equals("admin"))
				return "redirect:/admin/show/product";

		}

		model.addAttribute("title", "View Cart");

		model.addAttribute("cartitemlist", (userreg.getCart()).getCartItem());

		model.addAttribute("userClickViewCart", true);
		return "index";
	}

	@RequestMapping(value = "/user/addtocart/{id}")
	public String useraddproducttocart(@PathVariable("id") int id, Principal principal, Model model) {

		CartItem cartItem = null;

		userreg = userregDAO.getUserByUserName(principal.getName());
		Cart cart = userreg.getCart();
		System.out.println("cart" + cart.getId());
		if (cart.getCartItem() != null) {
			for (CartItem o : cart.getCartItem()) {
				if (o.getProduct().getPrdid() == id) {
					System.out.println("inside loop");
					cartItem = o;
					System.out.println("going to exit loop");
					break;
				}
			}
		}
		if (cartItem == null) {
			System.out.println("inside new cartitem");
			Products products = productsDAO.get(id);
			cartItem = new CartItem();
			cartItem.setCart(cart);
			cartItem.setProduct(products);
			cartItem.setQuantity(cartItem.getQuantity() + 1);
			cartItem.setTotalPrice(products.getPrdprice() * cartItem.getQuantity());

			cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotalPrice());
			cart.setTotalitems(cart.getTotalitems() + 1);
			cartitemDAO.add(cartItem);
		} else {
			cartItem.setQuantity(cartItem.getQuantity() + 1);
			cartItem.setTotalPrice((cartItem.getProduct()).getPrdprice() * cartItem.getQuantity());

			cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotalPrice());
			cartitemDAO.update(cartItem);

		}
		return "redirect:/cart/customer/viewcart";

	}

	@RequestMapping(value = "/customer/delete/{id}")
	public String userdeleteproductfromcart(@PathVariable("id") int id, Principal principal, Model mv) {

		if (principal != null) {
			userreg = userregDAO.getUserByUserName(principal.getName());

			if (userreg.getRole().equals("admin"))
				return "redirect:/admin/show/product";
		}

		Products product = null;

		product = productsDAO.get(id);

		CartItem cartItem = new CartItem();
		cartItem.setId(userreg.getId());
		cartItem.setQuantity(cartItem.getQuantity() - 1);
		cartItem.setProduct(product);
		cartItem.setTotalPrice(product.getPrdprice());

		confirmDeleteCartItem(cartItem);
		mv.addAttribute("userClickViewCart", true);
		return "index";
	}

	public void confirmDeleteCartItem(CartItem cartItem) {
		Cart existingCart = new Cart();

		// if no items in the cart
		if (existingCart == null || existingCart.getId() == 0) {

		} else {
			if (cartItem.getQuantity() == 1)
				cartitemDAO.delete(existingCart.getId());
			else {
				cartItem.setQuantity(cartItem.getQuantity() - 1);

				cartitemDAO.update(cartItem);
			}
		}

	}
}
