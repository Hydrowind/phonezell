package com.entity;

import java.util.ArrayList;

public class Address {
	private int address_id;
	private String province;
	private String city;
	private String details;
	private double latitude;
	private double longitude;
	public User user;
	public ArrayList<Invoice> invoice = new ArrayList<Invoice>();

	public int getAddressID() {
		return address_id;
	}

	public void setAddressID(int address_id) {
		this.address_id = address_id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(ArrayList<Invoice> invoice) {
		this.invoice = invoice;
	}
}