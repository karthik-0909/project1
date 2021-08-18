package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface EmployeeServices {
	
	
	public Product addNewProduct(int id,String name,double price,String manufacturerName,String category) throws BusinessException;
	
	public int deleteProduct(int id) throws BusinessException;	
	
}
