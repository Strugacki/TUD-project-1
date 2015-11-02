package com.mhallman.skateshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mhallman.skateshop.domain.ProductPurchase;
import com.mhallman.skateshop.domain.Purchase;

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

			addProductPurchaseStmt = conn.prepareStatement("INSERT INTO ProductPurchase (id_purchase,id_product,quantity,summary) VALUES (?, ?,?,?)");
			deleteAllProductPurchasesStmt = conn.prepareStatement("DELETE FROM ProductPurchase");
			deleteAllProductPurchasesOfProductStmt = conn.prepareStatement("DELETE FROM ProductPurchase WHERE id_product=?");
			deleteAllProductPurchasesOfPurchaseStmt = conn.prepareStatement("DELETE FROM ProductPurchase WHERE id_purchase=?");
			getAllProductPurchasesStmt = conn.prepareStatement("SELECT id_purchase, id_client,date FROM ProductPurchase");
			getAllProductPurchasesOfProductStmt = conn.prepareStatement("SELECT id_purchase,id_product,quantity,summary FROM ProductPurchase WHERE id_product=?");
			getAllProductPurchasesOfPurchaseStmt = conn.prepareStatement("SELECT id_purchase,id_product,quantity,summary FROM ProductPurchase WHERE id_purchase=?");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Method deleting all ProductPurchases from Database
	 */
	public void deleteProductPurchases(){
		try {
			deleteAllProductPurchasesStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Method adding PurchaseProduct to Database
	 * @param purchase
	 * @return
	 */
	public int addProductPurchase(ProductPurchase ProductPurchase){
		int count=0;
		try {
			addProductPurchaseStmt.setLong(1, ProductPurchase.getId_purchase());
			addProductPurchaseStmt.setLong(2, ProductPurchase.getId_product());
			addProductPurchaseStmt.setInt(3, ProductPurchase.getQuantity());
			addProductPurchaseStmt.setDouble(4, ProductPurchase.getSummary());
			count=addProductPurchaseStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;	
	}
	
	/**
	 * Method getting all ProductPurchases from Database
	 * @return
	 */
	public List<ProductPurchase> getAllProductPurchases(){
		ArrayList<ProductPurchase> ProductPurchases = new ArrayList<ProductPurchase>();
		
		try {
			ResultSet rs = getAllProductPurchasesStmt.executeQuery();
			while(rs.next()){
				ProductPurchase ProductPurchase = new ProductPurchase();
				ProductPurchase.setId_purchase(rs.getLong("id_purchase"));
				ProductPurchase.setId_product(rs.getLong("id_product"));
				ProductPurchase.setQuantity(rs.getInt("quantity"));
				ProductPurchase.setSummary(rs.getDouble("summary"));
				ProductPurchases.add(ProductPurchase);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return ProductPurchases;
	}
	
	
}
