package cracksOfLight.scenes.gameScene;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import cracksOfLight.scenes.gameScene.entity.Player;
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
	
	public int paneSizeX = 640;
	public int paneSizeY = 480;
	
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
	
	public Player player;
	
	
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
	
	private void initializeTileset()
	{
		tileManager = new TileManager(this);
		
	}
	
	private void initializePlayer()
	{
		player = new Player(this);
		
		
		this.getChildren().add(player.displayedSprite);
		player.getSprite().setLayoutX(player.screenPositionX);
		player.getSprite().setLayoutY(player.screenPositionY);
		
		//this.getChildren().add(player.getCollisionBox());
		
		System.out.println("Dodano gracz: body dodany: " 
							+ this.getChildren().contains(player.getBody()) 
							+ ", collisionBox dodany: " 
							+ this.getChildren().contains(player.getCollisionBox()));
		
		
		tileManager.moveMap();
	}
	
	void movePlayerBy(double dx, double dy) 
	{
        if (dx == 0 && dy == 0) return;
        
        System.out.println("dr ( " + dx + " , " + dy + " )");
        System.out.println("initial pos ( " + player.worldPositionX + " , " + player.worldPositionY + " )");
        
        player.worldPositionX += dx;
        player.worldPositionY += dy;
        
        player.collisionBoxWorldPositionX += dx;
        player.collisionBoxWorldPositionY += dy;
        
        System.out.println("end pos ( " + player.worldPositionX + " , " + player.worldPositionY + " )");

        tileManager.moveMap();
    }
	
	
}