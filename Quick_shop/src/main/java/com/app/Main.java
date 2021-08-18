package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Product;
import com.app.service.CustomerLoginService;
import com.app.service.EmployeeLoginService;
import com.app.service.EmployeeServices;
import com.app.service.ProductViewService;
import com.app.service.RegistrtionService;
import com.app.service.impl.CustomerLoginServiceImpl;
import com.app.service.impl.EmployeeLoginServiceImpl;
import com.app.service.impl.EmployeeServicesImpl;
import com.app.service.impl.ProductViewServiceImpl;
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
					
					log.info("------Login Page------");
					log.info("Enter your gmail address");
					String mail=scanner.nextLine();
					log.info("Enter your password");
					String password=scanner.nextLine();
					do {
					try {
						Customer customer=customerLoginService.loginByMail(mail, password);
						if(customer!=null) {
							int s=0;
							log.info("Login successuful");
							log.info("\nWelcome "+customer.getName()+", get something new today.");
							log.info("1.search products");
							log.info("2.view orders");
							log.info("3.add to cart");
							log.info("4.logout");
							log.info("Enter your choice");
							try {
								s=Integer.parseInt(scanner.nextLine());
							}catch(NumberFormatException e) {
							}
							switch(s) {
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:customer=null;
								log.info("Logout successfull \nLoading main menu");
									goback=1;
									break;
							default:log.info("please enter a valid key between 1-3 and try again...");
								break;
							}
						}
					} catch (BusinessException e) {
						System.out.println(e.getMessage());
						break;
					}
					
				}while(goback!=1);
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
				String mailid=scanner.nextLine();
				log.info("enter your password");
				String password1=scanner.nextLine();
				try {
					succes=registrtionService.CreateNewCustomer(name, mailid, password1);
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
			default:log.warn("Please enter a valid Key from 1-2 .... retry again");
			break;
			}
			}while(loginOption!=2);
			
			break;
		case 3:
			EmployeeLoginService employeeLoginService=new EmployeeLoginServiceImpl();
			int op=0;
			log.info("------Welcome to employee login page------");
			log.info("enter Employee username");
			String username=scanner.nextLine();
			log.info("Enter password");
			String Emp_password=scanner.nextLine();
			do {
			if(employeeLoginService.employeeLogin(username, Emp_password)) {
				log.info("Login Successfull");
				log.info("1.Add a new product");
				log.info("2.Delete  a product");
				log.info("3.View products");
				log.info("4.Update the status of order");
				log.info("5.view orders");
				log.info("5.search  for customers ");
				log.info("6.back to main menu");
				log.info("please choose an option from 1-5...");
				try {
				op=Integer.parseInt(scanner.nextLine());
				}catch(NumberFormatException e) {
					log.warn(e.getMessage());
				}
				EmployeeServices employeeServices=new EmployeeServicesImpl();
				switch(op) {
				case 1:
					Product product=null;
					int n=0;
					do {
					log.info("please enter product id");
					int id=0;
					try {
						id=Integer.parseInt(scanner.nextLine());
					}catch(NumberFormatException e) {
						log.warn(e.getMessage());
					}
					log.info("enter product name");
					String name=scanner.nextLine();
					log.info("enter product price");
					double price=Double.parseDouble(scanner.nextLine());
					log.info("enter product manufacturer name");
					String manufacturerName=scanner.nextLine();
					log.info("enter product category");
					String category=scanner.nextLine();
					
					try {
						product=employeeServices.addNewProduct(id, name, price, manufacturerName, category);
						if (product!=null) {
							log.info("product created successfully");
							log.info(product);
							n=1;
						}
					} catch (BusinessException e) {
						System.out.println(e.getMessage());
					}
					}while(n!=1);
					break;
				case 2:
					log.info("Enter product id to delete a product");
					int id=0;
					try {
					id=Integer.parseInt(scanner.nextLine());
					}catch(NumberFormatException e) {
						log.warn(e.getMessage());
					}
					int num;
					try {
						num = employeeServices.deleteProduct(id);
						if (num==1) {
							log.info("product with id "+id+" deleted successfully.");
						}else {
							log.warn("No product with id "+id+" please try  with valid id again...");
						}
					} catch (BusinessException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					ProductViewService productViewService=new ProductViewServiceImpl();
					int choice=0;
					do {
					log.info("\nWelcome to product view menu");
					log.info("1.view product by id");
					log.info("2.view products by name");
					log.info("3.view products by manufacturerName");
					log.info("4.view products by category");
					log.info("5.view products by price");
					log.info("6.Go back to menu");
					log.info("Please choose a choice between 1-6");
					try {
						choice=Integer.parseInt(scanner.nextLine());
					}catch(NumberFormatException e) {
						log.warn(e.getMessage());
					}
					switch(choice) {
					case 1:log.info("Enter product id to view product");
						Product	p=null;
						int productId=0;
						try {
						productId=Integer.parseInt(scanner.nextLine());
						}catch(NumberFormatException e) {
							log.warn(e.getMessage());
						}
						try {
							p=productViewService.viewProductById(productId);
							if(p!=null) {
								log.info("Product details with id "+productId+" is shown below");
								log.info(p);
							}else {
								log.warn("No product with id "+productId+" please try  with valid id again...");
							}
						} catch (BusinessException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 2:
						List<Product> productList=new ArrayList<>();
						log.info("enter product name to view products");
						String productName=scanner.nextLine();
						try {
							productList=productViewService.viewProductByName(productName);
							if(productList!=null && productList.size()>0) {
								log.info("Products with the name "+productName+" are shown below");
								for(Product p1:productList) {
									log.info(p1);
								}
							}else {
								log.warn("No products with the name "+productName);
							}
						} catch (BusinessException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 3:
						List<Product> productListMN=new ArrayList<>();
						log.info("enter product manufacturername to view products");
						String manufacturerName=scanner.nextLine();
						try {
							productListMN=productViewService.viewProductByManufactureName(manufacturerName);
							if(productListMN!=null && productListMN.size()>0) {
								log.info("Products with the manufacturername "+manufacturerName+" are shown below");
								for(Product p1:productListMN) {
									log.info(p1);
								}
							}else {
								log.warn("No products with the manufacturername "+manufacturerName);
							}
						} catch (BusinessException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 4:
						List<Product> categoryList=new ArrayList<>();
						log.info("enter product category type to view products");
						String category=scanner.nextLine();
						try {
							categoryList=productViewService.viewProductByCategory(category);
							if(categoryList!=null && categoryList.size()>0) {
								log.info("Products with the category  type "+category+" are shown below");
								for(Product p1:categoryList) {
									log.info(p1);
								}
							}
						} catch (BusinessException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 5:
						break;
					case 6:log.info("Loading menu \n Succeesfull");
							break;
					default:log.info("please make a choice between 1-6 and try again...");
						break;
					}
					}while(choice!=6);
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:log.info("Loading main menu \nSuccessfull");
					break;
				default:log.info("please make a choice between 1-6 and try again...");
					break;
				}
			}else {
				log.warn("Login unsuccessfull \n Try again");
				op=6;
			}
			
			}while(op!=6);
			break;
		case 4:log.info("Thank u for using the Qucik Shop app");
			break;
		default :log.warn("plese choose a valid option from 1-4 and retry...");
			break;
		
		}
		}while(option!=4);

	}

}
