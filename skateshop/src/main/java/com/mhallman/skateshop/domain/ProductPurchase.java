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
		this.setId_product(id_product);
		this.setId_purchase(id_purchase);
		this.setQuantity(quantity);
		this.setSummary(summary);
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
	 * @return the id_purchase
	 */
	public long getId_purchase() {
		return id_purchase;
	}

	/**
	 * @param id_purchase the id_purchase to set
	 */
	public void setId_purchase(long id_purchase) {
		this.id_purchase = id_purchase;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the summary
	 */
	public double getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(double summary) {
		this.summary = summary;
	}
	
	
}
