package hdy.zy.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hdy.zy.system.dao.DepartmentMapper;
import hdy.zy.system.entity.Department;
import hdy.zy.system.service.DepartmentService;

/**
 * @author huangdaye
 *部门Service层实现类
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
	
	@Resource(name="departmentMapper")
	private DepartmentMapper departmentMapper;
	
	@Override
	public int saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentMapper.saveDepartment(department);
	}

	@Override
	public int updateDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentMapper.updateDepartment(department);
	}

	@Override
	public int deleteDepartmentById(long id) {
		// TODO Auto-generated method stub
		return departmentMapper.deleteDepartmentById(id);
	}

	@Override
	public List<Department> queryAllByPage(Map<String, Long> map) {
		// TODO Auto-generated method stub
		long page=(long) map.get("page");
		long pageSize=(long) map.get("pageSize");
		
		long from=(page-1)*pageSize;
		Map<String, Long> map1=new HashMap<String,Long>();
		map1.put("from", from);
		map1.put("pageSize", pageSize);
		
		return departmentMapper.queryAllByPage(map1);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return departmentMapper.count();
	}

}
