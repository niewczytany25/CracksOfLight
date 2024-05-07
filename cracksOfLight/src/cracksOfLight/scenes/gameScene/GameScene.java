package cracksOfLight.scenes.gameScene;

import cracksOfLight.application.ApplicationStage;
import cracksOfLight.scenes.gameScene.gamePane.GamePane;
import cracksOfLight.scenes.gameScene.toolbeltPane.ToolbeltPane;
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
	
	ApplicationStage stage;
	
	StackPane root;
	
	AnchorPane anchorPane;
	
	GamePane gamePane;
	
	HealthAndArmorBarsPane heathAndArmorBarsPane;
	
	public InventoryPane inventoryPane;
	
	//ToolbeltPaneOld toolbeltPane;
	
	public ToolbeltPane toolbeltPane;
	
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
		AnchorPane.setBottomAnchor(heathAndArmorBarsPane, -4.0);
		
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
                case ESCAPE:
                	stage.setScene(stage.mainMenuScene);
                	break;
                case E:
                	stage.setScene(stage.craftingScene);
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
