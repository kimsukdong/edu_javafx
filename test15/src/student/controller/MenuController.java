package student.controller;

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
		Parent root = FXMLLoader.load(getClass().getResource("/student/view/NewWindow.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Student Informations");
		stage.show();
    	
    }

    @FXML
    void onClickTable1(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/student/view/View1.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Student Informations");
		stage.show();
    }
    @FXML
    void onClickTable2(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/student/view/View2.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Student Informations");
		stage.show();
    }
    @FXML
    void onClickBacktoLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/student/view/Sample.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setTitle("Login Form");
		stage.setScene(scene);
		stage.show();
    }

}
