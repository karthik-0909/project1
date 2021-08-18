package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.LoginDAO;
import com.app.dao.db.connection.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class LoginDAOImpl implements LoginDAO{
	private static Logger log=Logger.getLogger(LoginDAOImpl.class);
	Customer  customer=null;

	@Override
	public Customer loginByMail(String mail, String password) throws BusinessException {
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="select id,name,mail,password from quickshop.customer where mail=? and password=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, mail);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer=new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setName(resultSet.getString("name"));
				customer.setMail(mail);
				customer.setPassword(password);
			}if(customer==null) {
				throw new BusinessException("Gmail or the Password you have entered is wrong, please check and try again...");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact Admin");
		}
		return customer;
	}

}
