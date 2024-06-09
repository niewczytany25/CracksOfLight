package cracksOfLight.scenes.gameScene.healthAndArmorBar;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HealthAndArmorBarsPaneOld extends AnchorPane 
{
	
	double paneSizeX = 32;
	double paneSizeY = 144;
	
	
	String backgroundLocation = "/resources/HealthAndArmorBarsPaneBackground.png";
	Image backgroundImageSprite;
	BackgroundImage backgroundImage;
	Background background;
	
	
	double heartAndArmorSize = 14.0;
	
	int healthAmount = 10;
	int armorAmount = 10;
	
	GridPane barsGridPane;
	
	
	public HealthAndArmorBarsPaneOld()
	{
		this.setPrefSize(paneSizeX, paneSizeY);
		
		initializeBackground();
		initializeBars();
	}
	
	private void initializeBackground()
	{
		backgroundImageSprite = new Image(getClass().getResourceAsStream(backgroundLocation), paneSizeX, paneSizeY, false, false);
		
		backgroundImage = new BackgroundImage(backgroundImageSprite, 
				BackgroundRepeat.NO_REPEAT, 
				BackgroundRepeat.NO_REPEAT, 
				BackgroundPosition.DEFAULT, 
				BackgroundSize.DEFAULT);
		
		background = new Background(backgroundImage);
		this.setBackground(background);
	}
	
	private void initializeBars()
	{
       barsGridPane = new GridPane(2, 10);
       barsGridPane.setHgap(-0.5);
       barsGridPane.setVgap(-0.5);
       
       barsGridPane.setLayoutX(4);
       barsGridPane.setLayoutY(4);
       
		for (int i = 0; i < healthAmount; i++) 
		{
            Rectangle heart = createSquare(Color.RED);
            barsGridPane.add(heart, 1, i);
        }

        for (int i = 0; i < armorAmount; i++) 
        {
            Rectangle armor = createSquare(Color.GRAY);
            barsGridPane.add(armor, 0, i);
        }
        
        this.getChildren().add(barsGridPane);
        
        
	}
	
	private Rectangle createSquare(Color color) 
	{
        Rectangle square = new Rectangle(heartAndArmorSize - 1 , heartAndArmorSize - 1, color);
        square.setStroke(Color.BLACK);
        return square;
    }
}
