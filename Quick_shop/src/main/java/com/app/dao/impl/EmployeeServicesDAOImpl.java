package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.apache.log4j.Logger;

import com.app.dao.EmployeeServicesDAO;
import com.app.dao.db.connection.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.service.impl.EmployeeLoginServiceImpl;

public class EmployeeServicesDAOImpl implements EmployeeServicesDAO{
	private static Logger log=Logger.getLogger(EmployeeLoginServiceImpl.class);
	
	int success=0;

	@Override
	public Product addNewProduct(int id, String name, double price, String manufacturerName, String category)
			throws BusinessException {
		Product product=null;
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="insert into quickshop.product (id,name,price,manufacturerName,category) values(?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setDouble(3, price);
			preparedStatement.setString(4, manufacturerName);
			preparedStatement.setString(5, category);
			
			success=preparedStatement.executeUpdate();
			if(success==1) {
				product=new Product();
				product.setId(id);
				product.setName(name);
				product.setPrice(price);
				product.setManufacturerName(manufacturerName);
				product.setCategory(category);
			}
			
		}catch(SQLIntegrityConstraintViolationException e){
			throw new BusinessException("product with id "+id+" exists please try again with new id");
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact Admin");
		}
		return product;
	}

	@Override
	public int deleteProduct(int id) throws BusinessException {
		int success=0;
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="DELETE FROM  quickshop.product WHERE id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			success=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact Admin");
		}
		return success;
	}
}
