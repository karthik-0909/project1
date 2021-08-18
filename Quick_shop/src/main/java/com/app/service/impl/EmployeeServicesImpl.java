package com.app.service.impl;

import com.app.dao.EmployeeServicesDAO;
import com.app.dao.impl.EmployeeServicesDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.service.EmployeeServices;

public class EmployeeServicesImpl implements EmployeeServices{
    private EmployeeServicesDAO employeeServicesDAO=new EmployeeServicesDAOImpl();
    Product p=null;
	@Override
	public Product addNewProduct(int id, String name, double price, String manufacturerName, String category) throws BusinessException {
		if(id>0 && name.length()>0 && price>0 && manufacturerName.length()>0 && category.length()>0) {
			p=employeeServicesDAO.addNewProduct(id, name, price, manufacturerName, category);
		}
		else {
			throw new BusinessException("please enter valid details");
		}
		return p;
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

}