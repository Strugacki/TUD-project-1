package com.mhallman.skateshop.service;

import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import com.mhallman.skateshop.domain.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientManager {

	/**
	 * Initialization of variables used in ClientManager class
	 */
	private PreparedStatement addClientStmt;
	private PreparedStatement deleteAllClientsStmt;
	private PreparedStatement getAllClientsStmt;
	private dbConnect dbconn = new dbConnect();
	private Connection conn = dbconn.getConnection();
	private Statement statement;
	private ResultSet rs;
	private String createTableClient = "CREATE TABLE Client(id_client bigint GENERATED BY DEFAULT AS IDENTITY, first_name varchar(20), second_name varchar(20), phone_number bigint)";
	
	/**
	 * Basic constructor for ClientManager class
	 * - creates table Client if not exists
	 * - prepares statements 
	 */
	public ClientManager(){
		try {
			if(conn!=null){
				System.out.print("Connected to database\n");
			}
			rs = conn.getMetaData().getTables(null, null, null,null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Client".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}
			if (!tableExists){
				statement = conn.createStatement();
				statement.executeUpdate(createTableClient);
			}

			addClientStmt = conn.prepareStatement("INSERT INTO Client (first_name,second_name,phone_number) VALUES (?, ?, ?)");
			deleteAllClientsStmt = conn.prepareStatement("DELETE FROM Client");
			getAllClientsStmt = conn.prepareStatement("SELECT id_client, first_name,second_name, phone_number FROM Client");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public void deleteClients(){
		try {
			deleteAllClientsStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param client
	 * @return count
	 */
	public int addClient(Client client){
		int count=0;
		try {
			addClientStmt.setString(1, client.getFirst_name());
			addClientStmt.setString(2, client.getSecond_name());
			addClientStmt.setLong(3, client.getPhone_number());
			count=addClientStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;	
	}
	
	/**
	 * 
	 * @return Clients
	 */
	public List<Client> getAllClients(){
		ArrayList<Client> Clients = new ArrayList<Client>();
		
		try {
			ResultSet rs = getAllClientsStmt.executeQuery();
			while(rs.next()){
				Client client = new Client();
				client.setFirst_name(rs.getString("first_name"));
				client.setSecond_name(rs.getString("second_name"));
				client.setPhone_number(rs.getLong("phone_number"));
				Clients.add(client);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return Clients;
	}

	
}
