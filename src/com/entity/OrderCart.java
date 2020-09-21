package com.entity;

import java.util.ArrayList;
import java.util.Date;

public class OrderCart {
	private int cart_id;
	private Date checkout_date;
	public User user;
	public ArrayList<OrderCartProduct> orderCart_Product = new ArrayList<OrderCartProduct>();
	public Invoice invoice;

	public int getCartID() {
		return cart_id;
	}

	public void setCartID(int cart_id) {
		this.cart_id = cart_id;
	}

	public Date getCheckoutDate() {
		return checkout_date;
	}

	public void setCheckoutDate(Date checkout_date) {
		this.checkout_date = checkout_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<OrderCartProduct> getOrderCartProduct() {
		return orderCart_Product;
	}

	public void setOrderCartProduct(ArrayList<OrderCartProduct> orderCart_Product) {
		this.orderCart_Product = orderCart_Product;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}