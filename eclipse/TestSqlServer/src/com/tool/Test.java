package com.tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=new JdbcTool().getConnection();
		String sql="select * from t_user";
		List<User> list=new ArrayList<>();
		PreparedStatement statement=null;
		ResultSet rs=null;
		try {
			statement=connection.prepareStatement(sql);
			rs=statement.executeQuery();
			while (rs.next()) {
				int id=rs.getInt(1);
				String username=rs.getString(2);
				String password=rs.getString(3);
				User user=new User(id, username, password);
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (User u : list) {
			System.out.println(u);
		}
	}

}
