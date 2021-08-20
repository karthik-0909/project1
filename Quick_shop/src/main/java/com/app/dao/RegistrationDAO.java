package com.app.dao;

import com.app.exception.BusinessException;

public interface RegistrationDAO {
	
	public int CreateNewCustomer(String name,String lastName,String mail,String password) throws BusinessException;

}
