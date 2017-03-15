package com.mk.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.shoppingbackend.dao.ProductsDAO;
import com.mk.shoppingbackend.dto.Products;

@Repository("productsDAO")
@Transactional
public class ProductsDAOImpl implements ProductsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Products> list() {
		System.out.println("entering into list");
		return sessionFactory.getCurrentSession().createQuery("FROM Products", Products.class).getResultList();
	}

	public Products get(int id) {
		return sessionFactory.getCurrentSession().get(Products.class, Integer.valueOf(id));
	}

	public boolean add(Products products) {
		try {
			// adding product to datbase
			sessionFactory.getCurrentSession().save(products);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}


	}

	public boolean update(Products products) {
		try {
			// adding product to datbase
			sessionFactory.getCurrentSession().update(products);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
}

	public void delete(int id) {
		Products products = (Products) sessionFactory.getCurrentSession().load(Products.class, new Integer(id));
		if (products != null) {
			sessionFactory.getCurrentSession().delete(products);
		}

	}

	public Products getProduct(int id) {
		return sessionFactory.getCurrentSession().get(Products.class, id);}

}
