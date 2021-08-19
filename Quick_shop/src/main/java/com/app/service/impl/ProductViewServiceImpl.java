package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.ProductViewServiceDAO;
import com.app.dao.impl.ProductViewServiceDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.service.ProductViewService;

public class ProductViewServiceImpl implements ProductViewService{
	private ProductViewServiceDAO productViewServiceDAO=new ProductViewServiceDAOImpl();
	Product product=null;
	
	@Override
	public Product viewProductById(int id) throws BusinessException {
		if(id>0) {
			product=productViewServiceDAO.viewProductById(id);
		}else {
			throw new BusinessException(id+" id is not valid, please enter a valid id and try again..");
		}
		return product;
	}
	
	@Override
	public List<Product> viewProductByName(String name) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		if(name.length()>0) {
			productList=productViewServiceDAO.viewProductByName(name);
		}else {
			throw new BusinessException(name+" productName is invalid, Please enter a valid name and try again...");
		}
		return productList;
	}

	@Override
	public List<Product> viewProductByManufactureName(String manuafturerName) throws BusinessException{
		List<Product> productList=new ArrayList<>();
		if(manuafturerName.length()>0) {
			productList=productViewServiceDAO.viewProductByManufactureName(manuafturerName);
		}else {
			throw new BusinessException(manuafturerName+"  is invalid, Please enter a valid manufacturername and try again...");
		}
		return productList;
	}

	@Override
	public List<Product> viewProductByCategory(String category) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		if(category.length()>0) {
			productList=productViewServiceDAO.viewProductByCategory(category);
		}else {
			throw new BusinessException(category+" is invalid, Please enter a valid category type and try again...");
		}
		return productList;
	}

	@Override
	public List<Product> viewProductByPrice(double price) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		if(price>0 && price<Double.MAX_VALUE) {
			productList=productViewServiceDAO.viewProductByPrice(price);
		}else {
			throw new BusinessException(price+" is invalid please enter a valid price and try again...");
		}
		
		return productList;
	}

}
