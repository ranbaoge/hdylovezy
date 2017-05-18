package com.tool;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTool {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/object";
	private String username="root";
	private String password="123";
	private Connection connection;
	
	public Connection getConnection(){
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
}
