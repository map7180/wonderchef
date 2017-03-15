package com.mk.shoppingbackend.dao;

import java.util.List;

import com.mk.shoppingbackend.dto.Address;

public interface AddressDAO {

	List<Address> list();
	boolean add(Address address);
	boolean update(Address address);
	boolean delete(Address address);
	
}
