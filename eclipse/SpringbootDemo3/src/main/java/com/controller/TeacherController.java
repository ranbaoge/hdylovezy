package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Teacher;
import com.service.TeacherService;

@Controller
public class TeacherController {

	private static Logger logger=LoggerFactory.getLogger(TeacherController.class);
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("save.do")
	public String save(Teacher teacher,Model model){
		int rs= teacherService.save(teacher);
		logger.info("保存了"+rs+"条数据");
		return queryAll(model);
	}
	
	@RequestMapping("update.do")
	public String update(Teacher teacher,Model model){
		int rs=teacherService.update(teacher);
		logger.info("修改了"+rs+"行");
		return queryAll(model);
	}
	
	@RequestMapping("delete.do/{id}")
	public String delete(@PathVariable int id,Model model){
		int rs=teacherService.delete(id);
		logger.info("删除了"+rs+"行");
		return queryAll(model);
	}
	
	@RequestMapping("query.do")
	public String queryAll(Model model){
		List<Teacher> list= teacherService.queryAll();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping("/")
	public String show(Model model){
		logger.info("hello");
		return "show";
	}
	
}
