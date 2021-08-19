package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Orders;

public interface OrdersServicesDAO {
	
	public List<Orders> VielAllOrders(int customerId) throws BusinessException;
	
	public int updateTheOrderStatus(int orderId,int customerId) throws BusinessException;

}
