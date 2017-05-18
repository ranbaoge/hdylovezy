package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDao.saveUser(user);
	}

	@Override
	public void updateUser(Map<String, String> map) {
		// TODO Auto-generated method stub
		userDao.updateUser(map);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(id);
	}

	@Override
	public List<User> queryByPage(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		int page=map.get("page");
		int pageSize=map.get("pageSize");
		
		int from=(page-1)*pageSize;
		Map<String, Integer> map1=new HashMap<String,Integer>();
		map1.put("from", from);
		map1.put("pageSize", pageSize);
		return userDao.queryByPage(map1);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return userDao.count();
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	@Override
	public void updateState(String username) {
		// TODO Auto-generated method stub
		userDao.updateState(username);
	}

	@Override
	public void emptyState() {
		// TODO Auto-generated method stub
		userDao.emptyState();
	}

	
}
