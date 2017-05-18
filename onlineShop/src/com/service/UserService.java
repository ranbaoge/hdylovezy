package com.service;

import com.entity.User;

public interface UserService {
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	int saveUser(User user);
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	User login(User user);
	
	/**
	 * 根据用户名查询用户
	 * @return
	 */
	User queryByName(String username);
}
