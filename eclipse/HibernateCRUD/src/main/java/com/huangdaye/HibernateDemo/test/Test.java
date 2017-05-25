package com.huangdaye.HibernateDemo.test;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;

import com.huangdaye.HibernateDemo.entity.User;
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
	
	/**
	 * 使用save()方法保存用户信息
	 */
	@org.junit.Test
	public void save(){
		User u=new User("xxxxx", "123");
		session.save(u);
	}
	
	/**
	 * 使用update()方法修改用户信息
	 */
	@org.junit.Test
	public void update(){
		User u=new User(1, "莱恩哈特", "123");
		session.update(u);
	}
	
	/**
	 * 使用saveOrUpdate来更新
	 * 如果对象的ID在数据库保存了，则会使用update()更新
	 * 如果查不到ID,则会使用save()保存
	 */
	@org.junit.Test
	public void saveOrUpdate(){
		User user=new User("卡尔", "123");
		session.saveOrUpdate(user);
	}
	
	/**
	 * 使用merge来更新
	 * 如果对象的ID在数据库保存了，则会使用update()更新
	 * 如果查不到ID,则会使用save()保存
	 * merge不会使该对象变为持久态，只是将它保存到数据库
	 */
	@org.junit.Test
	public void merge(){
		User user=new User(6, "亚里欧斯", "123");
		User u= (User) session.merge(user);
		System.out.println(u);
	}
	
	/**
	 * 使用delete()方法删除用户信息
	 */
	@org.junit.Test
	public void delete(){
		User user= (User) session.get(User.class, 4);
		session.delete(user);
	}
	
	/**
	 * 使用get()方法来查询
	 * get方法会立刻到数据库查询数据,如果ID不存在，则报Object异常
	 */
	@org.junit.Test
	public void queryByGet(){
		User user= (User) session.get(User.class, 1);
		System.out.println(user);
	}
	
	/**
	 * 使用load()方法来查询
	 * load实现延迟加载，并不会直接发出sql语句，得到的是代理对象
	 * 该对象只保存实体对象ID值，只有当我们使用得到时候才会发出sql语句
	 */
	@org.junit.Test
	public void queryByLoad(){
		User user=(User) session.load(User.class, 2);
		System.out.println(user);
	}
	
}
