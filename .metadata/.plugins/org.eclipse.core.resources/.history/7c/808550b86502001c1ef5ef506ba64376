package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.OrdersServicesDAO;
import com.app.dao.db.connection.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Orders;

public class OrdersServicesDAOImpl implements OrdersServicesDAO{
	private static Logger log=Logger.getLogger(OrdersServicesDAOImpl.class);
	@Override
	public List<Orders> VielAllOrders(int customerId) throws BusinessException {
		Orders orders=null;
		List<Orders> ordersList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="SELECT id,productId,status,customerId,amount FROM quickshop.orders where customerId=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			
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
			if(ordersList.size()>0) {
				String sql1="delete from cart where customerId=?";
				PreparedStatement preparedStatement1=connection.prepareStatement(sql1);
				preparedStatement1.setInt(1, customerId);
				
				preparedStatement1.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact Admin");
		}
		return ordersList;
	}
	@Override
	public int updateTheOrderStatus(int orderId,int customerId) throws BusinessException {
		int success=0;
		try(Connection connection=MySqlDbConnection.getconnection()){
			String sql="update orders set status='Delivered' where id=? and customerId=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, orderId);
			preparedStatement.setInt(2, customerId);
			
			success=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact Admin");
		}
		return success;
	}
	
	

}
