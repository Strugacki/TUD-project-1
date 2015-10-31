package com.mhallman.skateshop.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mhallman.skateshop.domain.Purchase;
import com.mhallman.skateshop.domain.Product;
import com.mhallman.skateshop.service.ClientManager;
import com.mhallman.skateshop.service.PurchaseManager;
import com.mhallman.skateshop.service.ProductManager;

public class ProductPurchaseManagerTest {

	private ProductManager prm = new ProductManager();
	private PurchaseManager pum = new PurchaseManager();
	private final static String DATE="06-10-1994";
	private final static String FIRST_NAME="Adam";
	private final static String SECOND_NAME="Kowalski";
	private final long PHONE_NUMBER=782694466;
	private final static String FIRST_NAME2="Bolek";
	private final static String SECOND_NAME2="Lolek";
	private final long PHONE_NUMBER2=504683163;
	
	
}
