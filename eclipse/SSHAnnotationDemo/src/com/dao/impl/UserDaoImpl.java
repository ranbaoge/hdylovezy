package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.entity.IdCard;
import com.entity.User;
@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private String hql;
	
	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		hql="from User u left join fetch u.idCard";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list=query.list();
		return list;
	}

	@Override
	public void saveUser(User user,IdCard idCard) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		user.setIdCard(idCard);
		session.save(idCard);
		session.save(user);
	}

}
