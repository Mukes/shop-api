package com.coffeeshop.api.domain;

import javax.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private String productName;
	private String description;
	private double price;
	@Enumerated(EnumType.STRING)
	private ProductType productType;

	public Product() {
		super(); // default constructor
	}

	public Product(int id) {
		super();
		this.id = id;
		// default constructor
	}

	public Product(String productName, String description, double price, ProductType productType) {
		super();
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.productType = productType;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

}
