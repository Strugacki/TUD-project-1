package com.mhallman.skateshop.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mhallman.skateshop.domain.Client;
import com.mhallman.skateshop.service.ClientManager;

public class ClientManagerTest {

	ClientManager cm = new ClientManager();
	private final static String FIRST_NAME="Adam";
	private final static String SECOND_NAME="Kowalski";
	private final long PHONE_NUMBER=782694466;
	
	@Test
	public void checkAdding(){
		
		Client client = new Client(FIRST_NAME,SECOND_NAME,PHONE_NUMBER);
		Client addedClient;
		cm.deleteClients();
		assertEquals(1,cm.addClient(client));
		List<Client> Clients = cm.getAllClients();
		addedClient = Clients.get(0);
		assertEquals(FIRST_NAME,addedClient.getFirst_name());
		assertEquals(SECOND_NAME,addedClient.getSecond_name());
		assertEquals(PHONE_NUMBER,addedClient.getPhone_number());
	}
	
	@Test
	public void checkDeletingClients(){
		Client client = new Client(FIRST_NAME,SECOND_NAME,PHONE_NUMBER);
		Client addedClient;
		cm.deleteClients();
		List<Client> Clients = cm.getAllClients();
		assertEquals(0,Clients.size());
	}
	
	
	
	
}
