package com.service.impl;

import java.util.List;

import com.dao.UserDao;
import com.entity.IdCard;
import com.entity.User;
import com.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveUser(User user,IdCard idCard) {
		// TODO Auto-generated method stub
		userDao.saveUser(user,idCard);
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return userDao.queryAll();
	}

}
