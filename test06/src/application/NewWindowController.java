package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewWindowController {
	Connection conn;
	Statement stmt = null;
	ResultSet srs;

	@FXML	private TextField tf1;
	@FXML	private TextField tf2;
	@FXML	private TextField tf3;
	@FXML	private TextField tf4;

	@FXML
	private void initialize() {
		conn = mysqlconnect.ConnectDb();
		try {			
			stmt = conn.createStatement();
    		srs = stmt.executeQuery("select * from student");
		} catch (SQLException e) {
			System.out.println("SQL Error");
		} 		
		lookup();
	}
	
	public void lookup() {
		try {
			if(srs.next()) {
				tf1.setText(srs.getString("id"));
				tf2.setText(srs.getString("name"));
				tf3.setText(srs.getString("email"));
				tf4.setText(srs.getString("phone"));
			}
			else {
				JOptionPane.showMessageDialog(null, "No next Data !!");     		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void onClickNext(ActionEvent event) {
		lookup();
	}

	@FXML
	void onClickBacktoLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setTitle("Login Form");
		stage.setScene(scene);
	}
}
