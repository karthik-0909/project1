package com.app.dao.db.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class MySqlDbConnection {
	private static Connection connection;
	private MySqlDbConnection() {
	}
	
	public static Connection  getconnection() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/quickshop";
			String username="root";
			String password="Tillu@99";
			connection=DriverManager.getConnection(url, username, password);
			return connection;

	}
}
