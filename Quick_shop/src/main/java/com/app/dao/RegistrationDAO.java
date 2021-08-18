package com.app.dao;

import com.app.exception.BusinessException;

public interface RegistrationDAO {
	
	public int CreateNewCustomer(String name,String mail,String password) throws BusinessException;

}
