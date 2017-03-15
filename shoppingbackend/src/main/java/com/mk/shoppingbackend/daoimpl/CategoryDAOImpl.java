package com.mk.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.shoppingbackend.dao.CategoryDAO;
import com.mk.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Category> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Category", Category.class).getResultList();
	}

	/* getting single category based on id */
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	public boolean add(Category category) {
		try {
			// adding category to datbase
			sessionFactory.getCurrentSession().save(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/* updating the single category--- Edit */
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}

	}
	/*
	 * to delete the items= to set the active field property to false instead of
	 * deleting the records for the system
	 */
	/*
	 * public boolean delete(int id) {
	 * 
	 * try { Query q= sessionFactory.getCurrentSession().
	 * createQuery("update Category set active=:status where id=:id");
	 * q.setParameter("status", false); q.setParameter("id", id);
	 * q.executeUpdate(); return true; } catch (Exception ex) {
	 * 
	 * ex.printStackTrace(); return false; } }
	 */

	public void delete(int id) {
		Category cat = (Category) sessionFactory.getCurrentSession().load(Category.class, new Integer(id));
		if (cat != null) {
			sessionFactory.getCurrentSession().delete(cat);
		}

	}
}
