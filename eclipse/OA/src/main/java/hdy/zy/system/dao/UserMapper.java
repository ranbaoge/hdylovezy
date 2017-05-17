package hdy.zy.system.dao;

import java.util.List;
import java.util.Map;

import hdy.zy.system.entity.User;

/**
 * @author huangdaye
 *用户DAO层
 */
public interface UserMapper {
    /**
     * 保存用户
     * @param user
     * @return
     */
	int saveUser(User user);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	
	/**
	 * 通过ID删除用户
	 * @param id
	 * @return
	 */
	int deleteUserById(long id);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	User queryUserById(long id);
	
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	List<User> queryAllByPage(Map<String, Long> map);
	
	/**
	 * 分页模糊查询
	 * @param map
	 * @return
	 */
	List<User> queryAllByLike(Map<String, Object> map);
	
	/**
	 * 验证登录
	 * @param user
	 * @return
	 */
	User login(User user);
	
	/**
	 * 查询总记录数
	 * @return
	 */
	long count();
	
	/**
	 * 管理员修改用户密码
	 * @param user
	 * @return
	 */
	User repassword(Map<String, Object> map);
	
}