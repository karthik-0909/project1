package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface RegistrtionService {
	
	public int CreateNewCustomer(String name,String mail,String password) throws BusinessException;

}
