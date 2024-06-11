package cracksOfLight.scenes.gameScene;

import java.util.Random;

import cracksOfLight.application.ApplicationStage;
import cracksOfLight.scenes.gameScene.gamePane.GamePane;
import cracksOfLight.scenes.gameScene.healthAndArmorBar.HealthAndArmorBarsPaneOld;
import cracksOfLight.scenes.gameScene.healthAndArmorBar.HealthAndArmorBarsPane;
import cracksOfLight.scenes.gameScene.toolbeltPane.ToolbeltPane;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class GameScene extends Scene 
{
	boolean debuggingMode = false;
	
	ApplicationStage stage;
	
	StackPane root;
	
	AnchorPane anchorPane;
	
	public GamePane gamePane;
	
	public HealthAndArmorBarsPane heathAndArmorBarsPane;
	
	public InventoryPane inventoryPane;
	
	//ToolbeltPaneOld toolbeltPane;
	
	public ToolbeltPane toolbeltPane;
	
	boolean keyboardSettingsPlacecholder = false;
	
	public GameScene(ApplicationStage stage)
	{
		super(new Pane());
		root = new StackPane();
		super.setRoot(root);
		
		this.stage = stage;
		
		initializeEventHandlers();
		initializeMovement();
		
		gamePane = new GamePane();
		root.getChildren().add(gamePane);
		
		anchorPane = new AnchorPane();
		
		heathAndArmorBarsPane = new HealthAndArmorBarsPane();
		
		AnchorPane.setRightAnchor(heathAndArmorBarsPane, 0.0);
		AnchorPane.setBottomAnchor(heathAndArmorBarsPane, 0.0);
		
		inventoryPane = new InventoryPane();
		
		AnchorPane.setTopAnchor(inventoryPane, 0.0);
		AnchorPane.setLeftAnchor(inventoryPane, 0.0);
		
		//toolbeltPane = new ToolbeltPaneOld();
		toolbeltPane = new ToolbeltPane();
		
		AnchorPane.setBottomAnchor(toolbeltPane, 0.0);
		AnchorPane.setLeftAnchor(toolbeltPane, 0.0);
		
		anchorPane.getChildren().addAll(heathAndArmorBarsPane, inventoryPane, toolbeltPane);
		
		root.getChildren().add(anchorPane);
	}
	
	private void initializeEventHandlers()
	{
		this.setOnKeyPressed(new EventHandler<KeyEvent>() 
		{

			@Override
			public void handle(KeyEvent event) 
			{
				if(debuggingMode)
				{
					System.out.println(event.getCode());
				}
				
				
				
				if(stage.settingsScene.keyBinds == 1)
				{
				switch (event.getCode()) 
					{
					case W:
						gamePane.player.goNorth = true;
						gamePane.player.facing = 0;
						break;
					case S:
						gamePane.player.goSouth = true;
						gamePane.player.facing = 1;
						break;
					case A:  
						gamePane.player.goWest = true;
						gamePane.player.facing = 3;
						break;
	                case D: 
	                	gamePane.player.goEast = true;
	                	gamePane.player.facing = 2;
	                	break;
	                case ESCAPE:
	                	stage.setScene(stage.mainMenuScene);
	                	gamePane.player.goNorth = false;
	                	gamePane.player.goSouth = false;
	                	gamePane.player.goEast = false;
	                	gamePane.player.goWest = false;
	                	break;
	                case E:
	                	stage.setScene(stage.craftingScene);
					default:
						break;
					}
				}
				else
				{
					switch (event.getCode()) 
					{
					case UP:
						gamePane.player.goNorth = true;
						gamePane.player.facing = 0;
						break;
					case DOWN:
						gamePane.player.goSouth = true;
						gamePane.player.facing = 1;
						break;
					case LEFT:  
						gamePane.player.goWest = true;
						gamePane.player.facing = 3;
						break;
	                case RIGHT: 
	                	gamePane.player.goEast = true;
	                	gamePane.player.facing = 2;
	                	break;
	                case ESCAPE:
	                	stage.setScene(stage.mainMenuScene);
	                	gamePane.player.goNorth = false;
	                	gamePane.player.goSouth = false;
	                	gamePane.player.goEast = false;
	                	gamePane.player.goWest = false;
	                	break;
	                case E:
	                	stage.setScene(stage.craftingScene);
					default:
						break;
					}
				}
				
				

			}
		});
		
		this.setOnKeyReleased(new EventHandler<KeyEvent>() 
		{
            @Override
            public void handle(KeyEvent event) 
            {
            	if(debuggingMode)
            	{
            		System.out.println(event.getCode());
            	}
            	
            	if(stage.settingsScene.keyBinds == 1)
            	{
                    switch (event.getCode()) 
                    {
                    case W:    
                    	gamePane.player.goNorth = false; 
                    	break;
                    case S:  
                    	gamePane.player.goSouth = false; 
                    	break;
                    case A:  
                    	gamePane.player.goWest = false; 
                    	break;
                    case D: 
                    	gamePane.player.goEast = false; 
                    	break;
    				default:
    					break;
                    }
            	}
                else 
                {
                    switch (event.getCode()) 
                    {
                    case UP:    
                    	gamePane.player.goNorth = false; 
                    	break;
                    case DOWN:  
                    	gamePane.player.goSouth = false; 
                    	break;
                    case LEFT:  
                    	gamePane.player.goWest = false; 
                    	break;
                    case RIGHT: 
                    	gamePane.player.goEast = false; 
                    	break;
    				default:
    					break;
                    }
				}
			}
        });
		
		this.setOnMouseClicked(event -> {
			 if (event.getButton() == MouseButton.PRIMARY)
			 {
			 		int playerX = gamePane.player.collisionBoxWorldPositionX + gamePane.player.collisionBoxWidth/2;
			        int playerY = gamePane.player.collisionBoxWorldPositionY + gamePane.player.collisionBoxHeight/2;
			        
			        int playerCol = playerX / gamePane.tileSize;
			        int playerRow = playerY / gamePane.tileSize;
			        
			        Random random = new Random();
				 
				switch (gamePane.player.facing)
				{
					case 0: 
					{
				        playerRow--;
						break;
					}
					case 1: 
					{
				        playerRow++;
						break;
					}
					case 2: 
					{
				        playerCol++;
						break;
					}
					case 3: 
					{
				        playerCol--;
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + gamePane);
				}
				
				if(gamePane.tileManager.tiles[playerCol][playerRow].type != 0 || gamePane.tileManager.tiles[playerCol][playerRow].type != 1)
		        {
		        	if(gamePane.tileManager.tiles[playerCol][playerRow].type == 2)
		        	{
		        		inventoryPane.itemAmounts[0] += 1; //(random.nextInt(1) * random.nextInt(1))
		        		inventoryPane.itemAmounts[2] += 1;
		        		gamePane.tileManager.changeTile(playerRow, playerCol, 0);
		        		inventoryPane.updateLabels();
		        	}
		        	
		        	if(gamePane.tileManager.tiles[playerCol][playerRow].type == 3 && stage.craftingScene.pickaxeLevel >= 0)
		        	{
		        		inventoryPane.itemAmounts[1] += 1;
		        		gamePane.tileManager.changeTile(playerRow, playerCol, 0);
		        		inventoryPane.updateLabels();
		        	}
		        	
		        	if(gamePane.tileManager.tiles[playerCol][playerRow].type == 4 && stage.craftingScene.pickaxeLevel >= 1)
		        	{
		        		inventoryPane.itemAmounts[3] += 1;
		        		gamePane.tileManager.changeTile(playerRow, playerCol, 0);
		        		inventoryPane.updateLabels();
		        	}
		        	
		        	if(gamePane.tileManager.tiles[playerCol][playerRow].type == 5 && stage.craftingScene.pickaxeLevel >= 2)
		        	{
		        		inventoryPane.itemAmounts[4] += 1;
		        		gamePane.tileManager.changeTile(playerRow, playerCol, 0);
		        		inventoryPane.updateLabels();
		        	}
		        	
		        	if(gamePane.tileManager.tiles[playerCol][playerRow].type == 6 && stage.craftingScene.pickaxeLevel >= 3)
		        	{
		        		inventoryPane.itemAmounts[5] += 1;
		        		gamePane.tileManager.changeTile(playerRow, playerCol, 0);
		        		inventoryPane.updateLabels();
		        	}
		        	
		        }
			 }
		}); 
		
		
	}
	
	private void initializeMovement()
	{		
		/*
		AnimationTimer timer = new AnimationTimer() 
		{
			@Override
            public void handle(long now) 
			{
				gamePane.player.update();
            }
        };
        timer.start();
        */
        GameLoop gameLoop = new GameLoop(this);
        gameLoop.start();
	}
}
