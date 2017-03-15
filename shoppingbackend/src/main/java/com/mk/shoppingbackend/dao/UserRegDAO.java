package com.mk.shoppingbackend.dao;

import java.util.List;

import com.mk.shoppingbackend.dto.UserReg;

public interface UserRegDAO {

	UserReg get(int id);
	List<UserReg> list();
	boolean add(UserReg userreg);
	boolean update(UserReg userreg);

	boolean delete(UserReg userreg);

	UserReg getUserByUserName(String name);
}
