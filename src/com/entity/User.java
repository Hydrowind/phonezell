package com.entity;

import java.util.ArrayList;
import java.util.Date;

public class User {
	private int user_id;
	private String email;
	private String password;
	private String fullname;
	private Date dob;
	private int gender = 1;
	private String phone_number;
	private String photo_url;
	private Date date_joined;
	private int role;
	public ArrayList<EWallet> EWallet = new ArrayList<EWallet>();
	public ArrayList<Address> address = new ArrayList<Address>();
	public ArrayList<OrderCart> orderCart = new ArrayList<OrderCart>();

	public int getUserID() {
		return user_id;
	}

	public void setUserID(int user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phone_number;
	}

	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPhotoUrl() {
		return photo_url;
	}

	public void setPhotoUrl(String photo_url) {
		this.photo_url = photo_url;
	}

	public Date getDateJoined() {
		return date_joined;
	}

	public void setDateJoined(Date date_joined) {
		this.date_joined = date_joined;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public ArrayList<EWallet> getEWallet() {
		return EWallet;
	}

	public void setEWallet(ArrayList<EWallet> eWallet) {
		EWallet = eWallet;
	}

	public ArrayList<Address> getAddress() {
		return address;
	}

	public void setAddress(ArrayList<Address> address) {
		this.address = address;
	}

	public ArrayList<OrderCart> getOrderCart() {
		return orderCart;
	}

	public void setOrderCart(ArrayList<OrderCart> orderCart) {
		this.orderCart = orderCart;
	}
}