package main;

import controller.UserController;
import database.DatabaseConnection;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	DatabaseConnection db = new DatabaseConnection();
	public UserController userController = new UserController();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
		launch(args);
	}

	public Main() {
		db.migrateTables();
		userController.insertDefaultUsers();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
