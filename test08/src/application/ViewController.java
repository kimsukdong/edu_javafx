package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewController {
	Connection conn;
	Statement stmt = null;
	ResultSet srs;
	
	ObservableList<Student> list;
	
	
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
	void onClickBacktoLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setTitle("Login Form");
		stage.setScene(scene);
	}

}


