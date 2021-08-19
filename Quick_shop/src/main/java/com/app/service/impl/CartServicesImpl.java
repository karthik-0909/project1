package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.CartServicesDAO;
import com.app.dao.impl.CartServicesDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.service.CartServices;

public class CartServicesImpl implements CartServices{
	CartServicesDAO cartServicesDAO=new CartServicesDAOImpl();

	@Override
	public List<Product> ViewCart(int customerId) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		if(customerId>0){
			productList=cartServicesDAO.ViewCart(customerId);
		}
		return productList;
	}
	

}
