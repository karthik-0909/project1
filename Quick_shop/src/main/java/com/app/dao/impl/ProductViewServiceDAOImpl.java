package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ProductViewServiceDAO;
import com.app.dao.db.connection.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class ProductViewServiceDAOImpl implements ProductViewServiceDAO{
	private static Logger log=Logger.getLogger(ProductViewServiceDAOImpl.class);

	@Override
	public Product viewProductById(int id) throws BusinessException {

		Product product=null;
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="select id,name,price,manufacturerName,category from quickshop.product where id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				product=new Product();
				product.setId(id);
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setManufacturerName(resultSet.getString("manufacturerName"));
				product.setCategory(resultSet.getString("category"));
			
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact Admin");
		}

		return product;
	}

	@Override
	public List<Product> viewProductByName(String name) throws BusinessException {
		Product product=null;
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="select id,name,price,manufacturerName,category from quickshop.product where name like ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+name+"%");
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				product=new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(name);
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
	public List<Product> viewProductByManufactureName(String manuafturerName) throws BusinessException {
		Product product=null;
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="select id,name,price,manufacturerName,category from quickshop.product where manufacturername like ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+manuafturerName+"%");
			
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
	public List<Product> viewProductByCategory(String category) throws BusinessException {
		Product product=null;
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="select id,name,price,manufacturerName,category from quickshop.product where category like ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+category+"%");
			
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
			System.out.println("Internal error occured contact admin");
		}
		
		return productList;
	}

	@Override
	public List<Product> viewProductByPrice(double price) throws BusinessException {
		Product product=null;
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="SELECT id,name,price,manufacturerName,category FROM quickshop.product where price>=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setDouble(1, price);
			
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
			System.out.println("Internal error occured contact admin");
		}
		return productList;
	}

}
