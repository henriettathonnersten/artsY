package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RandomTestClass {

	public class FirstJavaFXStage extends Application {
		private Button secondStage;
		
		@Override
		public void start(Stage primaryStage) {
			secondStage = new Button("Go to Second Stage");
			StackPane root = new StackPane();
			root.getChildren().add(secondStage);
			Scene scene= new Scene(root,300,300);
			primaryStage.setScene(scene);
			primaryStage.setTitle("First Stage");
			secondStage.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					primaryStage.close();//Close the current stage
					new SecondJavaFXStage().start(new Stage());
				}
			});
			primaryStage.show();
		}
									
	}
	
	public class SecondJavaFXStage extends Application {
		private Button firstStage;
		@Override 
		public void start(Stage primaryStage) {
			Button firstStage = new Button("Back to First Stage");
			StackPane root = new StackPane();
			root.getChildren().add(firstStage);
			Scene scene= new Scene(root,300,300);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Second Stage");
			firstStage.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					primaryStage.close();//Close the current stage
					new FirstJavaFXStage().start(new Stage());
					}
			});
			primaryStage.show();
		}
				
			
		
	}
	
	
}
