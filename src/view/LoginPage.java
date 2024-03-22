package view;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
//import model.Account;
//import model.User;
//import request.LoginRequest;

public class LoginPage {
//	private Account acc = new Account(new ArrayList<User>());
	public Stage stage;
	public Scene scene;
	public BorderPane borderPane;
	public GridPane gridPane;
	public Label emailLabel, passwordLabel;
	public TextField emailTF;
	public PasswordField passwordfield;
	public Button loginButton;
	
	
	public LoginPage(Stage stage) {
		this.stage = stage;
		this.stage.setTitle("Login");
		initialize();
		setLayout();
		setAlignment();
		// scene di inisialisasi setelah function initialize dan setLayout
		this.scene = new Scene(borderPane, 500, 500);
	}

	// inisialisasi objek / atribut yang kita punya
	public void initialize() {
		borderPane = new BorderPane();
		gridPane = new GridPane();
		emailLabel = new Label("Email");
		passwordLabel = new Label("Password");
		emailTF = new TextField();
		passwordfield = new PasswordField();
		loginButton = new Button("Login");	

		EventHandler<MouseEvent> loginEvent = event -> {
			
//			req.setEmail(emailTF.getText());
//			req.setPassword(passwordfield.getText());
			String email = emailTF.getText();
			String password = passwordfield.getText();
			System.out.println(email);
			System.out.println(password);
//			Boolean isLogin = acc.loginAccount(req.getEmail(), req.getPassword());
//			if(isLogin == true) {
//				System.out.println("Login Success!");
//				HomePage homePage = new HomePage(stage);
//				stage.setScene(homePage.getScene());
//			}
			System.out.println("Login Success!");
			HomePage homePage = new HomePage(stage);
			stage.setScene(homePage.getScene());
//			else {
//				System.out.println("Credential not match");
//			}
		};
		loginButton.addEventHandler(MouseEvent.MOUSE_CLICKED, loginEvent);
		
	}
	
	// gabungin semua element yang kita punya ke 1 page
	public void setLayout() {
		// 1. gabungin node / element kita ke gridpane
		// 2. gridpane digabungin ke borderpane
		gridPane.add(emailLabel, 0, 0);
		gridPane.add(emailTF, 0, 1);
		gridPane.add(passwordLabel, 0, 2);
		gridPane.add(passwordfield, 0, 3);
		gridPane.add(loginButton, 0, 4);
		borderPane.setCenter(gridPane);
	}
	
	public void setAlignment() {
		BorderPane.setMargin(gridPane, new Insets(10));
	}
	
	public Scene getScene() {
		return this.scene;
	}
}
