package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	public Connection connection;
	public Statement statement;

	
	public DatabaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_depo", "root", "");
			statement = connection.createStatement();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void createUsersTable() {
		String query = "CREATE TABLE IF NOT EXISTS Users("
				+ "Id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "Email VARCHAR(50) NOT NULL,"
				+ "Password VARCHAR(50) NOT NULL)";
		try {
			exec(query);			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createBooksTable() {
		String query = "CREATE TABLE IF NOT EXISTS Books("
				+ "Id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "Title VARCHAR(50) NOT NULL,"
				+ "Author VARCHAR(50) NOT NULL,"
				+ "Genre VARCHAR(50) NOT NULL)";
		try {
			exec(query);			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void migrateTables() {
		createUsersTable();
		createBooksTable();
	}
	
	public void exec(String query) {
		try {
			statement.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
