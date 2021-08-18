package com.app.model;

public class Product {
	
	private int id;
	private String name;
	private double price;
	private String manufacturerName;
	private String category;
	
	
	public Product() {
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


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getManufacturerName() {
		return manufacturerName;
	}


	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", manufacturerName=" + manufacturerName
				+ ", category=" + category + "]";
	}


	public Product(int id, String name, double price, String manufacturerName, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.manufacturerName = manufacturerName;
		this.category = category;
	}
	

}
