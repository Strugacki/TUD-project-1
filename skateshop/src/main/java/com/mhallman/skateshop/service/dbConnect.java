package com.mhallman.skateshop.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnect {

	/**
	 * Initialization of variables used in dbConnect class
	 */
	private Connection conn;
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	
	/**
	 * Basic constructor for dbConnect class
	 */
	public dbConnect(){
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("Connection problem appeared!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Method returning Connection 
	 * @return
	 */
	public Connection getConnection(){
		return conn;
	}
	
	
}
