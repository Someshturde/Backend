package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.PostDao;
import com.niit.model.Post;

@Repository
@Transactional
public class PostDaoImpl implements PostDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PostDaoImpl()
	{
		System.out.println("PostDaoImpl created");
	}

	public void addPost(Post post) {
		Session session=sessionFactory.getCurrentSession();
		session.save(post);
		
	}

	public List<Post> getAllPost() 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Post");
		return query.list();
	}

}
