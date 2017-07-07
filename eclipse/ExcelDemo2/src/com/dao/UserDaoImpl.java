package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import com.tool.JdbcTool;

public class UserDaoImpl implements UserDao{
    private JdbcTool tool=new JdbcTool();
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet rs;
	private String sql;
	
	@Override
	public int saveUser(User user) {
		connection=tool.getConnection();
		sql="insert into t_user(username,password,gender,age,phone,address) values(?,?,?,?,?,?)";
		int count=0;
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getGender());
			statement.setInt(4, user.getAge());
			statement.setString(5, user.getPhone());
			statement.setString(6, user.getAddress());
			count=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			tool.close();
		}
		
		return count;
	}

	@Override
	public List<User> queryAll() {
		connection=tool.getConnection();
		sql="select * from t_user";
		List<User> list=new ArrayList<>();
		try {
			statement=connection.prepareStatement(sql);
			rs=statement.executeQuery();
			while (rs.next()) {
				Integer id=rs.getInt(1);
				String username=rs.getString(2);
				String password=rs.getString(3);
				String gender=rs.getString(4);
				Integer age=rs.getInt(5);
				String phone=rs.getString(6);
				String address=rs.getString(7);
				User user=new User(id, username, password, gender, age, phone, address);
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			tool.close();
		}
		return list;
	}

}
