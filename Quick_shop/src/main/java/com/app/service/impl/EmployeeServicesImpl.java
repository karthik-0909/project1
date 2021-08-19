package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.EmployeeServicesDAO;
import com.app.dao.impl.EmployeeServicesDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Orders;
import com.app.model.Product;
import com.app.service.EmployeeServices;

public class EmployeeServicesImpl implements EmployeeServices{
    private EmployeeServicesDAO employeeServicesDAO=new EmployeeServicesDAOImpl();
    Product product=null;
	
    @Override
	public Product addNewProduct(int id, String name, double price, String manufacturerName, String category) throws BusinessException {
		if(id>0 && name.length()>0 && price>0 && manufacturerName.length()>0 && category.length()>0) {
			product=employeeServicesDAO.addNewProduct(id, name, price, manufacturerName, category);
		}
		else {
			throw new BusinessException("please enter valid details");
		}
		return product;
	}
	
	
	@Override
	public int deleteProduct(int id) throws BusinessException {
		int success=0;
		if(id>0) {
			success=employeeServicesDAO.deleteProduct(id);
		}else {
			throw new BusinessException("Please enter a valid product id");
		}
		return success;
	}
	
	
	@Override
	public int UpdateStatusOfOrderToShipped(int orderId) throws BusinessException {
		int pass=0;
		if(orderId>0) {
			pass=employeeServicesDAO.UpdateStatusOfOrderToShipped(orderId);
		}else {
			throw new BusinessException("Please enter a valid orderId");
		}
		return pass;
	}
	
	
	@Override
	public List<Orders> viewOrders(String status) throws BusinessException {
		List<Orders> ordersList= new ArrayList<>();
		if(status.length()>0) {
			ordersList=employeeServicesDAO.viewOrders(status);
		}
		return ordersList;
	}
	
	
	@Override
	public Customer viewCustomerById(int customerId) throws BusinessException {
		Customer customer=null;
		if(customerId>0) {
			customer=employeeServicesDAO.viewCustomerById(customerId);
		}else {
			throw new BusinessException("Please enter a valid customerId");
		}
		return customer;
	}
	
	
	@Override
	public List<Customer> viewCustomerByName(String customerName) throws BusinessException {
		List<Customer> customerList= new ArrayList<>();
		if(customerName.length()>0) {
			customerList=employeeServicesDAO.viewCustomerByName(customerName);
		}else {
			throw new BusinessException("Please enter a valid customerName");
		}
		return customerList;
	}

}
