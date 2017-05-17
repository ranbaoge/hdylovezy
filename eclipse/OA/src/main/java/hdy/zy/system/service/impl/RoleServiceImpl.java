package hdy.zy.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hdy.zy.system.dao.RoleMapper;
import hdy.zy.system.entity.Role;
import hdy.zy.system.service.RoleService;

/**
 * @author huangdaye
 *角色Service层实现类
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{
	
	@Resource(name="roleMapper")
	private RoleMapper roleMapper;
	
	@Override
	public int saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.saveRole(role);
	}

	@Override
	public int updateRole(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.updateRole(role);
	}

	@Override
	public int deleteRoleById(long id) {
		// TODO Auto-generated method stub
		return roleMapper.deleteRoleById(id);
	}

	@Override
	public List<Role> queryAllByPage(Map<String, Long> map) {
		// TODO Auto-generated method stub
		long page=map.get("page");
		long pageSize=map.get("pageSize");
		
		long from=(page-1)*pageSize;
		Map<String, Long> map1=new HashMap<String,Long>();
		map1.put("from", from);
		map1.put("pageSize", pageSize);
		
		return roleMapper.queryAllByPage(map1);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return roleMapper.count();
	}

}
