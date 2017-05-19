package com.tool;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTool {
	private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url="jdbc:sqlserver://localhost:1433;database=accp";
	private String username="accp";
	private String password="accp";
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
