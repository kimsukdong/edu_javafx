package student.controller;

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
import student.Student;
import student.mysqlconnect;

public class TabViewController {
	Connection conn;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet srs;
	
	ObservableList<Student> list;
	String index;
	TableViewSelectionModel<Student> model;
	Student s;
	
	
    @FXML    private TextField txt_email;
    @FXML    private TextField txt_id;
    @FXML    private TextField txt_name;
    @FXML    private TextField txt_phone;
    
	@FXML 	private TextField txt_email1;
	@FXML	private TextField txt_id1;
	@FXML	private TextField txt_name1;
	@FXML	private TextField txt_phone1; 
	
	@FXML 	private TextField txt_email2;
	@FXML	private TextField txt_id2;
	@FXML	private TextField txt_name2;
	@FXML	private TextField txt_phone2; 
	
	@FXML 	private TextField txt_email3;
	@FXML	private TextField txt_id3;
	@FXML	private TextField txt_name3;
	@FXML	private TextField txt_phone3; 
    
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
	
    @FXML    private TableView<Student> tableContent2;
    @FXML    private TableColumn<Student, String> col_email2;
    @FXML    private TableColumn<Student, String> col_id2;
    @FXML    private TableColumn<Student, String> col_name2;
    @FXML    private TableColumn<Student, String> col_phone2;
    
    @FXML    private TableView<Student> tableContent3;
    @FXML    private TableColumn<Student, String> col_email3;
    @FXML    private TableColumn<Student, String> col_id3;
    @FXML    private TableColumn<Student, String> col_name3;
    @FXML    private TableColumn<Student, String> col_phone3;
    
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

				col_setup(col_id,col_name,col_email,col_phone,list,tableContent);
				col_setup(col_id1,col_name1,col_email1,col_phone1,list,tableContent1);
				col_setup(col_id2,col_name2,col_email2,col_phone2,list,tableContent2);
				col_setup(col_id3,col_name3,col_email3,col_phone3,list,tableContent3);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}   
	
	void col_setup(TableColumn<Student, String> id,TableColumn<Student, String> name,TableColumn<Student, String> email,TableColumn<Student, String> phone,ObservableList<Student> list,TableView<Student> tableContent) {
		id.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
		name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
		email.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
		phone.setCellValueFactory(new PropertyValueFactory<Student,String>("phone"));										 
		tableContent.setItems(list);
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
		
		txt_id2.setText("");
		txt_name2.setText("");
		txt_email2.setText("");
		txt_phone2.setText("");
		
		txt_id3.setText("");
		txt_name3.setText("");
		txt_email3.setText("");
		txt_phone3.setText("");
	}
	
	void mouseProcess(TextField txt_id,TextField txt_name,TextField txt_email,TextField txt_phone) {
		s = (Student)model.getSelectedItem();
		txt_id.setText(s.getId());
		txt_name.setText(s.getName());
		txt_email.setText(s.getEmail());
		txt_phone.setText(s.getPhone());

		index = s.getId();
	}
	
    @FXML
    void onMouseClicked(MouseEvent event) {
		model = tableContent.getSelectionModel();		
		mouseProcess(txt_id,txt_name,txt_email,txt_phone);
    }
    @FXML
    void onMouseClicked1(MouseEvent event) {
		model = tableContent1.getSelectionModel();		
		mouseProcess(txt_id1,txt_name1,txt_email1,txt_phone1);
    }
	@FXML
	void onMouseClicked2(MouseEvent event) {
		model = tableContent2.getSelectionModel();		
		mouseProcess(txt_id2,txt_name2,txt_email2,txt_phone2);
	}
	@FXML
	void onMouseClicked3(MouseEvent event) {
		model = tableContent3.getSelectionModel();		
		mouseProcess(txt_id3,txt_name3,txt_email3,txt_phone3);
	}
	@FXML
	void onClickBacktoLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/student/view/Sample.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setTitle("Login Form");
		stage.setScene(scene);
	}
    @FXML
    void onClickBacktoMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/student/view/Menu.fxml"));
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
    
    @FXML
    void onClickUpdate(ActionEvent event) {
    	String r1 = txt_id2.getText();
		String r2 = txt_name2.getText();
		String r3 = txt_email2.getText();
		String r4 = txt_phone2.getText();
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
    
	@FXML
	void onClickDelete(ActionEvent event) {
		if(index.length()==0) {
			JOptionPane.showMessageDialog(null, "No id");
			return ;
		}
		int dialogresult = JOptionPane.showConfirmDialog(null, "Do you want to delete this student?");
		if(dialogresult == JOptionPane.YES_NO_OPTION)
		{
			try {
				pst = conn.prepareStatement("delete from student where id = ?");
				pst.setString(1, index);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Student Deleted!");
				tablelookup();						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cleartext();
	}
}


