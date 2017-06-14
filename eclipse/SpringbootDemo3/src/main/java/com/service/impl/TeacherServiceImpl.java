package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TeacherDao;
import com.entity.Teacher;
import com.service.TeacherService;
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherDao teacherDao;
	
	@Override
	public List<Teacher> queryAll() {
		// TODO Auto-generated method stub
		return teacherDao.queryAll();
	}

	@Override
	public int save(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.save(teacher);
	}

	@Override
	public int update(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.update(teacher);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return teacherDao.delete(id);
	}

}
