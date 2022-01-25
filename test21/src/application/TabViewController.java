package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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

public class TabViewController {
	Connection conn;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet srs;
	
	ObservableList<Student> list;
	String index;
	
    @FXML    private TextField txt_email;
    @FXML    private TextField txt_id;
    @FXML    private TextField txt_name;
    @FXML    private TextField txt_phone;
    
	@FXML 	private TextField txt_email1;
	@FXML	private TextField txt_id1;
	@FXML	private TextField txt_name1;
	@FXML	private TextField txt_phone1; 
    
    @FXML    private TableView<Student> tableContent;
    @FXML    private TableColumn<Student, String> col_email;
    @FXML    private TableColumn<Student, String> col_id;
    @FXML    private TableColumn<Student, String> col_name;
    @FXML    private TableColumn<Student, String> col_phone;
    
    @FXML    private TableView<Student> tableContent1;
    @FXML    private TableColumn<Student, String> col_email1;
    @FXML    private TableColumn<Student, String> col_id1;
    @FXML    private TableColumn<Student, String> col_name1;
    @FXML    private TableColumn<Student, String> col_phone1;
	
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
				
				col_id1.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
				col_name1.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
				col_email1.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
				col_phone1.setCellValueFactory(new PropertyValueFactory<Student,String>("phone"));										
 
				tableContent1.setItems(list);
				
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
		
		txt_id1.setText("");
		txt_name1.setText("");
		txt_email1.setText("");
		txt_phone1.setText("");
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
    void onMouseClicked1(MouseEvent event) {
		TableViewSelectionModel<Student> model = tableContent1.getSelectionModel();

		Student s = (Student)model.getSelectedItem();
		txt_id1.setText(s.getId());
		txt_name1.setText(s.getName());
		txt_email1.setText(s.getEmail());
		txt_phone1.setText(s.getPhone());
		
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
    void onClickAdd(ActionEvent event) {
		String r1 = txt_id1.getText();
		if(r1.length()==0) {
			JOptionPane.showMessageDialog(null, "No Record");
			return ;
		}

		String r2 = txt_name1.getText();
		String r3 = txt_email1.getText();
		String r4 = txt_phone1.getText();

		try {
			pst = conn.prepareStatement("insert into student (id,name, email, phone) values (?,?,?,?)");
			pst.setString(1, r1);
			pst.setString(2, r2);
			pst.setString(3, r3);
			pst.setString(4, r4);
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
		cleartext();
		tablelookup();
    }
}


