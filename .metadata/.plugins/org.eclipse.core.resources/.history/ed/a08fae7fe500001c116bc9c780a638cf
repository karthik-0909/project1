package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface CartServices {
	
	public List<Product> ViewCart(int customerId) throws BusinessException;
	
	public int addItemToCart(int customerId,int productId) throws BusinessException;
	
	public int deleteItemFromCart(int productId) throws BusinessException;
	
	public int placeAnOrder(List<Product> cartList,int customerId) throws BusinessException;

}
