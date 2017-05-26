package com.huangdaye.HibernateDemo.tool;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author huangdaye
 *获取hibernate的session工具类
 */
public class Tool {
	private static Configuration config=new Configuration().configure();
	private static SessionFactory sessionFactory=config.buildSessionFactory();
	private static Session session=sessionFactory.openSession();
	private static Transaction transaction=session.beginTransaction();
	
	public Session getSession(){
		return session;
	}
	
	/**
	 * 对事物进行处理
	 */
	public void commit(){
		try {
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}finally{
			session.close();
		}
	}
}
