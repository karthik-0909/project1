package com.app;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.CustomerLoginService;
import com.app.service.EmployeeLoginService;
import com.app.service.RegistrtionService;
import com.app.service.impl.CustomerLoginServiceImpl;
import com.app.service.impl.EmployeeLoginServiceImpl;
import com.app.service.impl.RegistrationServiceImpl;



public class Main {
	 private static Logger log=Logger.getLogger(Main.class);

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		log.info("Welcome to Quick Shop App");
		log.info("-----------------------------");
		
		int option=0;
		do {
		log.info("\n------Main menu------");
		log.info("1)Login as Customer");
		log.info("2)Register as New Customer");
		log.info("3)Login as Employee");
		log.info("4)Exit");
		
		try{
			option=Integer.parseInt(scanner.nextLine());
		}catch(NumberFormatException e) {}
		switch(option){
			case 1:
				boolean success=false;
				int goback=0;
				CustomerLoginService customerLoginService= new CustomerLoginServiceImpl();
				do{
					
					log.info("------Login Page------");
					log.info("Enter your gmail address");
					String mail=scanner.nextLine();
					log.info("Enter your password");
					String password=scanner.nextLine();
					
					try {
						Customer customer=customerLoginService.loginByMail(mail, password);
						if(customer!=null) {
							log.info("Login successuful");
							log.info("\nWelcome "+customer.getName()+", get something new today.");
							log.info("1.search products");
							log.info("2.view orders");
							log.info("3.logout");
							log.info("Enter your choice");
							int s=Integer.parseInt(scanner.nextLine());
							switch(s) {
							case 1:
								break;
							case 2:
								break;
							case 3:customer=null;
								log.info("Logout successfull \nLoading main menu");
									goback=1;
									break;
							default:log.info("please enter a valid key between 1-3 and try again...");
								break;
							}
						}else {
							log.info("Gmail or the Password you have entered is wrong, please check and try again...");
						}
					} catch (BusinessException e) {
						System.out.println(e.getMessage());	
					}
					
				}while(goback==1);
			break;
			case 2:
			log.info("------Registration Page------");
		int loginOption=0;
		do {	
		log.info("1.Registration with mail");
			log.info("2.Back to main menu");
			try {
				loginOption=Integer.parseInt(scanner.nextLine());
			}catch(NumberFormatException e) {}
			switch(loginOption) {
			case 1:
				RegistrtionService registrtionService=new RegistrationServiceImpl();
				int succes=0;
				log.info("enter your name");
				String name=scanner.nextLine();
				log.info("Enter your Mail id");
				String mail=scanner.nextLine();
				log.info("enter your password");
				String password=scanner.nextLine();
				try {
					succes=registrtionService.CreateNewCustomer(name, mail, password);
					if(succes==1) {
						log.info("Registration Successfull \nplease login");
						loginOption=2;
					}
				}catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 2:log.info("Loading Main menu \nsuccessfull");
			break;
			default:log.info("Please enter a valid Key from 1-2 .... retry again");
			break;
			}
			}while(loginOption!=2);
			
			break;
//----------------------------------------------------------------------------------------
		case 3:
			EmployeeLoginService employeeLoginService=new EmployeeLoginServiceImpl();
			do {
			log.info("------Welcome to employee login page------");
			log.info("enter Employee username");
			String username=scanner.nextLine();
			log.info("Enter password");
			String Emp_password=scanner.nextLine();
			if(employeeLoginService.employeeLogin(username, Emp_password)) {
				log.info("Login Successfull");
			}else {
				log.warn("Login unsuccessfull");
			}
			
//------------------------------------------------------------------------------
			}while(false);
			break;
		case 4:log.info("Thank u for using the Qucik Shop app");
			break;
		default :log.warn("plese choose a valid option from 1-4 and retry...");
			break;
		
		}
		}while(option!=4);

	}

}
