package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.UserDao;
import com.entity.User;
import com.tool.JdbcTool;

public class UserDaoImpl implements UserDao{
	
	private JdbcTool tool=new JdbcTool();
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private String sql;
	
	@Override
	public int saveUser(User user) {
		//定义插入数据库影响得到行数
		int rs=0;
		//获取连接
		connection=tool.getConnection();
		//写sql
		sql="insert into userinfo(username,password,email) value(?,?,?)";
		//实例化statement
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			//执行sql,保存用户信息
			rs=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return rs;
	}

	@Override
	public User login(User user) {
		connection=tool.getConnection();
		User u=null;
		sql="select * from userinfo where username=? and password=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			resultSet=statement.executeQuery();
			while (resultSet.next()) {
				Integer id=resultSet.getInt(1);
				String username=resultSet.getString(2);
				String password=resultSet.getString(3);
				String email=resultSet.getString(4);
				u=new User(id, username, password, email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return u;
	}

	@Override
	public User queryByName(String username) {
		// TODO Auto-generated method stub
		connection=tool.getConnection();
		User u=null;
		sql="select * from userinfo where username=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, username);
			resultSet=statement.executeQuery();
			while (resultSet.next()) {
				Integer id=resultSet.getInt(1);
				String username1=resultSet.getString(2);
				String password=resultSet.getString(3);
				String email=resultSet.getString(4);
				u=new User(id, username1, password, email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return u;
	}

}
