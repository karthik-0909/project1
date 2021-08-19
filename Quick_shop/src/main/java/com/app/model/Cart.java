package com.app.model;

public class Cart {
	private int id;
	private int customerId;
	private int productId;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", customerId=" + customerId + ", productId=" + productId + "]";
	}
	
	
}
