package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BooksDao;
import com.entity.Books;
import com.tool.JdbcTool;

public class BooksDaoImpl implements BooksDao{
	private JdbcTool tool=new JdbcTool();
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private String sql;

	@Override
	public List<Books> queryByPage(int page, int pageSize) {
		connection=tool.getConnection();
		List<Books> list=new ArrayList<Books>();
		//定义起始页
		int from=(page-1)*pageSize;
		sql="select * from books limit ?,?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, from);
			statement.setInt(2, pageSize);
			resultSet=statement.executeQuery();
			while (resultSet.next()) {
				Integer id=resultSet.getInt(1);
				String bookname=resultSet.getString(2);
				Float price=resultSet.getFloat(3);
				String image=resultSet.getString(4);
				Integer stock=resultSet.getInt(5);
				Books book=new Books(id, bookname, price, image, stock);
				list.add(book);
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
		return list;
	}

	@Override
	public int count() {
		connection=tool.getConnection();
		sql="select count(1) from books";
		int count=0;
		try {
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while (resultSet.next()) {
				count=resultSet.getInt(1);
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
		
		return count;
	}

	@Override
	public Books queryById(int id) {
		// TODO Auto-generated method stub
		connection=tool.getConnection();
		Books b=null;
		sql="select * from books where bid=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet=statement.executeQuery();
			while (resultSet.next()) {
				String bookname=resultSet.getString(2);
				Float price=resultSet.getFloat(3);
				String image=resultSet.getString(4);
				Integer stock=resultSet.getInt(5);
				b=new Books(id, bookname, price, image, stock);
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
		return b;
	}

}
