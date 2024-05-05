package cracksOfLight.scenes.gameScene;

import cracksOfLight.scenes.gameScene.gamePane.GamePane;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class GameScene extends Scene 
{
	boolean debuggingMode = false;
	
	StackPane root;
	
	AnchorPane anchorPane;
	
	GamePane gamePane;
	
	HealthAndArmorBarsPane heathAndArmorBarsPane;
	
	InventoryPane inventoryPane;
	
	ToolbeltPane toolbeltPane;
	
	ToolbeltPopupPane toolbeltPopupPane;
	
	public GameScene()
	{
		super(new Pane());
		root = new StackPane();
		super.setRoot(root);
		
		initializeEventHandlers();
		initializeMovement();
		
		gamePane = new GamePane();
		root.getChildren().add(gamePane);
		
		anchorPane = new AnchorPane();
		
		heathAndArmorBarsPane = new HealthAndArmorBarsPane();
		
		AnchorPane.setRightAnchor(heathAndArmorBarsPane, 0.0);
		AnchorPane.setBottomAnchor(heathAndArmorBarsPane, -4.0);
		
		inventoryPane = new InventoryPane();
		
		AnchorPane.setTopAnchor(inventoryPane, 0.0);
		AnchorPane.setLeftAnchor(inventoryPane, 0.0);
		
		toolbeltPane = new ToolbeltPane();
		
		AnchorPane.setBottomAnchor(toolbeltPane, -4.0);
		AnchorPane.setLeftAnchor(toolbeltPane, 0.0);
		
		toolbeltPopupPane = new ToolbeltPopupPane();
		
		AnchorPane.setBottomAnchor(toolbeltPopupPane, 32.0 + 3);
		
		int overWhatTool = -1; // helmet - 0 , chestplate - 1 , pants - 2 , boots - 3 , pickaxe - 4 , sword - 5
		
		AnchorPane.setLeftAnchor(toolbeltPopupPane, overWhatTool*32.0 - 4.5);
		
		anchorPane.getChildren().addAll(heathAndArmorBarsPane, inventoryPane, toolbeltPane, toolbeltPopupPane);
		
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
				
				switch (event.getCode()) 
				{
				case W:
					gamePane.player.goNorth = true;
					break;
				case S:
					gamePane.player.goSouth = true;
					break;
				case A:  
					gamePane.player.goWest = true;
					break;
                case D: 
                	gamePane.player.goEast = true;
                	break;
				default:
					break;
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
        });
		
		
	}
	
	private void initializeMovement()
	{		
		AnimationTimer timer = new AnimationTimer() 
		{
			@Override
            public void handle(long now) 
			{
				gamePane.player.update();
            }
        };
        timer.start();
	}
}
