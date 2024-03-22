package controller;

import java.sql.PreparedStatement;

import database.DatabaseConnection;
import model.Product;

public class ProductController {
	DatabaseConnection db = new DatabaseConnection();
	
	public Boolean insertProduct(Product product) {
		String query = "INSERT INTO Products(Name, Category, Price) "
				+ "VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = db.connection.prepareStatement(query);
			stmt.setString(1, product.getName());
			stmt.setString(2, product.getCategory());
			stmt.setInt(3, product.getPrice());
			int rowAffected = stmt.executeUpdate();
			System.out.println("Rows Affected from insert product: " + rowAffected);
			return rowAffected > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void insertDefaultProduct() {
		try {
			boolean insert1 = insertProduct(new Product("Chips", "Snack", 12000));
			boolean insert2 = insertProduct(new Product("Coca Cola", "Beverage", 20000));
			boolean insert3 = insertProduct(new Product("Milk", "Dairy", 50000));
			boolean insert4 = insertProduct(new Product("Biscuit", "Snack", 7000));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
