package com.app.service;

import com.app.exception.BusinessException;

public interface RegistrtionService {
	
	public int CreateNewCustomer(String name,String lastName,String mail,String password) throws BusinessException;

}
