package com.entity;

public class Invoice {
	private int invoice_id;
	private String transaction_no;
	private String status = "waiting for approval";
	public Address address;
	public Payment payment;
	public Shipment shipment;
	public OrderCart cart;

	public int getInvoiceID() {
		return invoice_id;
	}

	public void setInvoiceID(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public String getTransactionNo() {
		return transaction_no;
	}

	public void setTransactionNo(String transaction_no) {
		this.transaction_no = transaction_no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public OrderCart getCart() {
		return cart;
	}

	public void setCart(OrderCart cart) {
		this.cart = cart;
	}
}