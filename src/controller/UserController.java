package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DatabaseConnection;
import model.User;

public class UserController {
	public DatabaseConnection db = new DatabaseConnection();
	
	public Boolean insertUser(User user) {
		// validate if user already exists
		if(checkUserExists(user)) {
			return false;
		}
		
		String query = "INSERT INTO Users(Email, Password)"
				+ "VALUES (?, ?)";
		
		try {
			PreparedStatement stmt = db.connection.prepareStatement(query);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			int rowsAffected = stmt.executeUpdate();
			System.out.println(rowsAffected);
			return rowsAffected > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void insertDefaultUsers() {
		try {
			boolean insert = insertUser(new User("admin@gmail.com", "123"));	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Boolean checkUserExists(User user) {
		String query = "SELECT COUNT(*) FROM Users WHERE Email=?";
		try {
			PreparedStatement stmt = db.connection.prepareStatement(query);
			stmt.setString(1, user.getEmail());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int count = rs.getInt(1);
				return count > 0;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
