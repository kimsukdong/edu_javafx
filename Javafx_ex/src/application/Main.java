package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,500,300);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("A Simple BorderPane Example by JavaFx using fxml");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
