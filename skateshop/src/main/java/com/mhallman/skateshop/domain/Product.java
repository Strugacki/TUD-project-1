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
		this.product_name=product_name;
		this.brand_name=brand_name;
		this.price=price;
	}
	
	
	
	
}
