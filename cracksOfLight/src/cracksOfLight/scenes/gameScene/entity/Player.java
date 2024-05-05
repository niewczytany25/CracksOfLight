package cracksOfLight.scenes.gameScene.entity;

import cracksOfLight.scenes.gameScene.GamePane;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends Entity 
{
	GamePane gamePane;
	
	ImageView[][] playerSprites;
	
	public ImageView displayedSprite;
	
	boolean debuggingMode = true;
	
	Image playerSpritesImage;
	
	public Player(GamePane gamePane)
	{
		
		if(debuggingMode)
		{
			System.out.println("inicjalizacja player");
		}
		
		this.gamePane = gamePane;
		
		initializeSizes();
		
		setBody(new Rectangle(screenPositionX, screenPositionY,
							width, height));
		getBody().setFill(Color.MEDIUMPURPLE);
		getBody().setStroke(Color.BLACK);
		
		setCollisionBox(new Rectangle(collisionBoxScreenPositionX, collisionBoxScreenPositionY, 
									collisionBoxWidth, collisionBoxHeight));
		getCollisionBox().setFill(Color.RED);
		getCollisionBox().setStroke(Color.BLACK);
		
		initializeImages();
		
		displayedSprite = new ImageView(playerSpritesImage);
		
		setSprite(1, 0);
	}
	
	private void initializeSizes() 
	{
		if(debuggingMode)
		{
			System.out.println("Body:");
		}
		
		width = 1 * gamePane.tileSize;
		height = 2 * gamePane.tileSize;
		if(debuggingMode)
		{
			System.out.println("Szerokosc " + width + " Wysokosc " + height);
		}
		
		worldPositionX = 10 * gamePane.tileSize;
		worldPositionY = 10 * gamePane.tileSize;
		if(debuggingMode)
		{
			System.out.println("World pos " + worldPositionX + " " + worldPositionY);
		}
		
		
		screenPositionX = (int) (gamePane.paneSizeX)/2 - width/2;
		screenPositionY = (int) (gamePane.paneSizeY)/2 - height/2;
		if(debuggingMode)
		{
			System.out.println("Screen pos " + screenPositionX + " " + screenPositionY);
			
			System.out.println("Collison");
		}
		
		collisionBoxWidth = width/2;
		collisionBoxHeight = height/2;
		if(debuggingMode)
		{
			System.out.println("Size " + collisionBoxWidth + " " + collisionBoxHeight);
		}
		
		
		collisionBoxScreenPositionX = screenPositionX + width/4;
		collisionBoxScreenPositionY = screenPositionY + height/2;
		if(debuggingMode)
		{
			System.out.println("Screen pos " + screenPositionX + " " + screenPositionY);
		}
		
		
		collisionBoxWorldPositionX = worldPositionX + width/4;
		collisionBoxWorldPositionY = worldPositionY + height/2;
		if(debuggingMode)
		{
			System.out.println("World pos " + collisionBoxWorldPositionX + " " + collisionBoxWorldPositionY);
		}
		
	}

	private void initializeImages()
	{
		playerSprites = new ImageView[4][4];
		
		playerSpritesImage = new Image(getClass().getResourceAsStream("/resources/playerSprites.png"), 4 * gamePane.tileSize, 4 * 2 * gamePane.tileSize, false, false);
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				playerSprites[i][j] = new ImageView();
				
				playerSprites[i][j].setImage(playerSpritesImage);
				
				Rectangle2D vievportRectangle = new Rectangle2D(i * gamePane.tileSize, j * 2 * gamePane.tileSize, gamePane.tileSize, 2 * gamePane.tileSize);
				
				playerSprites[i][j].setViewport(vievportRectangle);
			}
		}
	}
	
	public void setSprite(int direction, int movementStage)
	{
		displayedSprite.setViewport(playerSprites[direction][movementStage].getViewport());
		System.out.println("Image set to " + direction + " " + movementStage);
	}
	
	public ImageView getSprite()
	{
		return displayedSprite;
	}
}
