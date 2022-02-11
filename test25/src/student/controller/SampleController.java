package student.controller;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import student.Main;
import student.mysqlconnect;

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
    void onClickLogin(ActionEvent event) throws IOException {
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
					Parent root = FXMLLoader.load(getClass().getResource("/student/view/Menu.fxml"));
					Main.mainView.setCenter(root);	
					
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
		Parent root = FXMLLoader.load(getClass().getResource("/student/view/Register.fxml"));
		Main.mainView.setCenter(root);	
    }

}
