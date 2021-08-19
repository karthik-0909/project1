package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.EmployeeServicesDAO;
import com.app.dao.db.connection.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Orders;
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

	@Override
	public int UpdateStatusOfOrderToShipped(int orderId) throws BusinessException {
		int success=0;
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="update orders set status='Shipped' where id=? and status!='Delivered'";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, orderId);
			
			success=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact Admin");
		}
		return success;
	}

	@Override
	public List<Orders> viewOrders(String status) throws BusinessException {
		Orders orders=null;
		List<Orders> ordersList= new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="SELECT id,productId,status,customerId,amount FROM quickshop.orders where status=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, status);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				orders=new Orders();
				orders.setId(resultSet.getInt("id"));
				orders.setProductId(resultSet.getInt("productId"));
				orders.setStatus(resultSet.getString("status"));
				orders.setCustomerId(resultSet.getInt("customerId"));
				orders.setAmount(resultSet.getDouble("amount"));
				ordersList.add(orders);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact Admin");
		}
		return ordersList;
	}

	@Override
	public Customer viewCustomerById(int customerId) throws BusinessException {
		Customer customer=null;
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="SELECT id,name,mail,password FROM quickshop.customer where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer=new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setName(resultSet.getString("name"));
				customer.setMail(resultSet.getString("mail"));
				customer.setPassword(resultSet.getString("password"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact Admin");
		}
		
		return customer;
	}

	@Override
	public List<Customer> viewCustomerByName(String customerName) throws BusinessException {
		Customer customer=null;
		List<Customer> customerList= new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="SELECT id,name,mail,password FROM quickshop.customer where name=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, customerName);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				customer=new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setName(resultSet.getString("name"));
				customer.setMail(resultSet.getString("mail"));
				customer.setPassword(resultSet.getString("password"));
				customerList.add(customer);
				}
			}catch (ClassNotFoundException | SQLException e) {
					log.error(e);
					throw new BusinessException("Internal error occured contact Admin");
				}
		return customerList;
	}
}
