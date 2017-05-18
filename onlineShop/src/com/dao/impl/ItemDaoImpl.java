package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.ItemDao;
import com.entity.Books;
import com.entity.Item;
import com.entity.Orders;
import com.tool.JdbcTool;

public class ItemDaoImpl implements ItemDao{
	private JdbcTool tool=new JdbcTool();
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private String sql;
	
	@Override
	public int saveItem(Item item) {
		connection=tool.getConnection();
		int rs=0;
		sql="insert into item(oid,bid,createdate,count,price,total_price) value(?,?,?,?,?,?)";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, item.getOid());
			statement.setInt(2, item.getBid());
			statement.setDate(3, new java.sql.Date(item.getCreatedate().getTime()));
			statement.setInt(4, item.getCount());
			statement.setFloat(5, item.getPrice());
			statement.setFloat(6, item.getTotal_price());
			rs=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<Item> queryByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		connection=tool.getConnection();
		List<Item> list=new ArrayList<Item>();
		//定义起始页
		int from=(page-1)*pageSize;
		sql="select i.*,b.* from item i left join books b on i.bid=b.bid limit ?,?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, from);
			statement.setInt(2, pageSize);
			resultSet=statement.executeQuery();
			while (resultSet.next()) {
				Integer iid=resultSet.getInt(1);
				Integer oid=resultSet.getInt(2);
				Integer bid=resultSet.getInt(3);
				Date createdate=resultSet.getDate(4);
				Integer count=resultSet.getInt(5);
				Float price=resultSet.getFloat(6);
				Float total_price=resultSet.getFloat(7);
				Item it=new Item(iid, oid, bid, createdate, count, price, total_price);
				Integer bbid=resultSet.getInt(8);
				String bookname=resultSet.getString(9);
				Float bprice=resultSet.getFloat(10);
				String image=resultSet.getString(11);
				Integer stock=resultSet.getInt(12);
				Books book=new Books(bbid, bookname, bprice, image, stock);
				it.setBooks(book);
				list.add(it);
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
		sql="select count(1) from item";
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
	public int saveOrders(Orders orders) {
		// TODO Auto-generated method stub
		connection=tool.getConnection();
		int rs=0;
		sql="insert into orders(username) value(?)";
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, orders.getUsername());
			rs=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<Orders> queryByOrder(int page, int pageSize) {
		// TODO Auto-generated method stub
		connection=tool.getConnection();
		List<Orders> list=new ArrayList<Orders>();
		//定义起始页
		int from=(page-1)*pageSize;
		sql="select * from orders limit ?,?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, from);
			statement.setInt(2, pageSize);
			resultSet=statement.executeQuery();
			while (resultSet.next()) {
				Integer id=resultSet.getInt(1);
				String username=resultSet.getString(2);
				Orders order=new Orders(id, username);
				list.add(order);
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
	public int countOrder() {
		connection=tool.getConnection();
		sql="select count(1) from orders";
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
	public Item queryByIn(int id) {
		connection=tool.getConnection();
		Item item=null;
		sql="select i.*,b.* from item i left join books b on i.bid=b.bid where i.bid=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet=statement.executeQuery();
			while (resultSet.next()) {
				Integer iid=resultSet.getInt(1);
				Integer oid=resultSet.getInt(2);
				Integer bid=resultSet.getInt(3);
				Date createdate=resultSet.getDate(4);
				Integer count=resultSet.getInt(5);
				Float price=resultSet.getFloat(6);
				Float total_price=resultSet.getFloat(7);
				item=new Item(iid, oid, bid, createdate, count, price, total_price);
				Integer bbid=resultSet.getInt(8);
				String bookname=resultSet.getString(9);
				Float bprice=resultSet.getFloat(10);
				String image=resultSet.getString(11);
				Integer stock=resultSet.getInt(12);
				Books book=new Books(bbid, bookname, bprice, image, stock);
				item.setBooks(book);
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
		return item;
	}
}
