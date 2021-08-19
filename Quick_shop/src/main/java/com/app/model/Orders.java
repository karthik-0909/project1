package com.app.model;

public class Orders {
	
	private int id;
	private int productId;
	private String status;
	private int customerId;
	private double amount;
	
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", productId=" + productId + ", status=" + status + ", customerId=" + customerId
				+ ", amount=" + amount + "]";
	}
	
	

}
