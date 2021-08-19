package com.app.service.impl;

import com.app.dao.RegistrationDAO;
import com.app.dao.impl.RegistrationDAOImpl;
import com.app.exception.BusinessException;
import com.app.service.RegistrtionService;

public class RegistrationServiceImpl implements RegistrtionService{
	private RegistrationDAO registrationDAO=new RegistrationDAOImpl();

	@Override
	public int CreateNewCustomer(String name,String mail,String password) throws BusinessException {
		int s=0;
		if(name.length()!=0 && name.matches("[a-zA-Z]{3,20}")) {
			
			if(mail.matches("[a-z0-9]{5,20}[@gmail.com]{10}")) {
				
				if(password.matches("[A-Z]{1}[a-zA-Z0-9]{7,30}")) {
					s=registrationDAO.CreateNewCustomer(name, mail, password);
				}
				else {
					throw new BusinessException("Invalid password... "+password+ 
							" /n1.Password must be of length 8 \n2.First letter must be in uppercase"
							+ "\n3.No special characters are allowed");
					}
			}
			else {
				throw new BusinessException("Invalid Mail Address "+mail+"\nOnly gmail address can be used");
				}
		}
		else {
			throw new BusinessException("Invalid name"+name+"\n Name should be of minimum 3 characters"
					+"\nAnd numbers and special characters are not allowed");
			}
		
		return s;
	}

}
