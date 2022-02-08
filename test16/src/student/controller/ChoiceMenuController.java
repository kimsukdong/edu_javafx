package student.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChoiceMenuController {
    @FXML
    void onClickSearch(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/student/view/Search.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
    }

    @FXML
    void onClickAdd(ActionEvent event) {

    }

    @FXML
    void onClickBacktoLogin(ActionEvent event) {

    }

    @FXML
    void onClickBacktoMenu(ActionEvent event) {

    }

    @FXML
    void onClickDelete(ActionEvent event) {

    }

    @FXML
    void onClickUpdate(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/student/view/Update.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
    }
}
