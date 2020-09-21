package com.entity;

import java.util.ArrayList;
import java.util.Date;

public class Product {
	private int product_id;
	private String name;
	private String brand;
	private String description;
	private String color;
	private double weight;
	private int condition = 0;
	private String img_url;
	private int stock = 1;
	private double price = 0;
	private Date date_created;
	private Date date_modified;
	private Date date_deleted;
	public Product product;
	public Product modified_from;
	public ArrayList<OrderCartProduct> orderCart_Product = new ArrayList<OrderCartProduct>();

	public int getProductID() {
		return product_id;
	}

	public void setProductID(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	public String getImgUrl() {
		return img_url;
	}

	public void setImgUrl(String img_url) {
		this.img_url = img_url;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDateCreated() {
		return date_created;
	}

	public void setDateCreated(Date date_created) {
		this.date_created = date_created;
	}

	public Date getDateModified() {
		return date_modified;
	}

	public void setDateModified(Date date_modified) {
		this.date_modified = date_modified;
	}

	public Date getDateDeleted() {
		return date_deleted;
	}

	public void setDateDeleted(Date date_deleted) {
		this.date_deleted = date_deleted;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getModifiedFrom() {
		return modified_from;
	}

	public void setModifiedFrom(Product modified_from) {
		this.modified_from = modified_from;
	}

	public ArrayList<OrderCartProduct> getOrderCartProduct() {
		return orderCart_Product;
	}

	public void setOrderCartProduct(ArrayList<OrderCartProduct> orderCart_Product) {
		this.orderCart_Product = orderCart_Product;
	}
}