package com.niit.dao;

import java.util.List;

import com.niit.model.Post;

public interface PostDao {
	
	public void addPost (Post post);
	
	List<Post> getAllPost();

}
