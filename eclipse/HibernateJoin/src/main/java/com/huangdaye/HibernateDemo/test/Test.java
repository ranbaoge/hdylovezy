package com.huangdaye.HibernateDemo.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;

import com.huangdaye.HibernateDemo.entity.IdCard;
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
		Teacher t=new Teacher("张老师");
		IdCard ic=new IdCard("87872832234");
		t.setIdCard(ic);
		session.save(ic);
		session.save(t);
	}
	
	/**
	 * HQL查询，查询所有
	 */
	@org.junit.Test
	public void queryAll(){
		hql="from IdCard";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<IdCard> list=query.list();
		for (IdCard ic : list) {
			System.out.println(ic+"\t"+ic.getTeacher());
		}
	}
	
	
}
