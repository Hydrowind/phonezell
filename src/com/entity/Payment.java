package com.entity;

import java.util.ArrayList;

public class Payment {
	private int payment_id;
	private String name;
	private String type;
	public ArrayList<Invoice> invoice = new ArrayList<Invoice>();

	public int getPaymentID() {
		return payment_id;
	}

	public void setPaymentID(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(ArrayList<Invoice> invoice) {
		this.invoice = invoice;
	}
}