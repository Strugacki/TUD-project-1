package com.mhallman.skateshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mhallman.skateshop.domain.Purchase;

public class PurchaseManager {


	/**
	 * Initialization of variables used in PurchaseManager class
	 */
	private PreparedStatement addPurchaseStmt;
	private PreparedStatement deleteAllPurchasesStmt;
	private PreparedStatement deleteAllPurchasesOfClientStmt;
	private PreparedStatement getAllPurchasesStmt;
	private PreparedStatement getAllPurchasesOfClientStmt;
	private dbConnect dbconn = new dbConnect();
	private Connection conn = dbconn.getConnection();
	private Statement statement;
	private ResultSet rs;
	private String createTablePurchase = "CREATE TABLE Purchase(id_purchase bigint GENERATED BY DEFAULT AS IDENTITY, id_client bigint REFERENCES Client(id_client) ON DELETE CASCADE, date varchar(11))";
	
	/**
	 * Basic constructor for PurchaseManager class
	 * - creates table Product if not exists
	 * - prepares statements 
	 */
	public PurchaseManager(){
		try {
			if(conn!=null){
				System.out.print("Connected to database\n");
			}
			rs = conn.getMetaData().getTables(null, null, null,null);
			boolean tablePurchaseExists = false;
			while (rs.next()) {
				if ("Purchase".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tablePurchaseExists = true;
				}
				break;
			}
			
			if (!tablePurchaseExists){
				statement = conn.createStatement();
				statement.executeUpdate(createTablePurchase);
			}

			addPurchaseStmt = conn.prepareStatement("INSERT INTO Purchase (id_client,date) VALUES (?, ?)");
			deleteAllPurchasesStmt = conn.prepareStatement("DELETE FROM Purchase");
			deleteAllPurchasesOfClientStmt = conn.prepareStatement("DELETE FROM Purchase WHERE id_client=?");
			getAllPurchasesStmt = conn.prepareStatement("SELECT id_purchase, id_client,date FROM Purchase");
			getAllPurchasesOfClientStmt = conn.prepareStatement("SELECT id_purchase,date FROM Purchase WHERE id_client=?");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 */
	public void deletePurchases(){
		try {
			deleteAllPurchasesStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public void deletePurchasesOfClient(long id_client){
		try {
			deleteAllPurchasesOfClientStmt.setLong(1, id_client);
			deleteAllPurchasesOfClientStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param purchase
	 * @return
	 */
	public int addPurchase(Purchase purchase){
		int count=0;
		try {
			addPurchaseStmt.setLong(1, purchase.getId_client());
			addPurchaseStmt.setString(2, purchase.getDate());
			count=addPurchaseStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;	
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Purchase> getAllPurchases(){
		ArrayList<Purchase> Purchases = new ArrayList<Purchase>();
		
		try {
			ResultSet rs = getAllPurchasesStmt.executeQuery();
			while(rs.next()){
				Purchase purchase = new Purchase();
				purchase.setId_purchase(rs.getLong("id_purchase"));
				purchase.setId_client(rs.getLong("id_client"));
				purchase.setDate(rs.getString("date"));
				Purchases.add(purchase);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Purchases;
	}
	
	
	public List<Purchase> getAllPurchasesOfClient(long id_client){
		ArrayList<Purchase> Purchases = new ArrayList<Purchase>();
		try {
			getAllPurchasesOfClientStmt.setLong(1, id_client);
			ResultSet rs = getAllPurchasesOfClientStmt.executeQuery();
			while(rs.next()){
				Purchase purchase = new Purchase();
				purchase.setId_purchase(rs.getLong("id_purchase"));
				purchase.setId_client(id_client);
				purchase.setDate(rs.getString("date"));
				Purchases.add(purchase);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Purchases;
	}
	
	
}
