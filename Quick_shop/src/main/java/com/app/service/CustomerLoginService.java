package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerLoginService {
	
	public Customer loginByMail(String mail,String password) throws BusinessException;

}
