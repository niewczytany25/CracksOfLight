module cracksOfLight {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	requires java.logging;
	requires javafx.media;
	
	opens cracksOfLight.application to javafx.graphics, javafx.fxml;
}
