package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Orders;
import com.app.model.Product;

public interface EmployeeServices {
	
	
	public Product addNewProduct(int id,String name,double price,String manufacturerName,String category) throws BusinessException;
	
	public int deleteProduct(int id) throws BusinessException;
	
	public int UpdateStatusOfOrderToShipped(int orderId)throws BusinessException;
	
	public List<Orders> viewOrders(String status)throws BusinessException;
	
	public Customer viewCustomerById(int customerId) throws BusinessException;
	
	public List<Customer> viewCustomerByName(String customerName) throws BusinessException;
}
