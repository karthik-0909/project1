package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ProductViewService {
	
	public Product viewProductById(int id) throws BusinessException;
	
	public List<Product> viewProductByName(String name)throws BusinessException;
	
	public List<Product> viewProductByManufactureName(String manuafturerName) throws BusinessException;
	
	public List<Product> viewProductByCategory(String category) throws BusinessException;
	
	public List<Product> viewProductByPrice(double price) throws BusinessException;

}
