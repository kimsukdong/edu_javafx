package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    void onClickSearch(ActionEvent event) throws IOException {     	
		Parent root = FXMLLoader.load(getClass().getResource("NewWindow.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Student Informations");
		stage.show();
    	
    }

    @FXML
    void onClickTable(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Student Informations");
		stage.show();
    }
    
    @FXML
    void onClickTab(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("TabView.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Student Informations");
		stage.show();
    }

    @FXML
    void onClickBacktoLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setTitle("Login Form");
		stage.setScene(scene);
		stage.show();
    }

}
