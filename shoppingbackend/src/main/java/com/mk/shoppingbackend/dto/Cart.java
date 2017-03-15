package com.mk.shoppingbackend.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int totalitems;
	private int totalvalueofitems;
	private double grandTotal;
	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	@OneToOne(cascade = CascadeType.PERSIST)
	private UserReg userreg;

	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="cart")
	private Set<CartItem> cartItem=new HashSet<CartItem>();
	

	
	
	public UserReg getUserreg() {
		return userreg;
	}

	public void setUserreg(UserReg userreg) {
		this.userreg = userreg;
	}

	public Set<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(Set<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", totalitems=" + totalitems + ", totalvalueofitems="
				+ totalvalueofitems + "]";
	}	
	
	/*
	 * Getters and Setters
	 */
	

	public int getId() {
		return id;
	}
	

	public UserReg getUser() {
		return userreg;
	}

	public void setUser(UserReg user) {
		this.userreg = user;
	}

	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTotalitems() {
		return totalitems;
	}
	public void setTotalitems(int totalitems) {
		this.totalitems = totalitems;
	}
	public int getTotalvalueofitems() {
		return totalvalueofitems;
	}
	public void setTotalvalueofitems(int totalvalueofitems) {
		this.totalvalueofitems = totalvalueofitems;
	}

}