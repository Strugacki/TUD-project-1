package com.mhallman.skateshop.domain;

public class Purchase {

	private long id_purchase;
	private long id_client;
	private String date;
	
	
	/**
	 * Basic constructor for Client class
	 */
	public Purchase(){
		
	}
	
	
	/**
	 * Advanced constructor for Purchase class
	 * @param id_client
	 * @param date
	 */
	public Purchase(long id_client,String date){
		super();
		this.setId_client(id_client);
		this.setDate(date);
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
	 * @return the id_client
	 */
	public long getId_client() {
		return id_client;
	}


	/**
	 * @param id_client the id_client to set
	 */
	public void setId_client(long id_client) {
		this.id_client = id_client;
	}


	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
