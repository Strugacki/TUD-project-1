package com.mhallman.skateshop.domain;

public class Client {

	
	/**
	 * Initialization of variables used in Client class
	 */
	private long id_product;
	private String product_name;
	private String brand_name;
	private double price;
	
	
	public Client(){
		
	}
	
	public Client(long id, String product_name, String brand_name, double price){
		super();
		this.id_product=id;
		this.product_name=product_name;
		this.brand_name=brand_name;
		this.price=price;
	}
	
	
	
	
	
	
}
