package com.service;

import java.util.List;

import com.entity.Teacher;


public interface TeacherService {

    List<Teacher> queryAll();
	
	int save(Teacher teacher);
	
	int update(Teacher teacher);
	
	int delete(int id);
}
