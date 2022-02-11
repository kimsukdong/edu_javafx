package student;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application { 
	/*
	 * login and new page , make a menu which select a table or a button.
	 * Select table list then display the list in the textfield.
	 * add Update function
	 * add Add function
	 * add Delete function
	 * Modify the design
	 * Make the MVC model
	 * Add a select menu
	 * Add a pane menu
	 * New : add menu_bar and separate view
	 */
	private static Stage primaryStage;
	public static BorderPane mainView;
	@Override
	public void start(Stage primaryStage) {
		try {
			Main.primaryStage = primaryStage;						
			showMainView();		
			showMainItems();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showMainView() {
		try {
			mainView = (BorderPane)FXMLLoader.load(getClass().getResource("view/MainView.fxml"));
			Scene scene = new Scene(mainView);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Login Form");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void showMainItems() throws IOException {
		BorderPane mainItem = (BorderPane)FXMLLoader.load(getClass().getResource("view/Sample.fxml"));
		mainView.setCenter(mainItem);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
