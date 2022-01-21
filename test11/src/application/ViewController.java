package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ViewController {
	Connection conn;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet srs;
	
	ObservableList<Student> list;
	String index;
	
    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_phone;
    
    @FXML
    private TableView<Student> tableContent;
    @FXML
    private TableColumn<Student, String> col_email;

    @FXML
    private TableColumn<Student, String> col_id;

    @FXML
    private TableColumn<Student, String> col_name;

    @FXML
    private TableColumn<Student, String> col_phone;
	
	@FXML
	private void initialize() {
		conn = mysqlconnect.ConnectDb();
		tablelookup();
	}
	
	public void tablelookup() {
		
		try {
			stmt = conn.createStatement();
			srs = stmt.executeQuery("select * from student");

			list = FXCollections.observableArrayList();
			while(srs.next()) {

				String r1 = srs.getString("id");
				String r2 = srs.getString("name");
				String r3 = srs.getString("email");
				String r4 = srs.getString("phone");				

				Student student = new Student(r1,r2,r3,r4);	

				list.add(student);

				col_id.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
				col_name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
				col_email.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
				col_phone.setCellValueFactory(new PropertyValueFactory<Student,String>("phone"));										
 
				tableContent.setItems(list);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}   
	
	public void cleartext() {
		txt_id.setText("");
		txt_name.setText("");
		txt_email.setText("");
		txt_phone.setText("");
	}
	
    @FXML
    void onMouseClicked(MouseEvent event) {
		TableViewSelectionModel<Student> model = tableContent.getSelectionModel();

		Student s = (Student)model.getSelectedItem();
		txt_id.setText(s.getId());
		txt_name.setText(s.getName());
		txt_email.setText(s.getEmail());
		txt_phone.setText(s.getPhone());
		
		index = s.getId();
    }
	@FXML
	void onClickBacktoLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setTitle("Login Form");
		stage.setScene(scene);
	}
    @FXML
    void onClickBacktoMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setTitle("Menu");
		stage.setScene(scene);
    }
    
    @FXML
    void onClickUpdate(ActionEvent event) {
    	String r1 = txt_id.getText();
		String r2 = txt_name.getText();
		String r3 = txt_email.getText();
		String r4 = txt_phone.getText();
		if(r1.length()==0) {
			JOptionPane.showMessageDialog(null, "No id");
			return ;
		}

		try {
			pst = conn.prepareStatement("update student set name= ?, email=?,phone=? where id = ?");
			pst.setString(1, r2);
			pst.setString(2, r3);
			pst.setString(3, r4);
			pst.setString(4, r1);


			if(index.equals(r1)) {
				JOptionPane.showMessageDialog(null, "Student update!");
				pst.executeUpdate();
			} else
			{
				JOptionPane.showMessageDialog(null, "Different id");
			}
			
			cleartext();
			tablelookup();	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}


