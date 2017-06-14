package com.dao;

import java.util.List;

import com.entity.Teacher;

public interface TeacherDao {

	List<Teacher> queryAll();
	
	int save(Teacher teacher);
	
	int update(Teacher teacher);
	
	int delete(int id);
}
