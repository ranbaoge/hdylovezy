package com.dao;

import com.entity.User;

/**
 * @author huangdaye
 *用户DAO层
 */
public interface UserDao {
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
