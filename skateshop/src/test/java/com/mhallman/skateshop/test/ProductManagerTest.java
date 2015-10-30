package com.mhallman.skateshop.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mhallman.skateshop.domain.Product;
import com.mhallman.skateshop.service.ProductManager;

public class ProductManagerTest {

	private ProductManager pm = new ProductManager();
	private final static String PRODUCT_NAME="NERVOUS DECK";
	private final static String BRAND_NAME="NERVOUS";
	private final double PRICE=169.89;
	
	
	@Test
	public void checkAdding(){
		
		Product product = new Product(PRODUCT_NAME,BRAND_NAME,PRICE);
		Product addedProduct;
		pm.deleteProducts();
		assertEquals(1,pm.addProduct(product));
		List<Product> Products = pm.getAllProducts();
		addedProduct = Products.get(0);
		assertEquals(PRODUCT_NAME,addedProduct.getProduct_name());
		assertEquals(BRAND_NAME,addedProduct.getBrand_name());
		assertEquals(PRICE,addedProduct.getPrice(),0.00); //0.00 means tolerance between actual and expected value
	}
	
	@Test
	public void checkDeletingProducts(){
		Product product = new Product(PRODUCT_NAME,BRAND_NAME,PRICE);
		pm.addProduct(product);
		pm.deleteProducts();
		List<Product> Products = pm.getAllProducts();
		assertEquals(0,Products.size());
	}
	
	
	@Test 
	public void checkGettingAllProducts(){
		pm.deleteProducts();
		Product product = new Product(PRODUCT_NAME,BRAND_NAME,PRICE);
		pm.addProduct(product);
		Product product2 = new Product(PRODUCT_NAME,BRAND_NAME,PRICE);
		pm.addProduct(product2);
		Product product3 = new Product(PRODUCT_NAME,BRAND_NAME,PRICE);
		pm.addProduct(product3);
		List<Product> Products = pm.getAllProducts();
		assertEquals(3,Products.size());
	}
	
	
	
	
	
}
