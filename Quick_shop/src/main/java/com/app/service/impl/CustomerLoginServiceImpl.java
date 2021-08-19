package com.app.service.impl;

import com.app.dao.LoginDAO;
import com.app.dao.impl.LoginDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.CustomerLoginService;

public class CustomerLoginServiceImpl  implements CustomerLoginService{
	private LoginDAO loginDAO= new LoginDAOImpl();

	@Override
	public Customer loginByMail(String mail,String password) throws BusinessException {
		Customer customer=null;
		
		if(mail.matches("[a-z0-9]{5,20}[@gmail.com]{10}")) {
			
			if(password.matches("[A-Z]{1}[a-zA-Z0-9]{7,30}")) {
				
				customer=loginDAO.loginByMail(mail, password);
				
			}
			else {
				throw new BusinessException("Invalid password... "+password+ 
						" /n1.Password must be of length 8 \n2.First letter must be in uppercase"
						+ "\n3.No special characters are allowed");
				}
		}
		else {
			throw new BusinessException("Invalid Mail Address "+mail+"\nGmail address should only contain alphabets and numbers.");
			}
		return customer;
	}

}
