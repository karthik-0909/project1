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
			String sql="SELECT p.id,p.name,p.price,p.manufacturerName,p.category FROM quickshop.cart c join quickshop.product p where c.customerId=? and c.productId=p.id";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				product=new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setManufacturerName(resultSet.getString("manufacturerName"));
				product.setCategory(resultSet.getString("category"));
				productList.add(product);
			
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact Admin");
		}
		return productList;
	}
	@Override
	public int addItemToCart(int customerId, int productId) throws BusinessException {
		int success=0;
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="insert into quickshop.cart(customerId,productId) values(?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			preparedStatement.setInt(2, productId);
			
			success=preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact Admin");
		}
		return success;
	}
	@Override
	public int deleteItemFromCart(int productId) throws BusinessException {
		int success=0;
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="delete from quickshop.cart where productId=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			
			success=preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact Admin");
		}
		return success;
	}
	@Override
	public int placeAnOrder(List<Product> cartList, int customerId) throws BusinessException{
		int success=0;
		try(Connection connection=MySqlDbConnection.getconnection()){
			for(int i=0;i<cartList.size();i++) {
				String sql="insert into quickshop.orders(productId,customerId,amount) values(?,?,?)";
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setInt(1, cartList.get(i).getId());
				preparedStatement.setInt(2, customerId);
				preparedStatement.setDouble(3, cartList.get(i).getPrice());
			
				success=preparedStatement.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact Admin");
		}
		return success;
	}

}
