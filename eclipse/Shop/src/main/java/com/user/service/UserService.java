package com.user.service;

import java.util.List;
import java.util.Map;

import com.user.entity.User;

/**
 * @author huangdaye
 *用户业务层
 */
public interface UserService {


	/**
	 * 新增用户
	 * @param record
	 * @return
	 */
    int saveUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);
    
    /**
     * 根据ID删除用户
     * @return
     */
    int deleteUser(int id);
    
    /**
     * 分页查询所有用户
     * @return
     */
    List<User> queryAll(Map<String, Integer> map);
    
     /**
     * 查询总记录数
     * @return
     */
     int count();
    
    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);
    
    /**
     * 根据用户名和角色查询
     * @return
     */
    List<User> queryByNameAndRole(Map<String, String> map);
    
    /**
     * 根据ID查询
     * @return
     */
    User queryById(int id);
    
    /**
     * 验证用户姓名的密码
     * @param user
     * @return
     */
    boolean validate(User user);
    
    /**
     * 修改用户密码
     * @param map
     * @return
     */
    int updatepwd(Map<String, String> map);
    

}
