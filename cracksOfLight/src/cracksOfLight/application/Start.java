package cracksOfLight.application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Start extends Application 
{
	ApplicationStage appStage = new ApplicationStage();
	
	@Override
	public void start(Stage stage) throws Exception 
	{
		stage = appStage;
		
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
