package com.mhallman.skateshop.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.mhallman.skateshop.service.dbConnect;



public class dbConnectTest {

	dbConnect conn = new dbConnect();
	
	@Test
	public void checkConnection(){
		assertNotNull(conn.getConnection());
	}
	
	
}
