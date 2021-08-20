package com.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Product;
import com.app.service.CustomerLoginService;
import com.app.service.EmployeeLoginService;
import com.app.service.ProductViewService;
import com.app.service.RegistrtionService;
import com.app.service.impl.CustomerLoginServiceImpl;
import com.app.service.impl.EmployeeLoginServiceImpl;
import com.app.service.impl.ProductViewServiceImpl;
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
//			assertEquals(1, registrtionService.CreateNewCustomer("rakesh","G", "rakesh@gmail.com", "Rakesh12"));
//		}catch(BusinessException e) {
//			e.printStackTrace();
//			
//		}
//	}

	@Test
	void testLoginService() {
		CustomerLoginService customerLoginService=new CustomerLoginServiceImpl();
		Customer customer=null;
		try {
			assertNotEquals(customer, customerLoginService.loginByMail("rakesh@gmail.com", "Rakesh12"));
		} catch (BusinessException e) {
			
			e.printStackTrace();
		}
	}
	@Test
	void testEmployeeLoginService() {
		EmployeeLoginService employeeLoginService=new EmployeeLoginServiceImpl();
		assertEquals(true, employeeLoginService.employeeLogin("employee", "emp1234"));
	}
	
	@Test
	void testProductViewService() {
		
		ProductViewService productViewService=new ProductViewServiceImpl();
		Product product=new Product();
		
		try {
			assertNotEquals(product, productViewService.viewProductById(2));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
