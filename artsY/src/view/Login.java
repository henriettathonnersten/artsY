package view;

import java.io.File;

import artsYcode.JDBC;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.RandomTestClass.SecondJavaFXStage;


public class Login extends Application {
	
	public static void main(String[] args) {		
	//	JDBC jdbc = new JDBC();
	//	jdbc.getInformtionFromDatabase();
		
		launch();
	}

	@Override
	public void start(Stage base) throws Exception {

		//StackPane root = new StackPane();
		HBox emailHBox = new HBox(10);
		HBox passwordHBox = new HBox(10);
		HBox buttonHBox = new HBox(10);
		VBox vBox = new VBox(15);
		BorderPane root = new BorderPane();
		
		//ADD LOGO HERE
		JDBC jdbc = new JDBC();
		String test = jdbc.logIn();

		
		Label emailLabel = new Label("Email: ");
		TextField emailTextField = new TextField();
		emailTextField.setMaxWidth(300);
		emailHBox.getChildren().addAll(emailLabel, emailTextField);
		emailHBox.setAlignment(Pos.CENTER);
		
		Label passwordLabel = new Label("Password: ");
		TextField passwordTextField = new TextField();
		passwordTextField.setMaxWidth(215);
		passwordHBox.getChildren().addAll(passwordLabel, passwordTextField);
		passwordHBox.setAlignment(Pos.CENTER);
		
		Button signupButton = new Button("Sign Up");
		signupButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				base.close();
				try {
					new SignUp().start(new Stage());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Button loginButton = new Button("Login");
		buttonHBox.getChildren().addAll(signupButton, loginButton);
		buttonHBox.setAlignment(Pos.CENTER);

		//////
		Label testLabel = new Label(test);
		//////		
		
		vBox.getChildren().addAll(emailHBox, passwordHBox, buttonHBox, testLabel); // ADD LOGO HERE AS WELL
		vBox.setAlignment(Pos.CENTER);

		root.setCenter(vBox);
 		//root.getChildren().addAll(Arrays.asList(, emailTextField, passwordTextField));
		
		Scene scene = new Scene(root, 1000, 600);
		File f = new File("Login.css");
		scene.getStylesheets().clear();
		scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
		
		base.setTitle("Login - konstY.com");
		base.setScene(scene);
		base.show();
		
		
		//actionhandler: LOGGA IN och felmeddelande
		//actionhandler: LOGGA IN och oppna nytt fonster med add new item
		//actionhandler: SIGN UP och oppna nytt fonster med add new USER
		
	}

}
