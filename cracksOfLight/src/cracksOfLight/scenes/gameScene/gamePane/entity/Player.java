package cracksOfLight.scenes.gameScene.gamePane.entity;

import cracksOfLight.scenes.gameScene.gamePane.GamePane;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends Entity 
{
	boolean debuggingMode = false;
	
    int counter = 0;
    int movementStage = 0;
    	
	GamePane gamePane;
	
	ImageView[][] playerSprites;
	
	public ImageView displayedSprite;
	
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
		
		speed = 2.0;
		
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
		
		worldPositionX = 5 * gamePane.tileSize;
		worldPositionY = 5 * gamePane.tileSize;
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
		collisionBoxHeight = height/4;
		if(debuggingMode)
		{
			System.out.println("Size " + collisionBoxWidth + " " + collisionBoxHeight);
		}
		
		
		collisionBoxScreenPositionX = screenPositionX + width/4;
		collisionBoxScreenPositionY = screenPositionY + 3 * height/4;
		if(debuggingMode)
		{
			System.out.println("Screen pos " + screenPositionX + " " + screenPositionY);
		}
		
		
		collisionBoxWorldPositionX = worldPositionX + width/4;
		collisionBoxWorldPositionY = (int) (worldPositionY + 2.5 * height/4);
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
	
	public void update()
	{
		dx = 0;
		dy = 0;
		/*
		if (goNorth)
    	{
        	dy -= speed;
        	if(debuggingMode)
        	{
        		System.out.println("North " + goNorth);
        	}
    	}
        if (goSouth) 
    	{
        	dy += speed;
        	if(debuggingMode)
        	{
        		System.out.println("South " + goSouth);
        	}
    	}
        if (goEast) 
        {
        	dx += speed;
        	if(debuggingMode)
        	{
        		System.out.println("East " + goEast);
        	}
        }
        if (goWest) 
        {
        	dx -= speed;
        	if(debuggingMode)
        	{
        		System.out.println("West " + goWest);
        	}
        }
		*/
        
        
        gamePane.collisionChecker.checkTile(this);
        
        gamePane.movePlayerBy(dx, dy);
        
        if(goNorth)
        {
        	setSprite(2, movementStage);
        }
        else if (goSouth) 
        {
        	setSprite(1, movementStage);
		}
        else if (goEast) 
        {
        	setSprite(3, movementStage);
		}
        else if (goWest) 
        {
        	setSprite(0, movementStage);
		}
        
        if(counter > 12)
        {
        	counter = 0;
        	movementStage++;
        	movementStage = movementStage % 4;
        }
        else 
        {
			counter++;
		}
	}
	
 	public void setSprite(int direction, int movementStage)
	{
		displayedSprite.setViewport(playerSprites[direction][movementStage].getViewport());
		if(debuggingMode)
		{
			System.out.println("Image set to " + direction + " " + movementStage);
		}
	}
	
	public ImageView getSprite()
	{
		return displayedSprite;
	}
}
