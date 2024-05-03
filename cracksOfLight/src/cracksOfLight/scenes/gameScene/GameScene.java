package cracksOfLight.scenes.gameScene;

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
	StackPane root;
	
	AnchorPane anchorPane;
	
	GamePane gamePane;
	
	HealthAndArmorBarsPane heathAndArmorBarsPane;
	
	InventoryPane inventoryPane;
	
	ToolbeltPane toolbeltPane;
	
	ToolbeltPopupPane toolbeltPopupPane;
	
	boolean goNorth, goSouth, goEast, goWest;
	
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
				System.out.println(event.getCode());
				switch (event.getCode()) 
				{
				case W:
					goNorth = true;
					break;
				case S:
					goSouth = true;
					break;
				case A:  
					goWest = true;
					break;
                case D: 
                	goEast = true;
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
            	System.out.println(event.getCode());
                switch (event.getCode()) 
                {
                case W:    
                	goNorth = false; 
                	break;
                case S:  
                	goSouth = false; 
                	break;
                case A:  
                	goWest = false; 
                	break;
                case D: 
                	goEast = false; 
                	break;
				default:
					break;
                }
            }
        });
		
		
	}
	
	private void initializeMovement()
	{
		double speed = 1.0;
		
		AnimationTimer timer = new AnimationTimer() 
		{
            @Override
            public void handle(long now) {
                double dx = 0, dy = 0;

                if (goNorth)
            	{
                	dy -= speed;
                	System.out.println("North " + goNorth);
            	}
                if (goSouth) 
            	{
                	dy += speed;
                	System.out.println("South " + goSouth);
            	}
                if (goEast) 
                {
                	dx += speed;
                	System.out.println("East " + goEast);
                }
                if (goWest) 
                {
                	dx -= speed;
                	System.out.println("West " + goWest);
                }

                gamePane.movePlayerBy(dx, dy);
            }
        };
        timer.start();
	}
}
