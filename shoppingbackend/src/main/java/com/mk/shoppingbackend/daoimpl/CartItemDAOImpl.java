package com.mk.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.shoppingbackend.dao.CartItemDAO;
import com.mk.shoppingbackend.dto.CartItem;

@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<CartItem> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM CartItem", CartItem.class).getResultList();

	}

	public CartItem get(int id) {
		return sessionFactory.getCurrentSession().get(CartItem.class, Integer.valueOf(id));
	}

	public boolean add(CartItem cartitem) {
		try {
			sessionFactory.getCurrentSession().save(cartitem);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean update(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public void delete(int id) {
		CartItem cat=	(CartItem) sessionFactory.getCurrentSession().load(CartItem.class, new Integer(id));
		if (cat!=null)
		{
			sessionFactory.getCurrentSession().delete(cat);
		}

	}

/*	public CartItem getCartByUserId(int userId) {
		return (CartItem) sessionFactory.getCurrentSession().createQuery("FROM CartItem  WHERE userid='" + userId + "'")
				.getResultList();
	}

	public CartItem getCartByUserIdAndProduct(int userId, int productId) {

		return (CartItem) sessionFactory.getCurrentSession()
				.createQuery("FROM CartItem  WHERE userid='" + userId + "' and productid='" + productId + "'")
				.getResultList();
	}
*/
	}
