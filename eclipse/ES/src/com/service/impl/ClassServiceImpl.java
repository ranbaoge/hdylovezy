package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ClassDao;
import com.entity.UserClass;
import com.service.ClassService;
@Service("classService")
public class ClassServiceImpl implements ClassService{
	@Resource(name="classDao")
	private ClassDao classDao;
	
	@Override
	public List<UserClass> queryByClass(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		Integer id=map.get("id");
		Integer page=map.get("page");
		Integer pageSize=map.get("pageSize");
		
		Integer from=(page-1)*pageSize;
		
		Map<String, Integer> map1=new HashMap<>();
		map1.put("id", id);
		map1.put("from", from);
		map1.put("pageSize", pageSize);
		
		return classDao.queryByClass(map1);
	}

	@Override
	public int count(int id) {
		// TODO Auto-generated method stub
		return classDao.count(id);
	}

}
