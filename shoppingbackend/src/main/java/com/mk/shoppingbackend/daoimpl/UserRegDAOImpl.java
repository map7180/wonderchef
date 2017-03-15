package com.mk.shoppingbackend.daoimpl;

import java.util.List;

import org.h2.engine.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mk.shoppingbackend.dao.UserRegDAO;
import com.mk.shoppingbackend.dto.UserReg;

@Repository("userregDAO")
@Transactional
public class UserRegDAOImpl implements UserRegDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserReg get(int id) {
		return sessionFactory.getCurrentSession().get(UserReg.class, Integer.valueOf(id));	}

	public List<UserReg> list() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM UserReg",UserReg.class).getResultList();

	}

	public boolean add(UserReg userreg) {
		try {
			sessionFactory.getCurrentSession().persist(userreg);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

	public boolean update(UserReg userreg) {
		try {

			sessionFactory.getCurrentSession().update(userreg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(UserReg userreg) {
		try {

			sessionFactory.getCurrentSession().delete(userreg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
}

	public UserReg getUserByUserName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
