package com.dao;

import java.util.List;

import com.entity.IdCard;
import com.entity.User;

public interface UserDao {

	void saveUser(User user,IdCard idCard);
	
	List<User> queryAll();
}
