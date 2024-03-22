package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
	int id;
	String email;
	String password;
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public StringProperty emailProperty() {
        return new SimpleStringProperty(email);
    }
	public StringProperty passwordProperty() {
		return new SimpleStringProperty(password);
	}
}
