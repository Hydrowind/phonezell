package com.entity;

import java.util.ArrayList;

public class Shipment {
	private int shipment_id;
	private String name;
	private String service;
	public ArrayList<Invoice> invoice = new ArrayList<Invoice>();

	public int getShipmentID() {
		return shipment_id;
	}

	public void setShipmentID(int shipment_id) {
		this.shipment_id = shipment_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public ArrayList<Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(ArrayList<Invoice> invoice) {
		this.invoice = invoice;
	}
}