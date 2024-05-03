package cracksOfLight.scenes.mainMenuScene;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class StartButtonPane extends StackPane 
{
	private Image imageBackground;
	private BackgroundSize backgroundSize;
	private BackgroundImage backgroundImage;
	private Background background;
	
	private Font font;
	
	private Label text;
	
	
	public StartButtonPane(Font font)
	{
		this.setPrefSize(128, 48);
		
		this.font = font;
		initializeBackground();
		initializeTitle();
	}
	
	private void initializeBackground()
	{
		imageBackground = new Image(getClass().getResourceAsStream("/resources/mainMenu/MainMenuButtonPlaneBackground.png"), 128, 48, true, false);
		
		backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, false);
		backgroundImage = new BackgroundImage(imageBackground, 
				BackgroundRepeat.REPEAT, 
				BackgroundRepeat.REPEAT, 
				BackgroundPosition.DEFAULT, 
				backgroundSize);
		
		background = new Background(backgroundImage);
		
		this.setBackground(background);
	}
	
	private void initializeTitle()
	{
		text = new Label("Start");
		text.setLayoutX(0);
		text.setLayoutY(0);
		text.setFont(font);
		text.setFont(new Font(15));
        this.getChildren().add(text);
	}
}
