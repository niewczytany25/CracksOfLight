package cracksOfLight.scenes.mainMenuScene;

import java.io.InputStream;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class MainMenuScene extends Scene 
{
	private Pane root;
	
	private TitlePane titlePane;
	private StartButtonPane startButtonPane;
	private SettingsButtonPane settingsButtonPane;
	private ExitButtonPane exitButtonPane;
	
	private Font font;
	
	private Image backgroundImageTile;
	private BackgroundSize backgroundSize;
	
	private BackgroundImage backgroundImage;
	
	private Background background;
	
	
	
	public MainMenuScene()
	{
		super(new Pane());
		
		
		
		initializeFonts();
		
		initializePane();
		
		initializeBackground();
		
		super.setRoot(root);
		
	}
	
	private void initializePane()
	{
        root = new Pane();
        
        int xxx = 30;
        
        titlePane = new TitlePane(font);
        titlePane.setLayoutX(96);
        titlePane.setLayoutY(192 - xxx);
        root.getChildren().add(titlePane);
        
        startButtonPane = new StartButtonPane(font);
        startButtonPane.setLayoutX(416);
        startButtonPane.setLayoutY(120 - xxx);
        root.getChildren().add(startButtonPane);
        
        settingsButtonPane = new SettingsButtonPane(font);
        settingsButtonPane.setLayoutX(416);
        settingsButtonPane.setLayoutY(216 - xxx);
        root.getChildren().add(settingsButtonPane);
        
        exitButtonPane = new ExitButtonPane(font);
        exitButtonPane.setLayoutX(416);
        exitButtonPane.setLayoutY(312 - xxx);
        root.getChildren().add(exitButtonPane);
    }
	
	private void initializeFonts()
	{
		try 
		{
            InputStream stream = getClass().getResourceAsStream("/resources/RobotoMono-Regular.ttf");
            font = Font.loadFont(stream, 30);
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
	}
	
	private void initializeBackground()
	{
		backgroundImageTile = new Image(getClass().getResourceAsStream("/resources/mainMenu/MainPageTile.png"), 64, 64, true, false);
		//backgroundImageTile.setSmoth(false);
		
		backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, false);
		backgroundImage = new BackgroundImage(backgroundImageTile, 
				BackgroundRepeat.REPEAT, 
				BackgroundRepeat.REPEAT, 
				BackgroundPosition.DEFAULT, 
				backgroundSize);
		
		background = new Background(backgroundImage);
		
		root.setBackground(background);
	}
	
}

