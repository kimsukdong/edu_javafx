package application;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SampleController {


	@FXML
	private TextField txt_km;

	@FXML
	private TextField txt_mile;

	@FXML
	void onClickButton(ActionEvent event) {
		int imile,ikm;
		double km, mile;
		try {
			if(txt_km.getText() != "") {
				km = Double.parseDouble(txt_km.getText());
				imile =(int) (km/1.6 *100);
				txt_mile.setText(""+imile/100.0);
			} else if(txt_mile.getText() != "") {
				mile = Double.parseDouble(txt_mile.getText());
				ikm = (int)(1.6*mile*100);
				txt_km.setText(""+ikm/100.0);
			} else
				JOptionPane.showMessageDialog(null, "No data");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Input Error");
		}
		
	}
	
    @FXML
    void onClickClear(ActionEvent event) {
    	txt_km.setText("");
    	txt_mile.setText("");
    }

}
