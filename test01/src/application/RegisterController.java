package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
	Connection conn = null;
	ResultSet srs = null;
	PreparedStatement pst = null;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_id;

    @FXML
    private PasswordField txt_name;

    @FXML
    private TextField txt_phone;
    
	@FXML
	private void initialize() {
		conn = mysqlconnect.ConnectDb();
	}

    @FXML
    void onClickBack(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
    }

    @FXML
    void onClickRegister(ActionEvent event) {
		String sid = txt_id.getText();
		if(sid.length()==0) {
			JOptionPane.showMessageDialog(null, "No Record");
			return ;
		}
		String sname = txt_name.getText();
		String semail = txt_email.getText();
		String sphone = txt_phone.getText();

		try {
			pst = conn.prepareStatement("insert into student (id,name, email, phone) values (?,?,?,?)");
			pst.setString(1, sid);
			pst.setString(2, sname);
			pst.setString(3, semail);
			pst.setString(4, sphone);
			int k =pst.executeUpdate();

			if(k==1) {
				JOptionPane.showMessageDialog(null, "Add Student !!!");
			} else {
				JOptionPane.showMessageDialog(null, "Error!");
			}
		} catch(SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Duplicate!");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
    }

}
