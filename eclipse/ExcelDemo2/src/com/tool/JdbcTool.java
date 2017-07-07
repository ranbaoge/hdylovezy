package com.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTool {

	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/ensong";
	private static final String USERNAME="root";
	private static final String PASSWORD="123";
	private static Connection connection;
	private static PreparedStatement statement;
	private static ResultSet rs;
	
	
	public Connection getConnection(){
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void close(){
			try {
				if(rs!=null){
					rs.close();
				}
				if(statement!=null){
					statement.close();
				}
				if(connection!=null){
					connection.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
