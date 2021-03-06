package com.coffeeshop.api.domain;

import javax.persistence.*;

@Entity
@Table(name = "Orderline")
public class Orderline {

	@Id
	@GeneratedValue
	private int id;
	private int quantity;
	@OneToOne(cascade = CascadeType.ALL)
	private Product product;
	@ManyToOne
	private Order order;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getSubtotal() {
		return quantity * product.getPrice();
	}

	public double getPrice() {
		return product.getPrice();
	}

}
