package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.OrdersServicesDAO;
import com.app.dao.impl.OrdersServicesDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Orders;
import com.app.service.OrdersServices;

public class OrdersServicesImpl implements OrdersServices{
	private OrdersServicesDAO ordersServicesDAO=new OrdersServicesDAOImpl();
	List<Orders> ordersList=new ArrayList<>();
	@Override
	public List<Orders> VielAllOrders(int customerId) throws BusinessException {
		List<Orders> ordersList=new ArrayList<>();
		if(customerId>0) {
			ordersList=ordersServicesDAO.VielAllOrders(customerId);
		}else {
			throw new BusinessException("invalid id please logout and try again....");
		}
		return ordersList;
	}
	@Override
	public int updateTheOrderStatus(int orderId,int customerId) throws BusinessException {
		int success=0;
		if(orderId>0) {
			success=ordersServicesDAO.updateTheOrderStatus(orderId,customerId);
		}else {
			throw new BusinessException("Invalid id please enter a valid order id");
		}
		return success;
	}

}
