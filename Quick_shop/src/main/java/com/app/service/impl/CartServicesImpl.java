package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.CartServicesDAO;
import com.app.dao.impl.CartServicesDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.service.CartServices;

public class CartServicesImpl implements CartServices{
	private CartServicesDAO cartServicesDAO=new CartServicesDAOImpl();

	@Override
	public List<Product> ViewCart(int customerId) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		if(customerId>0){
			productList=cartServicesDAO.ViewCart(customerId);
		}else {
			throw new BusinessException(customerId+"  is invalid,please enter a valid id  and try again...");
		}
		return productList;
	}

	@Override
	public int addItemToCart(int customerId, int productId) throws BusinessException {
		int success=0;
		if(customerId>0 && productId>0) {
			success=cartServicesDAO.addItemToCart(customerId, productId);
			
		}else { 
			throw new BusinessException(productId+"  is invalid,please enter a valid id  and try again...");
		}
		return success;
	}

	@Override
	public int deleteItemFromCart(int productId) throws BusinessException {
		int success=0;
		if(productId>0) {
			success=cartServicesDAO.deleteItemFromCart(productId);
		}else { 
			throw new BusinessException(productId+"  is invalid,please enter a valid id  and try again...");
		}
		return success;
	}

	@Override
	public int placeAnOrder(List<Product> cartList, int customerId) throws BusinessException {
		int success=0;
		if(cartList.size()>0 && customerId>0) {
			success=cartServicesDAO.placeAnOrder(cartList, customerId);
		}else {
			throw new BusinessException("check your cart and try again...");
		}
		return success;
	}
	

}
