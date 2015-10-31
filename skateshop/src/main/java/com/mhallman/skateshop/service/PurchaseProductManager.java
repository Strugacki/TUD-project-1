package com.mhallman.skateshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PurchaseProductManager {

	
	/**
	 * Initialization of variables used in ProductPurchaseManager class
	 */
	private PreparedStatement addProductPurchaseStmt;
	private PreparedStatement deleteProductPurchaseStmt;
	private PreparedStatement deleteAllProductPurchasesStmt;
	private PreparedStatement deleteAllProductPurchasesOfProductStmt;
	private PreparedStatement deleteAllProductPurchasesOfPurchaseStmt;
	private PreparedStatement getAllProductPurchasesStmt;
	private PreparedStatement getAllProductPurchasesOfProductStmt;
	private PreparedStatement getAllProductPurchasesOfPurchaseStmt;
	private dbConnect dbconn = new dbConnect();
	private Connection conn = dbconn.getConnection();
	private Statement statement;
	private Statement statement2;
	private Statement statement3;
	private ResultSet rs;
	private String alterTableProductPurchase = "ALTER TABLE ProductPurchase ADD CONSTRAINT id_productfk FOREIGN KEY (id_product) REFERENCES Product(id_product) ON DELETE CASCADE";
	private String alterTableProductPurchase2 = "ALTER TABLE ProductPurchase ADD CONSTRAINT id_purchasefk FOREIGN KEY (id_purchase) REFERENCES Purchase(id_purchase) ON DELETE CASCADE";
	private String createTableProductPurchase = "CREATE TABLE ProductPurchase(id_purchase bigint, id_product bigint, quantity int,summary double)";
	
	
	/**
	 * Basic constructor for ProductPurchaseManager class
	 * - creates table Product if not exists
	 * - prepares statements 
	 */
	public PurchaseProductManager(){
		try {
			if(conn!=null){
				System.out.print("Connected to database\n");
			}
			rs = conn.getMetaData().getTables(null, null, null,null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("ProductPurchase".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}
			
			if (!tableExists){
				statement = conn.createStatement();
				statement2 = conn.createStatement();
				statement3 = conn.createStatement();
				statement.executeUpdate(createTableProductPurchase);
				statement2.executeUpdate(alterTableProductPurchase);
				statement3.executeUpdate(alterTableProductPurchase2);
			}

			addProductPurchaseStmt = conn.prepareStatement("INSERT INTO ProductPurchase (id_purchase,id_product,quantity,summary) VALUES (?, ?)");
			deleteProductPurchaseStmt = conn.prepareStatement("DELETE FROM ProductPurchase WHERE id_client= ?");
			deleteAllProductPurchasesStmt = conn.prepareStatement("DELETE FROM Purchase");
			deleteAllProductPurchasesOfProductStmt = conn.prepareStatement("DELETE FROM Purchase WHERE id_client=?");
			deleteAllProductPurchasesOfPurchaseStmt = conn.prepareStatement("DELETE FROM Purchase WHERE id_client=?");
			getAllProductPurchasesStmt = conn.prepareStatement("SELECT id_purchase, id_client,date FROM Purchase");
			getAllProductPurchasesOfProductStmt = conn.prepareStatement("SELECT id_purchase,date FROM Purchase WHERE id_client=?");
			getAllProductPurchasesOfPurchaseStmt = conn.prepareStatement("SELECT id_purchase,date FROM Purchase WHERE id_client=?");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
