package com.mk.onlineshopping.controller;

import java.io.Serializable;

import com.mk.shoppingbackend.dto.Address;
import com.mk.shoppingbackend.dto.UserReg;

public class RegisterModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private UserReg user;
	private Address address;
	
	
	public UserReg getUser() {
		return user;
	}
	public void setUser(UserReg user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
