package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao=new UserDaoImpl();
	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		User u=queryByName(user.getUsername());
		if(u==null){
			return userDao.saveUser(user);
		}else{
			return 0;
		}
		
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	@Override
	public User queryByName(String username) {
		// TODO Auto-generated method stub
		return userDao.queryByName(username);
	}

}
