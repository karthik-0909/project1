package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Orders;
import com.app.model.Product;
import com.app.service.CartServices;
import com.app.service.CustomerLoginService;
import com.app.service.EmployeeLoginService;
import com.app.service.EmployeeServices;
import com.app.service.OrdersServices;
import com.app.service.ProductViewService;
import com.app.service.RegistrtionService;
import com.app.service.impl.CartServicesImpl;
import com.app.service.impl.CustomerLoginServiceImpl;
import com.app.service.impl.EmployeeLoginServiceImpl;
import com.app.service.impl.EmployeeServicesImpl;
import com.app.service.impl.OrdersServicesImpl;
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
							log.info("3.view  cart");
							log.info("4.logout");
							log.info("Enter your choice");
							try {
								s=Integer.parseInt(scanner.nextLine());
							}catch(NumberFormatException e) {
							}
							switch(s) {
							case 1:
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
									}catch(NumberFormatException e){}
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
									}catch (BusinessException e) {
										log.warn(e.getMessage());
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
										log.warn(e.getMessage());
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
										}else {
											log.warn("No produsts with the category type "+category);
										}
									} catch (BusinessException e) {
										log.warn(e.getMessage());
									}
									break;
								case 5:
									List<Product> priceList=new ArrayList<>();
									log.info("enter product price to view products");
									double price=0;
									try {
									price=Double.parseDouble(scanner.nextLine());
									}catch(NumberFormatException e) {}
									try {
										priceList=productViewService.viewProductByPrice(price);
										if(priceList!=null && priceList.size()>0) {
											log.info("Products with the price "+price+" are shown below");
											for(Product p1:priceList) {
												log.info(p1);
											}
										}else {
											log.warn("No produsts with the price "+price);
										}
										
									} catch (BusinessException e) {
										log.warn(e.getMessage());
									}
									break;
								case 6:log.info("Loading menu \n Succeesfull");
									break;
								default:log.info("please make a choice between 1-6 and try again...");
									break;
								}
								}while(choice!=6);
								break;
							case 2:
								OrdersServices ordersServices=new OrdersServicesImpl();
								int viewOption=0;
								log.info("1.View all orders");
								log.info("2.Update the status of an order");
								try {
									viewOption=Integer.parseInt(scanner.nextLine());
								}catch(NumberFormatException e) {
									log.warn(e.getMessage());
								}
								switch(viewOption) {
								case 1:
									List<Orders> viewOrdersList=new ArrayList<>();
									viewOrdersList=ordersServices.VielAllOrders(customer.getId());
									if(viewOrdersList.size()>0) {
										log.info(customer.getName()+" your previous orders are");
										for(Orders o:viewOrdersList)
											log.info(o);
									}else {
										log.warn("No previous orders , Go make an order today");
									}
									break;
								case 2:
									int orderId=0;
									log.info("Please enter order id to update the status to delivered");
									try {
										orderId=Integer.parseInt(scanner.nextLine());
									}catch(NumberFormatException e){
										log.warn(e.getMessage());
									}
									int success=ordersServices.updateTheOrderStatus(orderId,customer.getId());
									if(success==1) {
										log.info("OrderStatus of id "+orderId+" updated successfully");
									}else {
										log.warn("order status update unsuccessfull, Please check ur orderId and try again...");
									}
									
									break;
								}
								break;
							case 3:
								List<Product> cartList=new ArrayList<>();
								CartServices cartServices=new CartServicesImpl();
								log.info("Welcome to your cart");
								log.info("-------------------------");
								int customerId=customer.getId();
								
								cartList=cartServices.ViewCart(customerId);
								if(cartList.size()>0) {
									log.info("Cart loaded successfully");
									log.info(cartList.size()+" items in your cart");
									for(Product p1:cartList)
										log.info(p1);
									
								}else {
									log.warn("your cart is empty");
								}
								int cartOption=0;
								log.info("\n1.add item to cart");
								log.info("2.delete item from cart");
								log.info("3.Place an order");
								try {
									cartOption=Integer.parseInt(scanner.nextLine());
								}catch(NumberFormatException e){
								}
								switch(cartOption) {
								case 1:
								 	log.info("Please enter the product id to add it  to cart");
								 	int productId=0;
								 	try {
								 		productId=Integer.parseInt(scanner.nextLine());
								 	}catch(NumberFormatException e) {
								 		log.warn(e.getMessage());
								 	}
								 	try {
								 	int success=cartServices.addItemToCart(customerId,productId);
								 	
								 		if(success==1) {
								 			log.info("Product added succeessfully to cart");
								 		}else {
								 			log.info("Adding product unsucceessfull , please try again");
								 		}
								 	}catch(BusinessException e) {
								 		log.warn(e.getMessage());
								 	}
									break;
								case 2:
									log.info("Please enter the product id to delete it  to cart");
								 	int deleteProductId=0;
								 	try {
								 		deleteProductId=Integer.parseInt(scanner.nextLine());
								 	}catch(NumberFormatException e) {
								 		log.warn(e.getMessage());
								 	}
								 	int success=cartServices.deleteItemFromCart(deleteProductId);
								 	if(success==1) {
							 			log.info("Product deleted succeessfully to cart");
							 		}else {
							 			log.info("Deleting product unsucceessfull , please try again");
							 		}
									break;
								case 3:
									int orderOption=0;
									do {
									log.info("1.place the order");
									log.info("2.go back");
									try {
										orderOption=Integer.parseInt(scanner.nextLine());
									}catch(NumberFormatException e){
										log.warn(e.getMessage());
									}
									switch(orderOption) {
									case 1:
										int orderPlaced=cartServices.placeAnOrder(cartList,customer.getId());
										if(orderPlaced==1) {
											log.info(" Order placed succeessfully");
										}else {
											log.info("Order was unsucceessfull , please try again");
										}
										break;
									case 2:log.info("loading main menu");
										break;
									default:log.warn("please enter a valid option  between 1-2 and try again ...");
										break;
									}
								}while(orderOption!=2);
									break;
								default:log.warn("please enter a valid option between 1-3");
								break;
								}
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
					log.warn(e.getMessage());
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
				log.info("6.search  for customers");
				log.info("7.back to main menu");
				log.info("please choose an option from 1-7...");
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
							log.warn(e.getMessage());
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
						log.warn(e.getMessage());
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
							log.warn(e.getMessage());
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
							log.warn(e.getMessage());
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
							}else {
								log.warn("No produsts with the category type "+category);
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
						break;
					case 5:
						List<Product> priceList=new ArrayList<>();
						log.info("enter product price to view products");
						double price=0;
						try {
						price=Double.parseDouble(scanner.nextLine());
						}catch(NumberFormatException e) {}
						try {
							priceList=productViewService.viewProductByPrice(price);
							if(priceList!=null && priceList.size()>0) {
								log.info("Products with the price "+price+" are shown below");
								for(Product p1:priceList) {
									log.info(p1);
								}
							}else {
								log.warn("No produsts with the price "+price);
							}
							
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
						break;
					case 6:log.info("Loading menu \n Succeesfull");
							break;
					default:log.info("please make a choice between 1-6 and try again...");
						break;
					}
					}while(choice!=6);
					break;
				case 4:
					int statusOfId=0;
					log.info("Please enter order id to update status to Shipped");
					try {
						statusOfId=Integer.parseInt(scanner.nextLine());
					}catch(NumberFormatException e) {
						log.warn(e.getMessage());
					}
					try {
						int success=employeeServices.UpdateStatusOfOrderToShipped(statusOfId);
						if(success==1) {
							log.info("OrderStatus of id "+statusOfId+" is successfully updated");
						}else {
							log.warn("StatusUpdate unsuccessfull,please enter avalid order id and try again...");
						}
					} catch (BusinessException e) {
						log.warn(e.getMessage());
					}
					break;
				case 5:
					List<Orders> ordersList= new ArrayList<>();
					int orderViewOption=0;
					log.info("\n1.View new orders");
					log.info("2.view Shipped orders");
					log.info("3.view Delivered orders");
					try {
						orderViewOption=Integer.parseInt(scanner.nextLine());
					}catch(NumberFormatException e) {
						log.warn(e.getMessage());
					}
					switch(orderViewOption) {
					case 1:
						String orderStatus1="Ordered";
						try {
							ordersList=employeeServices.viewOrders(orderStatus1);
							if(ordersList.size()>0) {
								for(Orders o:ordersList)
									log.info(o);
							}else {
								log.warn("No orders to display");
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
						break;
					case 2:String orderStatus2="Shipped";
						try {
							ordersList=employeeServices.viewOrders(orderStatus2);
							if(ordersList.size()>0) {
								for(Orders o:ordersList)
									log.info(o);
							}else {
								log.warn("No orders to display");
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
						break;
					case 3:String orderStatus3="Delivered";
						try {
							ordersList=employeeServices.viewOrders(orderStatus3);
							if(ordersList.size()>0) {
								for(Orders o:ordersList)
									log.info(o);
							}else {
								log.warn("No orders to display");
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
						break;
					}
					break;
				case 6:
					int searchOption=0;
					log.info("\n1.Search customer by customerId");
					log.info("2.Search customer by customerName");
					try {
						searchOption=Integer.parseInt(scanner.nextLine());
					}catch(NumberFormatException e) {
						log.warn(e.getMessage());
					}
					switch(searchOption){
					case 1:int searchCustomerId=0;
						log.info("Please enter customerId to get customer Details");
						try {
							searchCustomerId=Integer.parseInt(scanner.nextLine());
						}catch(NumberFormatException e) {
							log.warn(e.getMessage());
						}
						try {
							Customer customer=employeeServices.viewCustomerById(searchCustomerId);
							if(customer!=null) {
								log.info(customer);
							}else {
								log.warn("No customers with id "+searchCustomerId+", Please check id and try again...");
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
						break;
					case 2:
						List<Customer> customerList= new ArrayList<>();
						log.info("Please enter customerName to get customer Details");
						String customerName=scanner.nextLine();
						try {
							customerList=employeeServices.viewCustomerByName(customerName);
							if(customerList.size()>0) {
								for(Customer c:customerList)
									log.info(c);
							}else {
								log.warn("No customers with name "+customerName+", Please check name and try again...");
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
						break;
					}
					break;
				case 7:log.info("Loading main menu \nSuccessfull");
					break;
				default:log.info("please make a choice between 1-6 and try again...");
					break;
				}
			}else {
				log.warn("Login unsuccessfull \n Try again");
				op=7;
			}
			
			}while(op!=7);
			break;
		case 4:log.info("Thank u for using the Qucik Shop app");
			break;
		default :log.warn("plese choose a valid option from 1-4 and retry...");
			break;
		
		}
		}while(option!=4);

	}

}
