package com.mhallman.skateshop.domain;

public class Product {

	/**
	 * Initialization of variables used in Product class
	 */
	private long id_product;
	private String product_name;
	private String brand_name;
	private double price;
	
	
	/**
	 * Basic constructor for Product class
	 */
	public Product(){
		
	}
	
	/**
	 * Advanced constructor for Product class
	 * @param product_name
	 * @param brand_name
	 * @param price
	 */
	public Product(String product_name, String brand_name, double price){
		super();
		this.setProduct_name(product_name);
		this.setBrand_name(brand_name);
		this.setPrice(price);
	}

	/**
	 * @return the id_product
	 */
	public long getId_product() {
		return id_product;
	}

	/**
	 * @param id_product the id_product to set
	 */
	public void setId_product(long id_product) {
		this.id_product = id_product;
	}

	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}

	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	/**
	 * @return the brand_name
	 */
	public String getBrand_name() {
		return brand_name;
	}

	/**
	 * @param brand_name the brand_name to set
	 */
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
