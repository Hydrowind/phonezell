package com.entity;

public class OrderCartProduct {
	private int quantity = 1;
	public OrderCart cart;
	public Product product;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderCart getCart() {
		return cart;
	}

	public void setCart(OrderCart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}