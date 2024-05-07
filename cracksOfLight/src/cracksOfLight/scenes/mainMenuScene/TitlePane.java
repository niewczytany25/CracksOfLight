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

public class TitlePane extends StackPane 
{
	private Image imageBackground;
	private BackgroundSize backgroundSize;
	private BackgroundImage backgroundImage;
	private Background background;
	
	private Font font;
	
	private Label title;
	
	public TitlePane(Font font)
	{
		this.setPrefSize(224, 96);
		
		this.font = font;
		
		initializeBackground();
		initializeTitle();
	}

	private void initializeBackground()
	{
		imageBackground = new Image(getClass().getResourceAsStream("/resources/mainMenu/gameTitle.png"), 224, 96, true, false);
		
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
		title = new Label("Cracks Of Light");
        title.setLayoutX(0);
        title.setLayoutY(0);
        title.setFont(font);
        title.setFont(new Font(27));
        this.getChildren().add(title);
	}
}
