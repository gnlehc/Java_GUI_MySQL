package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
	public Connection connection;
	public Statement statement;
	
	// constructor
	public DatabaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokped", "root", "");
			statement = connection.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createUsersTable() {
		String query = "CREATE TABLE IF NOT EXISTS Users("
				+ "UserID INT AUTO_INCREMENT PRIMARY KEY,"
				+ "Email VARCHAR(50) NOT NULL,"
				+ "Password VARCHAR(50) NOT NULL"
				+ ")";
		try {
			exec(query);			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void createProductsTable() {
		String query = "CREATE TABLE IF NOT EXISTS Products("
				+ "Name VARCHAR(50) NOT NULL,"
				+ "Category VARCHAR(50) NOT NULL,"
				+ "Price INT NOT NULL"
				+ ")";
		try {
			exec(query);			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void migrateTables() {
		createUsersTable();
		createProductsTable();
	}
	
	public void exec(String query) {
		try {
			statement.execute(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
