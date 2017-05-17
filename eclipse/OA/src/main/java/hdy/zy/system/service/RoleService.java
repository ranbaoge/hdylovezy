package hdy.zy.system.service;

import java.util.List;
import java.util.Map;

import hdy.zy.system.entity.Role;

/**
 * @author huangdaye
 *角色Service层
 */
public interface RoleService {
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
   int saveRole(Role role);
   
   /**
    * 修改角色
    * @param role
    * @return
    */
   int updateRole(Role role);
   
   /**
    * 通过ID删除角色
    * @param id
    * @return
    */
   int deleteRoleById(long id);
   
   /**
    * 分页查询角色信息
    * @param map
    * @return
    */
   List<Role> queryAllByPage(Map<String, Long> map);
   
   /**
	 * 查询总记录数
	 * @return
	 */
	long count();
}
