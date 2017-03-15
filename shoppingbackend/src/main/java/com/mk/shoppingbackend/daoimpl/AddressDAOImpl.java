package com.mk.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.shoppingbackend.dao.AddressDAO;
import com.mk.shoppingbackend.dto.Address;

@Repository("addressDAO")
@Transactional
public class AddressDAOImpl implements AddressDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Address get(int id) {
		
		return sessionFactory.getCurrentSession().get(Address.class, Integer.valueOf(id));
	}
	
	public List<Address> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Address", Address.class).getResultList();	
		}

	

	
	public boolean add(Address address) {
		try {
			// adding product to datbase
			sessionFactory.getCurrentSession().save(address);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
}

	public boolean update(Address address) {
		try {
			// adding product to datbase
			sessionFactory.getCurrentSession().update(address);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Address address) {
		try {
			// adding product to datbase
			sessionFactory.getCurrentSession().delete(address);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
