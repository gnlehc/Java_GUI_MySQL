package main;

import controller.ProductController;
import controller.UserController;
import database.DatabaseConnection;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	DatabaseConnection db = new DatabaseConnection();
	UserController uc = new UserController();
	ProductController pc = new ProductController();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
		launch(args);
	}
	public Main() {
		db.migrateTables();
//		uc.insertDefaultAccount();
		pc.insertDefaultProduct();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
