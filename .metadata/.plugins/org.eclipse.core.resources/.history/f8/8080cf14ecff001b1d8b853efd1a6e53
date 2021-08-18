package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.dao.RegistrationDAO;
import com.app.dao.db.connection.MySqlDbConnection;
import com.app.exception.BusinessException;

public class RegistrationDAOImpl implements RegistrationDAO{

	@Override
	public int CreateNewCustomer(String name,String mail,String password) throws BusinessException{
		int success=0;
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="insert into quickshop.customer (name,mail,password) values(?,?,?);";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, mail);
			preparedStatement.setString(3, password);
			
			success=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			
		}
		return success;
	}

}
