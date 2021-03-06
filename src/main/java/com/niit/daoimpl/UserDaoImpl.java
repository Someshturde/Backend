package com.niit.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDao;
import com.niit.model.User;

@Repository("userDaoImpl")
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDaoImpl()
	{
		System.out.println("UserDaoImpl Created");
	}
	
	public void registerUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		
	}

	public User login(User user) {
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email=? and password=?");
		query.setString(0, user.getEmail());
		query.setString(1, user.getPassword());
		return (User) query.uniqueResult();
	}

	public User getUser(String email) {
		Session session = sessionFactory.getCurrentSession();
		User user=(User) session.get(User.class, email);
		return user;
	}

}
