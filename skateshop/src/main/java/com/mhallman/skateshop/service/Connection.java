package com.mhallman.skateshop.service;

import java.sql.DriverManager;
import java.sql.SQLException;



public class Connection {

	/**
	 * Initialization of variables used in Connection class
	 */
	private java.sql.Connection conn;
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	
	/**
	 * Basic constructor for Connection class
	 */
	public Connection(){
		
			try {
				conn = DriverManager.getConnection(url);
			} catch (SQLException e) {
				System.out.println("Connection problems");
				e.printStackTrace();
			}
	}
	
	java.sql.Connection getConnection(){
		return conn;
		
	}
	
	
	
}
