package com.mk.onlineshopping.controller;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mk.shoppingbackend.dao.UserRegDAO;
import com.mk.shoppingbackend.dto.Address;
import com.mk.shoppingbackend.dto.UserReg;

@Component
public class HandlerClass {

	@Autowired
	UserRegDAO userDAO;
	

	public RegisterModel initFlow() {
		System.out.println("entering");
		return new RegisterModel();
	}

	public String save(RegisterModel registerModel,Address address) {
		
		String status = "success";
		if (!userDAO.add(registerModel.getUser()))
			status = "failure";
		
		return status;
	}
	
	public void bindingUser(RegisterModel registerModel,UserReg user)
	{
		registerModel.setUser(user);
	}
	public void bindingAddress(RegisterModel registerModel,Address address)
	{
		registerModel.setAddress(address);
			
	}
	
	public String save(RegisterModel registerModel)
	{
		try{
	   UserReg user=	registerModel.getUser();
	   Address address=registerModel.getAddress();
	   Set set=new TreeSet();
	   set.add(address);
	   user.setAddress(set);
	   address.setUserreg(user);
	   userDAO.add(user);
	   return "success";
		}catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	   
	}
}
