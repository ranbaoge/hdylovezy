package com.huangdaye.HibernateDemo.test;

import java.util.Arrays;
import java.util.Iterator;
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
		for (int i = 1; i <20; i++) {
			Teacher teacher=new Teacher();
			teacher.setName("黄老师"+i);
			session.save(teacher);
		}
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
			System.out.println(s);
		}
	}
	
	/**
	 * HQL-根据ID查询
	 * 基于?动态传参
	 */
	@org.junit.Test
	public void queryById(){
		hql="from Student where id=?";
		Query query=session.createQuery(hql);
		query.setParameter(0, 3);
		Student stu=(Student) query.uniqueResult();
		System.out.println(stu);
	}
	
	/**
	 * 基于别名的动态传参
	 */
	@org.junit.Test
	public void queryById2(){
		hql="from Student where id=:id";
		Query query=session.createQuery(hql);
		query.setInteger("id", 3);
		Student stu=(Student) query.uniqueResult();
		System.out.println(stu);
	}
	
	/**
	 * 模糊查询
	 */
	@org.junit.Test
	public void queryByLike(){
		hql="from Student where address like ?";
		Query query=session.createQuery(hql);
		query.setParameter(0, "%广东省%");
		@SuppressWarnings("unchecked")
		Iterator<Student> it= query.iterate();
		while (it.hasNext()) {
			Student stu=it.next();
			System.out.println(stu);
		}
	}
	
	/**
	 * HQL投影查询
	 * 返回多列需要的字段，不需要返回整个对象信息
	 */
	@org.junit.Test
	public void queryByColumn(){
		hql="select name,address from Student";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Object[]> list= query.list();
		for (Object[] obj : list) {
			/*String name=(String) obj[0];
			String address=(String) obj[1];
			System.out.println(name+"\t"+address);*/
			System.out.println(Arrays.toString(obj));
		}

	}
	
	/**
	 * 通过关键字in查询
	 */
	@org.junit.Test
	public void queryByIn(){
		hql="from Student where id in (:id)";
		Query query=session.createQuery(hql);
		Integer[] id=new Integer[]{1,3,4,6};
		query.setParameterList("id", id);
		@SuppressWarnings("unchecked")
		List<Student> list=query.list();
		for (Student s : list) {
			System.out.println(s);
		}
	}
	
	/**
	 * hql分页查询
	 */
	@org.junit.Test
	public void queryByPage(){
		hql="from Student";
		Query query=session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(3);
		@SuppressWarnings("unchecked")
		List<Student> list=query.list();
		for (Student s : list) {
			System.out.println(s);
		}
	}
	
	/**
	 * hql内连接查询
	 */
	@org.junit.Test
	public void queryByInner(){
		hql="from Student s join s.teacher";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Object[]> list=query.list();
		for (Object[] objects : list) {
			Student stu=(Student) objects[0];
			Teacher teac=(Teacher) objects[1];
			System.out.println(stu+"\n"+teac);
		}
	}
	
	/**
	 * hql迫切内连接查询
	 * 迫切查询的是一个对象，将右边的对象封装在左边的对象里面
	 */
	@org.junit.Test
	public void queryByInnerFetch(){
		hql="from Student s join fetch s.teacher";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Student> list=query.list();
		for (Student s : list) {
			System.out.println(s+"\n"+s.getTeacher());
		}
	}
	
	/**
	 * hql左连接查询
	 */
	@org.junit.Test
	public void queryLeft(){
		hql="from Student s left join s.teacher";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Object[]> list=query.list();
		for (Object[] objects : list) {
			Student stu=(Student) objects[0];
			Teacher teac=(Teacher) objects[1];
			System.out.println(stu+"\n"+teac);
		}
	}
	
	@org.junit.Test
	public void queryFetchLeft(){
		hql="from Student s left join fetch s.teacher";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Student> list=query.list();
		for (Student s : list) {
			System.out.println(s+"\n"+s.getTeacher());
		}
	}
	
	/**
	 * hql右连接查询
	 * 
	 */
	@org.junit.Test
	public void queryRight(){
		hql="from Student s right join s.teacher";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Object[]> list=query.list();
		for (Object[] objects : list) {
			Student stu=(Student) objects[0];
			Teacher teac=(Teacher) objects[1];
			System.out.println(stu+"\n"+teac);
		}
	}
	
	
}
