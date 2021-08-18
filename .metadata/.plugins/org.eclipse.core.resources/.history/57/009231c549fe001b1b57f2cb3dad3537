package com.app.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDbConnection {
	private static Connection connection;
	private MySqlDbConnection() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection  getconnection() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("Driver loaded");
			
			String url="jdbc:mysql://localhost:3306/players";
			String username="root";
			String password="Tillu@99";
			connection=DriverManager.getConnection(url, username, password);
			return connection;
	}

}
