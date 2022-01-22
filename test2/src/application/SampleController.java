package application;

import java.text.NumberFormat;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SampleController {

	String str_org, str_dst;
	double d_org,d_dst;
	int a=0,b=0;
	double wv[][] = {
			{1.0, 42.0/55, 1.0/55, 1/8.0/55, 1/128.0/55, 1/3.785/55, 1/3785/55, 1/256.0/55, 1/768.0/55},
			{55.0/42, 1.0, 1.0/42, 1/8.0/42, 1/128.0/42, 1/3.785/42, 1/3785/42, 1/256.0/42, 1/768.0/42},
			{55.0, 42.0, 1.0, 1/8.0, 1/128.0, 1/3.785, 1/3785, 1/256.0, 1/768.0},
			{55.0*8, 42.0*8, 1.0*8, 1.0, 1/128.0*8, 1/3.785*8, 1/3785*8, 1/256.0*8, 1/768.0*8},			
			{55.0*128, 42.0*128, 1.0*128, 1/8.0*128, 1.0, 1/3.785*128, 1/3785*128, 1/256.0*128, 1/768.0*128},
			{55.0*3.785, 42.0*3.785, 1.0*3.785, 1/8.0*3.785, 1/128.0*3.785, 1.0, 1/3785*3.785, 1/256.0*3.785, 1/768.0*3.785},
			{55.0*3785, 42.0*3785, 1.0*3785, 1/8.0*3785, 1/128.0*3785, 1/3.785*3785, 1.0, 1/256.0*3785, 1/768.0*3785},
			{55.0*256, 42.0*256, 1.0*256, 1/8.0*256, 1/128.0*256, 1/3.785*256, 1/3785*256, 1.0, 1/768.0*256},
			{55.0*768, 42.0*768, 1.0*768, 1/8.0*768, 1/128.0*768, 1/3.785*768, 1/3785*768, 1/256.0*768, 1.0}};

	double wl[][] = {
			{1.0, 1.0/1.15, 1.0/1760/1.15, 1.0/5280/1.15, 1.0/63360/1.15, 1.0/1.6/1.15, 1.0/1609/1.15, 1.0/160900/1.15},
			{1.15, 1.0, 1.0/1760, 1.0/5280, 1.0/63360, 1.0/1.6, 1.0/1609, 1.0/160900},
			{1.15*1760, 1760.0, 1.0, 1.0/5280*1760, 1.0/63360*1760, 1.0/1.6*1760, 1.0/1609*1760, 1.0/160900*1760},
			{1.15*5380, 5380, 1.0/1760*5380, 1.0, 1.0/63360*5380, 1.0/1.6*5380, 1.0/1609*5380, 1.0/160900*5380},
			{1.15*63360, 63360, 1.0/1760*63360, 1.0/5280*63360, 1.0, 1.0/1.6*63360, 1.0/1609*63360, 1.0/160900*63360},
			{1.15*1.6, 1.6, 1.0/1760*1.6, 1.0/5280*1.6, 1.0/63360*1.6, 1.0, 1.0/1609*1.6, 1.0/160900*1.6},
			{1.15*1609, 1609.0, 1.0/1760*1609, 1.0/5280*1609, 1.0/63360*1609, 1.0/1.6*1609, 1.0/1609*1609, 1.0/160900*1609},
			{1.15*160900, 160900, 1.0/1760*160900, 1.0/5280*160900, 1.0/63360*160900, 1.0/1.6*160900, 1.0/1609*160900, 1.0}};
	
	double wa[][] = { 
		{1.0, 1224.17/3025, 1.0/3025, 0.3025/3025},
		{3025.0/1224.17, 1.0, 1.0/1224.17, 0.3025/1224.17},
		{3025.0, 1224.17, 1.0, 0.3025},
		{3025.0/0.3025, 1224.17/0.3025, 1.0/0.3025, 1.0}};
	
	double wm[][] = { 
			{1.0, 1.0/1000, 1.0/2.2, 1.0/35.27, 1.0/266.67, 1.0/1.67},
			{1000.0, 1.0, 1000.0/2.2, 1000.0/35.27, 1000.0/266.67, 1000.0/1.67},
			{1.0*2.2, 2.2/1000, 1.0, 2.2/35.27, 2.2/266.67, 2.2/1.67},
			{35.27, 35.27/1000, 35.27/2.2, 1.0, 35.27/266.67, 35.27/1.67},
			{266.67, 266.67/1000, 266.67/2.2, 266.67/35.27, 1.0, 266.67/1.67},
			{1.67, 1.67/1000, 1.67/2.2, 1.67/35.27, 1.67/266.67, 1.0}};
	
	@FXML	private ComboBox<String> ComboDst;
	@FXML	private ComboBox<String> ComboOrg;
    @FXML   private ComboBox<String> CombolDst;
    @FXML   private ComboBox<String> CombolOrg;
	@FXML	private ComboBox<String> ComboaDst;
	@FXML	private ComboBox<String> ComboaOrg;
    @FXML   private ComboBox<String> CombomDst;
    @FXML   private ComboBox<String> CombomOrg;
	@FXML	private ComboBox<String> CombotDst;
	@FXML	private ComboBox<String> CombotOrg;
	@FXML	private TextField txt_dst;
	@FXML	private TextField txt_org;
    @FXML   private TextField txt_ldst;
    @FXML   private TextField txt_lorg;   
	@FXML	private TextField txt_adst;
	@FXML	private TextField txt_aorg;
	@FXML	private TextField txt_mdst;
	@FXML	private TextField txt_morg;
	@FXML	private TextField txt_tdst;
	@FXML	private TextField txt_torg;

	ObservableList<String> comboBoxOrg = 
			FXCollections.observableArrayList("드럼(Drum)","배럴(Bbl)","갤론(Gal)","파인트(Pint)","온스(oz)","리터(L)", "시시(cc)","TableSpoon(tbl)","TeaSpoon(tea)");
	ObservableList<String> comboBoxDst = 
			FXCollections.observableArrayList("드럼(Drum)","배럴(Bbl)","갤론(Gal)","파인트(Pint)","온스(oz)","리터(L)", "시시(cc)","TableSpoon(tbl)","TeaSpoon(tea)");

	ObservableList<String> comboBoxlOrg = 
			FXCollections.observableArrayList("해리(Hr)", "마일(mi)", "야드(yard)", "피트(ft)", "인치(in)", "Km", "미터(m)", "cm");
	ObservableList<String> comboBoxlDst = 
			FXCollections.observableArrayList("해리(Hr)", "마일(mi)", "야드(yard)", "피트(ft)", "인치(in)", "Km", "미터(m)", "cm");
	
	ObservableList<String> comboBoxaOrg = 
			FXCollections.observableArrayList("헥타르(ha)","에이커(ac)","평","제곱미터(m2)");
	ObservableList<String> comboBoxaDst = 
			FXCollections.observableArrayList("헥타르(ha)","에이커(ac)","평","제곱미터(m2)");


	ObservableList<String> comboBoxmOrg = 
			FXCollections.observableArrayList("Kg","g","파운드(lb)","온스(oz)","돈","근");
	ObservableList<String> comboBoxmDst = 
			FXCollections.observableArrayList("Kg","g","파운드(lb)","온스(oz)","돈","근");


	ObservableList<String> comboBoxtOrg = 
			FXCollections.observableArrayList("섭씨(C)","화씨(F)");
	ObservableList<String> comboBoxtDst = 
			FXCollections.observableArrayList("섭씨(C)","화씨(F)");

	@FXML
	public void initialize() {	
		ComboOrg.setItems(comboBoxOrg);	
		ComboDst.setItems(comboBoxDst);
		txt_org.setText("1");
		txt_dst.setText("1");
		
		CombolOrg.setItems(comboBoxlOrg);	
		CombolDst.setItems(comboBoxlDst);		
		txt_lorg.setText("1");
		txt_ldst.setText("1");
		
		ComboaOrg.setItems(comboBoxaOrg);	
		ComboaDst.setItems(comboBoxaDst);
		txt_aorg.setText("1");
		txt_adst.setText("1");
		
		CombomOrg.setItems(comboBoxmOrg);	
		CombomDst.setItems(comboBoxmDst);
		txt_morg.setText("1");
		txt_mdst.setText("1");
		
		CombotOrg.setItems(comboBoxtOrg);	
		CombotDst.setItems(comboBoxtDst);
		txt_org.setText("1");
		txt_dst.setText("1");
	}

	@FXML
	void onComboDst(ActionEvent event) {
		b = ComboDst.getSelectionModel().getSelectedIndex();
		str_dst = ComboDst.getValue() ;
		cal_dst();
	}
	
    @FXML
    void onComboOrg(ActionEvent event) {
		a = ComboOrg.getSelectionModel().getSelectedIndex();
		str_org = ComboOrg.getValue() ;
    }

	void cal_dst() { 
		String s1 = txt_org.getText();
		Scanner s2 = new Scanner(s1);
		d_org=s2.nextDouble();
	//	d_org = Double.parseDouble(s1);

		d_dst = d_org*wv[b][a];
		int idst = (int)(d_dst*100.0);
		double ddst = idst/100.0;
		
		TextField tf = txt_dst;
		TextField tfo = txt_org;
		print_dst(ddst,tf,tfo);
	}

	void print_dst(double dd, TextField tf, TextField tfo) {
		NumberFormat numberFormatter;
		numberFormatter = NumberFormat.getNumberInstance();
		String quantityOut = numberFormatter.format(dd);

		tf.setText(quantityOut+" "+str_dst);
		tfo.setText(d_org+" "+str_org);
	}
	
    @FXML
    void onCombolDst(ActionEvent event) {
		b = CombolDst.getSelectionModel().getSelectedIndex();
		str_dst = CombolDst.getValue() ;
		cal_ldst();
    }

    @FXML
    void onCombolOrg(ActionEvent event) {
    	a = CombolOrg.getSelectionModel().getSelectedIndex();
    	str_org = CombolOrg.getValue() ;
    }
    
	void cal_ldst() { 
		String s1 = txt_lorg.getText();
		Scanner s2 = new Scanner(s1);
		d_org=s2.nextDouble();

		d_dst = d_org*wl[b][a];
		int idst = (int)(d_dst*100.0);
		double ddst = idst/100.0;
		
		TextField tf = txt_ldst;
		TextField tfo = txt_lorg;
		print_dst(ddst,tf,tfo);
	}
	
    @FXML
    void onComboaDst(ActionEvent event) {
		b = ComboaDst.getSelectionModel().getSelectedIndex();
		str_dst = ComboaDst.getValue() ;
		cal_adst();
    }

    @FXML
    void onComboaOrg(ActionEvent event) {
    	a = ComboaOrg.getSelectionModel().getSelectedIndex();
    	str_org = ComboaOrg.getValue() ;
    }
    
	void cal_adst() { 
		String s1 = txt_aorg.getText();
		Scanner s2 = new Scanner(s1);
		d_org=s2.nextDouble();

		d_dst = d_org*wa[b][a];
		int idst = (int)(d_dst*100.0);
		double ddst = idst/100.0;
		
		TextField tf = txt_adst;
		TextField tfo = txt_aorg;
		print_dst(ddst,tf,tfo);
	}
	
    @FXML
    void onCombomDst(ActionEvent event) {
		b = CombomDst.getSelectionModel().getSelectedIndex();
		str_dst = CombomDst.getValue() ;
		cal_mdst();
    }

    @FXML
    void onCombomOrg(ActionEvent event) {
    	a = CombomOrg.getSelectionModel().getSelectedIndex();
    	str_org = CombomOrg.getValue() ;
    }
    
	void cal_mdst() { 
		String s1 = txt_morg.getText();
		Scanner s2 = new Scanner(s1);
		d_org=s2.nextDouble();

		d_dst = d_org*wm[b][a];
		int idst = (int)(d_dst*100.0);
		double ddst = idst/100.0;
		
		TextField tf = txt_mdst;
		TextField tfo = txt_morg;
		print_dst(ddst,tf,tfo);
	}
	
    @FXML
    void onCombotDst(ActionEvent event) {
		b = CombotDst.getSelectionModel().getSelectedIndex();
		str_dst = CombotDst.getValue() ;
		cal_tdst();
    }

    @FXML
    void onCombotOrg(ActionEvent event) {
    	a = CombotOrg.getSelectionModel().getSelectedIndex();
    	str_org = CombotOrg.getValue() ;
    }
    
	void cal_tdst() { 
		String s1 = txt_torg.getText();
		Scanner s2 = new Scanner(s1);
		d_org=s2.nextDouble();
			
		if(a ==0)
			if(b==1) {
				d_dst = (d_org *1.8)+32;
			}
			else
				d_dst = d_org;
		else if(b==0)
			d_dst = (d_org-32.0)*5.0/9.0;
		else 
			d_dst = d_org;

		int idst = (int)(d_dst*100.0);
		double ddst = idst/100.0;
		
		TextField tf = txt_tdst;
		TextField tfo = txt_torg;
		print_dst(ddst,tf,tfo);
	}
	
}
