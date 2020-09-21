package com.entity;

public class EWallet {
	private int ewallet_id;
	private double balance = 0;
	private int pin = 123456;
	public User user;

	public int getEwalletID() {
		return ewallet_id;
	}

	public void setEwalletID(int ewallet_id) {
		this.ewallet_id = ewallet_id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}