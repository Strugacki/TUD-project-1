package com.mhallman.skateshop.domain;

public class Client {

	
	/**
	 * Initialization of variables used in Client class
	 */
	private long id_client;
	private String first_name;
	private String second_name;
	private long phone_number;
	
	

	/**
	 * Basic constructor for Client class
	 */
	public Client(){
		
	}
	
	/**
	 * Advanced constructor for Client class
	 * @param first_name
	 * @param second_name
	 * @param phone_nuber
	 */
	public Client(String first_name, String second_name, long phone_number){
		super();
		this.setFirst_name(first_name);
		this.setSecond_name(second_name);
		this.phone_number=phone_number;
	}

	/**
	 * @return the id_client
	 */
	public long getId_client() {
		return this.id_client;
	}

	/**
	 * @param id_client the id_client to set
	 */
	public void setId_client(long id_client) {
		this.id_client = id_client;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the second_name
	 */
	public String getSecond_name() {
		return second_name;
	}

	/**
	 * @param second_name the second_name to set
	 */
	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}
	
	
	/**
	 * @return the phone_number
	 */
	public long getPhone_number() {
		return phone_number;
	}

	
	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	
	
	
	
	
	
}
