package hdy.zy.system.dao;

import java.util.List;
import java.util.Map;

import hdy.zy.system.entity.Department;

/**
 * @author huangdaye
 *部门DAO层
 */
public interface DepartmentMapper {
    
	/**
	 * 添加部门
	 * @param department
	 * @return
	 */
	int saveDepartment(Department department);
	
	/**
	 * 修改部门
	 * @param department
	 * @return
	 */
	int updateDepartment(Department department);
	
	/**
	 * 通过ID删除部门
	 * @param id
	 * @return
	 */
	int deleteDepartmentById(long id);
	
	/**
	 * 分页查询部门信息
	 * @param map
	 * @return
	 */
	List<Department> queryAllByPage(Map<String, Long> map);
	
	
	/**
	 * 查询总记录数
	 * @return
	 */
	long count();
}