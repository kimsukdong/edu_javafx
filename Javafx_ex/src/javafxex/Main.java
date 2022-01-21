package javafxex;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
			Button centerButton = new Button("중앙");
			Button topButton = new Button("위쪽");
			Button rightButton = new Button("오른쪽");
			Button bottomButton = new Button("아래쪽");
			Button leftButton = new Button("왼쪽");
			
	        BorderPane.setAlignment(topButton,Pos.TOP_CENTER);
	        BorderPane.setAlignment(bottomButton,Pos.BOTTOM_CENTER);
	        BorderPane.setAlignment(leftButton,Pos.CENTER_LEFT);
	        BorderPane.setAlignment(rightButton,Pos.CENTER_RIGHT);
			
			BorderPane root = new BorderPane(centerButton,topButton,rightButton,bottomButton,leftButton);			
		    root.setStyle("-fx-padding: 10;");
		    
			Scene scene = new Scene(root,500,300);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("A Simple BorderPane Example by JavaFx");
	}
	public static void main(String[] args) {
		launch(args);
	}
}
