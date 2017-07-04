package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {

	int saveUser(User user);
	
	List<User> queryAll();
}
