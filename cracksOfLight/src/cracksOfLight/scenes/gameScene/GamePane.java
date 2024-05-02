package cracksOfLight.scenes.gameScene;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GamePane extends Pane
{
	// fields for constructor
	
	private int paneSizeX = 640;
	private int paneSizeY = 480;
	
	// fields for initializeBackground()
	

	
	BackgroundFill backgroundFill;
	
	Background background;
	
	// fields for initializeMap()
	
	Image image;
	
	int imageSizeX = 384;
	int imageSizeY = 256;
	int sizeMultiplayer = 2;
	
	String mapSpriteLocation = "/resources/tlo.png";
	Image mapSprite;
	ImageView mapImageView;
	

	
	// fields for initializePlayer()
	
	public Rectangle player;
	public int playerWidth = 16*sizeMultiplayer;
	public int playerHeight = 2*16*sizeMultiplayer;
	
	public int playerPositionX = 10;
	public int playerPositionY = 10;
	
	public GamePane()
	{
		this.setPrefSize(paneSizeX, paneSizeY);
		
		initializeBackground();
		
		initializeMap();
		
		initializePlayer();
		
		
	}
	
	private void initializeBackground()
	{
		backgroundFill = new BackgroundFill(Color.DARKGREY, null, getInsets());
		
		background = new Background(backgroundFill);
		
		this.setBackground(background);
	}
	
	private void initializeMap()
	{
		mapSprite = new Image(getClass().getResourceAsStream(mapSpriteLocation), imageSizeX*sizeMultiplayer, imageSizeY*sizeMultiplayer, false, false);
		mapImageView = new ImageView();
		mapImageView.setImage(mapSprite);
		
		this.getChildren().add(mapImageView);
		
		mapImageView.setX(0);
		mapImageView.setY(0);
		
	}
	
	private void initializePlayer()
	{
		player = new Rectangle(playerPositionX, playerPositionY, playerWidth, playerHeight);
		
		player.setFill(Color.MEDIUMPURPLE);
		player.setStroke(Color.BLACK);
		
		player.setX(paneSizeX/2 - playerWidth/2);
		player.setY(paneSizeY/2 - playerHeight/2);
		
		this.getChildren().add(player);
	}
	
	void moveHeroBy(double dx, double dy) 
	{
        if (dx == 0 && dy == 0) return;
        
        System.out.println("d ( " + dx + " , " + dy + " )");
        System.out.println("d ( " + player.getLayoutX() + " , " + player.getLayoutY() + " )");
        
        double x = mapImageView.getLayoutX() - dx;
        double y = mapImageView.getLayoutY() - dy;
        
        System.out.println("d ( " + x + " , " + y + " )");

        moveHeroTo(x, y);
    }
	
	private void moveHeroTo(double x, double y) 
	{
		mapImageView.setLayoutX(x);
		mapImageView.setLayoutY(y);
        
    }
	
	
}