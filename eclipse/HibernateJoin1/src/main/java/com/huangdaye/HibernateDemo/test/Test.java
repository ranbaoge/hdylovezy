package com.huangdaye.HibernateDemo.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;

import com.huangdaye.HibernateDemo.entity.Student;
import com.huangdaye.HibernateDemo.entity.Teacher;
import com.huangdaye.HibernateDemo.tool.Tool;
/**
 * Junit测试类
 * hibernateAPI的增删查改
 * @author huangdaye
 *
 */
public class Test {
	private Session session;
	private Tool tool=new Tool();
	private String hql;
	
	/**
	 * 测试方法之前获取session
	 */
	@Before
	public void before(){
		session=tool.getSession();
	}

	/**
	 * 测试方法之后提交事物
	 */
	@After
	public void after(){
		tool.commit();
	}
	
	@org.junit.Test
	public void save(){
		Student stu=new Student("Riven", "女", "湖南省常德市武陵区");
		Teacher teacher=(Teacher) session.get(Teacher.class, 1);
		stu.setTeacher(teacher);
		session.save(stu);
	}
	
	
	
	/**
	 * HQL查询，查询所有
	 */
	@org.junit.Test
	public void queryAll(){
		hql="from Student";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Student> list= query.list();
		for (Student s : list) {
			System.out.println(s+"\t"+s.getTeacher());
		}
	}
	
	@org.junit.Test
	public void queryAll1(){
		hql="from Teacher";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Teacher> list=query.list();
		for (Teacher t : list) {
			System.out.println(t+"\t"+t.getStudents());
		}
	}
	
	
}
