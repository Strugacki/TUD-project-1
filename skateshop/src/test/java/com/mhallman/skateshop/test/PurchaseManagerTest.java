package com.mhallman.skateshop.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mhallman.skateshop.domain.Client;
import com.mhallman.skateshop.domain.Purchase;
import com.mhallman.skateshop.service.ClientManager;
import com.mhallman.skateshop.service.PurchaseManager;

public class PurchaseManagerTest {

	private ClientManager cm = new ClientManager();
	private PurchaseManager pm = new PurchaseManager();
	private long ID_CLIENT;
	private final static String DATE="06-10-1994";
	private final static String FIRST_NAME="Adam";
	private final static String SECOND_NAME="Kowalski";
	private final long PHONE_NUMBER=782694466;
	private final static String FIRST_NAME2="Bolek";
	private final static String SECOND_NAME2="Lolek";
	private final long PHONE_NUMBER2=504683163;
	
	
	@Test
	public void checkAdding(){
		cm.deleteClients();
		Client client = new Client(FIRST_NAME,SECOND_NAME,PHONE_NUMBER);
		cm.addClient(client);
		List<Client> Clients = cm.getAllClients();
		Purchase purchase = new Purchase(Clients.get(0).getId_client(),DATE);
		Purchase addedPurchase;
		pm.deletePurchases();
		assertEquals(1,pm.addPurchase(purchase));
		List<Purchase> Purchases = pm.getAllPurchases();
		addedPurchase = Purchases.get(0);
		assertEquals(Clients.get(0).getId_client(),addedPurchase.getId_client());
		assertEquals(DATE,addedPurchase.getDate());
	}
	
	@Test
	public void checkDeletingPurchases(){
		cm.deleteClients();
		Client client = new Client(FIRST_NAME,SECOND_NAME,PHONE_NUMBER);
		cm.addClient(client);
		List<Client> Clients = cm.getAllClients();
		Purchase purchase = new Purchase(Clients.get(0).getId_client(),DATE);
		pm.addPurchase(purchase);
		pm.deletePurchases();
		List<Purchase> Purchases = pm.getAllPurchases();
		assertEquals(0,Purchases.size());
	}
	
	@Test
	public void checkDeletingPurchasesOfClient(){
		cm.deleteClients();
		pm.deletePurchases();
		Client client = new Client(FIRST_NAME,SECOND_NAME,PHONE_NUMBER);
		cm.addClient(client);
		Client client2 = new Client(FIRST_NAME2,SECOND_NAME2,PHONE_NUMBER2);
		cm.addClient(client2);
		List<Client> Clients = cm.getAllClients();
		Purchase purchase = new Purchase(Clients.get(0).getId_client(),DATE);
		pm.addPurchase(purchase);
		Purchase purchase2 = new Purchase(Clients.get(1).getId_client(),DATE);
		pm.addPurchase(purchase2);
		Purchase purchase3 = new Purchase(Clients.get(0).getId_client(),DATE);
		pm.addPurchase(purchase3);
		pm.deletePurchase(Clients.get(0).getId_client());
		List<Purchase> Purchases = pm.getAllPurchases();
		assertEquals(1,Purchases.size());
		
	}
	
	
	@Test 
	public void checkGettingAllPurchases(){
		pm.deletePurchases();
		cm.deleteClients();
		Client client = new Client(FIRST_NAME,SECOND_NAME,PHONE_NUMBER);
		cm.addClient(client);
		List<Client> Clients = cm.getAllClients();
		Purchase purchase = new Purchase(Clients.get(0).getId_client(),DATE);
		pm.addPurchase(purchase);
		Purchase purchase2 = new Purchase(Clients.get(0).getId_client(),DATE);
		pm.addPurchase(purchase2);
		Purchase purchase3 = new Purchase(Clients.get(0).getId_client(),DATE);
		pm.addPurchase(purchase3);
		List<Purchase> Purchases = pm.getAllPurchases();
		assertEquals(3,Purchases.size());
	}
	
	@Test 
	public void checkGettingAllPurchasesOfClient(){
		pm.deletePurchases();
		cm.deleteClients();
		Client client = new Client(FIRST_NAME,SECOND_NAME,PHONE_NUMBER);
		cm.addClient(client);
		Client client2 = new Client(FIRST_NAME2,SECOND_NAME2,PHONE_NUMBER2);
		cm.addClient(client2);
		List<Client> Clients = cm.getAllClients();
		Purchase purchase = new Purchase(Clients.get(0).getId_client(),DATE);
		pm.addPurchase(purchase);
		Purchase purchase2 = new Purchase(Clients.get(1).getId_client(),DATE);
		pm.addPurchase(purchase2);
		Purchase purchase3 = new Purchase(Clients.get(0).getId_client(),DATE);
		pm.addPurchase(purchase3);
		List<Purchase> Purchases = pm.getAllPurchasesOfClient(Clients.get(0).getId_client());
		assertEquals(2,Purchases.size());
	}
	
	
	
	
}
