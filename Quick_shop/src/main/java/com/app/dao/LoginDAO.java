package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface LoginDAO {
	
	public Customer loginByMail(String mail,String password) throws BusinessException;

}
