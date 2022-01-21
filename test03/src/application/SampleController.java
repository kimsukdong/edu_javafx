package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SampleController {
	Connection conn = null;
	ResultSet srs = null;
	PreparedStatement pst = null;

    @FXML
    private TextField txt_login;

    @FXML
    private PasswordField txt_pass;


	@FXML
	private void initialize() {
		conn = mysqlconnect.ConnectDb();
		try {
			pst = conn.prepareStatement("select * from student where id =? and name=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    @FXML
    void onClickLogin(ActionEvent event) {
    	String id = txt_login.getText();
    	String name = txt_pass.getText();

    	if(id.equals("") && name.equals(""))
    	{
    		JOptionPane.showMessageDialog(null, "UserName or Password Blank");
    	} else 
    	{
			try {
				pst.setString(1, id);
				pst.setString(2, name);
				
				srs = pst.executeQuery();
				if(srs.next()) {
					JOptionPane.showMessageDialog(null, "Login Success");  
				} else
				{
					JOptionPane.showMessageDialog(null, "Login Failed");  
					txt_login.setText("");
					txt_pass.setText("");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void onClickRegister(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

}
