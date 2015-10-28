package com.mhallman.skateshop.domain;

public class ProductPurchase {

	/**
	 * Initialization of variables used in ProductPurchase class
	 */
	private long id_product;
	private long id_purchase;
	private int quantity=0;
	private double summary=0;
	
	
	public ProductPurchase(){
		
	}
	
	public ProductPurchase(long id_product, long id_purchase, int quantity, double summary){
		this.id_product=id_product;
		this.id_purchase=id_purchase;
		this.quantity=quantity;
		this.summary=summary;
	}
	
	
}
