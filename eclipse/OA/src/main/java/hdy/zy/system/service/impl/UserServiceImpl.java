package hdy.zy.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hdy.zy.system.dao.UserMapper;
import hdy.zy.system.entity.User;
import hdy.zy.system.service.UserService;

/**
 * @author huangdaye
 *用户Service实现层
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.saveUser(user);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}

	@Override
	public int deleteUserById(long id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUserById(id);
	}

	@Override
	public User queryUserById(long id) {
		// TODO Auto-generated method stub
		return userMapper.queryUserById(id);
	}

	@Override
	public List<User> queryAllByPage(Map<String, Long> map) {
		// TODO Auto-generated method stub
		long page=map.get("page");
		long pageSize=map.get("pageSize");
		
		long from=(page-1)*pageSize;
		Map<String, Long> map1=new HashMap<String,Long>();
		map1.put("from", from);
		map1.put("pageSize", pageSize);
		
		return userMapper.queryAllByPage(map1);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return userMapper.count();
	}

	@Override
	public List<User> queryAllByLike(Map<String, Object> map) {
		// TODO Auto-generated method stub
		long page=(long) map.get("page");
		long pageSize=(long) map.get("pageSize");
		String name=(String) map.get("name");
		
		long from=(page-1)*pageSize;
		Map<String, Object> map1=new HashMap<String,Object>();
		map1.put("from", from);
		map1.put("pageSize", pageSize);
		map1.put("name", name);
		return userMapper.queryAllByLike(map1);
	}

	@Override
	public User repassword(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMapper.repassword(map);
	}

}
