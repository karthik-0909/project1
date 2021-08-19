package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CartServicesDAO;
import com.app.dao.db.connection.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class CartServicesDAOImpl implements CartServicesDAO{
	private static Logger log=Logger.getLogger(CartServicesDAOImpl.class);
	@Override
	public List<Product> ViewCart(int customerId) throws BusinessException {
		Product product=null;
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="SELECT p.id,p.name,p.price FROM quickshop.cart c join quickshop.product p where c.customerId=? and c.productId=p.id";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				product=new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				productList.add(product);
			
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact Admin");
		}
		return null;
	}

}