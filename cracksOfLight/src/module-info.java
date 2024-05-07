module cracksOfLight {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	
	opens cracksOfLight.application to javafx.graphics, javafx.fxml;
}
