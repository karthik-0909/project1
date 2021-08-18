package com.app.model;

public class Customer {
	private int id;
	private String name;
	private String mail;
	private String  password;
	private long mobileNumber;
	private  int orderId;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mail=" + mail + ", password=" + password + ", mobileNumber="
				+ mobileNumber + ", orderId=" + orderId + "]";
	}

	public Customer(int id, String name, String mail, String password, long mobileNumber, int orderId) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.orderId = orderId;
	}
	
	
	

}
