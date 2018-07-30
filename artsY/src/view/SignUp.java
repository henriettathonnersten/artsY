package view;

import java.io.File;
import java.sql.SQLException;

import artsYcode.JDBC;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SignUp extends Application {
	
	@Override 
	public void start(Stage base) throws Exception {
		
		JDBC database = new JDBC();
		
		//LOGO 
		
		HBox usernameHBox = new HBox(10);
		HBox emailHBox = new HBox(10);
		HBox passwordHBox = new HBox(10);
		HBox adressHBox = new HBox(10);
		HBox adressLine1HBox = new HBox(10);
		HBox adressLine2HBox = new HBox(10);
		HBox signUpHBox = new HBox(10);
		VBox userInfo = new VBox(10);
		
		Label usernameLabel = new Label("Enter username: ");
		TextField usernameTextField = new TextField();
		usernameTextField.setMaxWidth(300);
		usernameHBox.getChildren().addAll(usernameLabel, usernameTextField);
		usernameHBox.setAlignment(Pos.CENTER);
		
		Label emailLabel = new Label("Enter email: ");
		TextField emailTextField = new TextField();
		emailTextField.setMaxWidth(300);
		emailHBox.getChildren().addAll(emailLabel, emailTextField);
		emailHBox.setAlignment(Pos.CENTER);

		Label passwordLabel = new Label("Enter password: ");
		TextField passwordTextField = new TextField();
		passwordTextField.setMaxWidth(300);
		passwordHBox.getChildren().addAll(passwordLabel, passwordTextField);
		passwordHBox.setAlignment(Pos.CENTER);
		
		Label addressLabel = new Label("Enter your address: \n");
		addressLabel.setPadding(new Insets(10.0, 0, 0, 0));
		adressHBox.getChildren().add(addressLabel);
		adressHBox.setAlignment(Pos.CENTER);	
		
		//street, houseNo, apartment
		TextField streetTextField = new TextField();
		passwordTextField.setMaxWidth(300);
		Label streetLabel = new Label("Street");
		streetLabel.setFont(new Font("Tahoma", 10));
		VBox streetVBox = new VBox();
		streetVBox.getChildren().addAll(streetTextField, streetLabel);
		
		TextField houseNumberTextField = new TextField();
		houseNumberTextField.setMaxWidth(50);
		Label houseNumberLabel = new Label("House \nnumber");
		houseNumberLabel.setFont(new Font("Tahoma", 10));
		VBox houseNumberVBox = new VBox();
		houseNumberVBox.getChildren().addAll(houseNumberTextField, houseNumberLabel);
		
		TextField apartmentTextField = new TextField();
		apartmentTextField.setMaxWidth(50);
		Label apartmentLabel = new Label("Apartment \nnumber");
		apartmentLabel.setFont(new Font("Tahoma", 10));
		VBox apartmentVBox = new VBox();
		apartmentVBox.getChildren().addAll(apartmentTextField, apartmentLabel);
		
		adressLine1HBox.getChildren().addAll(streetVBox, houseNumberVBox, apartmentVBox);
		adressLine1HBox.setAlignment(Pos.CENTER);
		
		//postcode, city, county  		
		TextField postcodeTextField = new TextField();
		postcodeTextField.setMaxWidth(100);
		Label postcodeLabel = new Label("Postcode");
		postcodeLabel.setFont(new Font("Tahoma", 10));
		VBox postcodeVBox = new VBox();
		postcodeVBox.getChildren().addAll(postcodeTextField, postcodeLabel);
		
		TextField cityTextField = new TextField();
		cityTextField.setMaxWidth(200);
		Label cityLabel = new Label("City");
		cityLabel.setFont(new Font("Tahoma", 10));
		VBox cityVBox = new VBox();
		cityVBox.getChildren().addAll(cityTextField, cityLabel);
		
		TextField countyTextField = new TextField();
		countyTextField.setMaxWidth(100);
		Label countyLabel = new Label("County");
		countyLabel.setFont(new Font("Tahoma", 10));
		VBox countyVBox = new VBox();
		countyVBox.getChildren().addAll(countyTextField, countyLabel);
		
		adressLine2HBox.getChildren().addAll(postcodeVBox, cityVBox, countyVBox);
		adressLine2HBox.setAlignment(Pos.CENTER);
		
		Button signupButton = new Button("Sign Up");
		signupButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {				
		
					if (database.addUser(usernameTextField.getText(), emailTextField.getText(), passwordTextField.getText(), 
									streetTextField.getText(), houseNumberTextField.getText(), apartmentTextField.getText(),
									postcodeTextField.getText(), cityTextField.getText(), countyTextField.getText()) == "success") {				
						base.close();
						try {
							new Login().start(new Stage());
						} catch (Exception e) { 
							e.printStackTrace();
						}
					}
					else
						System.out.println("Something is wrong / error messages should be in GUI");
				
					
			}
		});
		signUpHBox.getChildren().add(signupButton); 
		signUpHBox.setAlignment(Pos.CENTER);		
		
		userInfo.getChildren().addAll(usernameHBox, emailHBox, passwordHBox, adressHBox, adressLine1HBox, adressLine2HBox, signUpHBox);// add logo here as well
		BorderPane root = new BorderPane();
		root.setCenter(userInfo);
		
		Scene scene = new Scene(root, 1000, 600);
		File f = new File("Login.css");
		scene.getStylesheets().clear();
		scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
		
		base.setTitle("Sign up - konstY.com");
		base.setScene(scene);
		base.show();
	}
	
	public boolean addUser() {
		return true;
	}
}
