package com.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.CustomerLoginService;
import com.app.service.EmployeeLoginService;
import com.app.service.EmployeeServices;
import com.app.service.RegistrtionService;
import com.app.service.impl.CustomerLoginServiceImpl;
import com.app.service.impl.EmployeeLoginServiceImpl;
import com.app.service.impl.EmployeeServicesImpl;
import com.app.service.impl.RegistrationServiceImpl;

class TestQuickShop {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	void testRegistration() {
//		RegistrtionService registrtionService=new RegistrationServiceImpl();
//		try {
//			assertEquals(1, registrtionService.CreateNewCustomer("vivek","B", "vivek@gmail.com", "Vivek123"));
//		}catch(BusinessException e) {
//			System.out.println((e.getMessage()));
//			
//		}
//	}

	@Test
	void testLoginService() throws BusinessException {
		CustomerLoginService customerLoginService=new CustomerLoginServiceImpl();
		Customer customer= new Customer(16,"rakesh","rakesh@gmail.com","Rakesh12",0,0);
			assertEquals(customer, customerLoginService.loginByMail("rakesh@gmail.com", "Rakesh12"));
	}
//	@Test
//	void testEmployeeLoginService() {
//		EmployeeLoginService employeeLoginService=new EmployeeLoginServiceImpl();
//		assertEquals(true, employeeLoginService.employeeLogin("employee", "emp1234"));
//	}
//	
//	
//	@Test
//	void testEmployeeLoginServiceDeleteProduct() {
//		EmployeeServices employeeServices=new EmployeeServicesImpl();
//		try {
//			assertEquals(1, employeeServices.deleteProduct(7));
//		} catch (BusinessException e) {
//			
//			System.out.println((e.getMessage()));
//		}
//	}
//	@Test
//	void testEmployeeLoginServiceStatusofProduct() {
//		EmployeeServices employeeServices=new EmployeeServicesImpl();
//		try {
//			assertEquals(1, employeeServices.UpdateStatusOfOrderToShipped(4));
//		} catch (BusinessException e) {
//			
//			System.out.println((e.getMessage()));
//		}
//	}
////	
////	@Test
////	void testProductViewService() {
////		
////		ProductViewService productViewService=new ProductViewServiceImpl();
////		Product product=new Product(2,"NikeSneakers",3000.0,"Nike","Shoes");
////		
////		try {
////			assertEquals(product, productViewService.viewProductById(2));
////		} catch (BusinessException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////	}
//	
//	
}
