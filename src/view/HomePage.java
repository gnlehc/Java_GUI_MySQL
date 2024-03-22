package view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.User;

public class HomePage {
//	private Account acc = new Account(new ArrayList<User>());
	public Stage stage;
	public Scene scene;
	public BorderPane borderPane;
	public GridPane gridPane;
	public Label welcomeLabel;
	TableView<User> UserAccountTable;

	public HomePage(Stage stage) {
		this.stage = stage;
		initialize();
		setLayout();
		this.scene = new Scene(borderPane, 500, 500);
	}

	public Scene getScene() {
		return this.scene;
	}
	public void initialize() {
//		ObservableList<User> ListUsers = FXCollections.observableArrayList(acc.getUsers());
		borderPane = new BorderPane();
		gridPane = new GridPane();
//		welcomeLabel = new Label("Welcome " + acc.getCurrUser().getUsername() + "!");
		welcomeLabel = new Label("Welcome ");
		TableColumn<User, String> emailCol = new TableColumn<>("Email");
		emailCol.setCellValueFactory(cell -> cell.getValue().emailProperty());
		TableColumn<User, String> passwordCol = new TableColumn<User, String>("Password");
		passwordCol.setCellValueFactory(cell -> cell.getValue().passwordProperty());
		
		
		UserAccountTable = new TableView<User>();
//		UserAccountTable.setItems(ListUsers);
		UserAccountTable.getColumns().addAll(emailCol, passwordCol);
	}
	
	public void setLayout() {
		gridPane.add(welcomeLabel, 0, 0);
		borderPane.setCenter(gridPane);
	}
	
}
