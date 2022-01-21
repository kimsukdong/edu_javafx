module Javafx_ex {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
	opens javafxex to javafx.graphics, javafx.fxml;
}
