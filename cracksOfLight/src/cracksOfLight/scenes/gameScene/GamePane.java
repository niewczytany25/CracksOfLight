package cracksOfLight.scenes.gameScene;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import cracksOfLight.scenes.gameScene.tile.TileManager;
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
	//tile sizes
	
	private int tilePixelSize = 16;
	private int sizeMultiplayer = 2;
	
	public int tileSize = tilePixelSize * sizeMultiplayer;
	
	//tileset
	
	TileManager tileManager;
	
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
	
	
	String mapSpriteLocation = "/resources/tlo.png";
	Image mapSprite;
	ImageView mapImageView;
	

	
	// fields for initializePlayer()
	
	public Rectangle player;
	public int playerWidth = 16*sizeMultiplayer;
	public int playerHeight = 2*16*sizeMultiplayer;
	
	public int playerWorldPositionX = 0 * tileSize;
	public int playerWorldPositionY = 0 * tileSize;
	
	public int playerScreenPositionX;
	public int playerScreenPositionY;
	
	
	public GamePane()
	{
		this.setPrefSize(paneSizeX, paneSizeY);
		
		initializeBackground();
		
		initializeTileset();
		
		initializePlayer();
		
		
	}
	
	private void initializeBackground()
	{
		backgroundFill = new BackgroundFill(Color.DARKGREY, null, getInsets());
		
		background = new Background(backgroundFill);
		
		this.setBackground(background);
	}
	
	/*
	private void initializeMap()
	{
		mapSprite = new Image(getClass().getResourceAsStream(mapSpriteLocation), imageSizeX*sizeMultiplayer, imageSizeY*sizeMultiplayer, false, false);
		mapImageView = new ImageView();
		mapImageView.setImage(mapSprite);
		
		this.getChildren().add(mapImageView);
		
		mapImageView.setX(0);
		mapImageView.setY(0);
		
	}
	*/
	
	private void initializeTileset()
	{
		tileManager = new TileManager(this);
		
	}
	
	private void initializePlayer()
	{
		playerScreenPositionX = paneSizeX/2 - playerWidth/2;
		playerScreenPositionY = paneSizeY/2 - playerHeight/2;
		
		player = new Rectangle(playerScreenPositionX, playerScreenPositionY, playerWidth, playerHeight);
		
		player.setX(playerScreenPositionX);
		player.setY(playerScreenPositionY);
		
		player.setFill(Color.MEDIUMPURPLE);
		player.setStroke(Color.BLACK);
		
		this.getChildren().add(player);
		
		tileManager.moveMap(playerWorldPositionX, playerWorldPositionY);
	}
	
	void movePlayerBy(double dx, double dy) 
	{
        if (dx == 0 && dy == 0) return;
        
        System.out.println("dr ( " + dx + " , " + dy + " )");
        System.out.println("initial pos ( " + playerWorldPositionX + " , " + playerWorldPositionY + " )");
        
        playerWorldPositionX += dx;
        playerWorldPositionY += dy;
        
        System.out.println("end pos ( " + playerWorldPositionX + " , " + playerWorldPositionY + " )");

        tileManager.moveMap(playerWorldPositionX, playerWorldPositionY);
    }
	
	
}