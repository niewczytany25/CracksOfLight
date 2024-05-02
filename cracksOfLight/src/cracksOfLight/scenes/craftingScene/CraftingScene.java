package cracksOfLight.scenes.craftingScene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CraftingScene extends Scene 
{
	StackPane root;
	GridPane gridPane;
	
	GridPane pickaxePane;
	
	StackPane pickaxeItemPane;
	
	StackPane pickaxeItemLabelPane;
	
	Label pickaxeCraftingLabel;
	
	Rectangle itemSprite;
	
	public CraftingScene()
	{
		super(new StackPane());
		root = new StackPane();
		super.setRoot(root);
		root.setPrefSize(640, 480);
		
		root.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		
		gridPane = new GridPane(2, 3);
		gridPane.setPrefSize(550, 390);
		gridPane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
		StackPane.setAlignment(gridPane, Pos.CENTER);
		root.getChildren().add(gridPane);
		
		gridPane.setPadding(new Insets(45));

		gridPane.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
		
		pickaxePane = new GridPane(2, 1);
		pickaxePane.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
		GridPane.setConstraints(pickaxePane, 0, 0);
		gridPane.getChildren().add(pickaxePane);
		
		pickaxeItemPane = new StackPane();
		GridPane.setConstraints(pickaxeItemPane, 0, 0);
		pickaxePane.getChildren().add(pickaxeItemPane);
		
		itemSprite = new Rectangle(64, 64, Color.BLACK);
		pickaxeItemPane.getChildren().add(itemSprite);
		
		pickaxeItemLabelPane = new StackPane();
		GridPane.setConstraints(pickaxeItemLabelPane, 1, 0);
		pickaxePane.getChildren().add(pickaxeItemLabelPane);
		
		pickaxeCraftingLabel = new Label("(Tier) Pickaxe \n Item1 x3 \n Item2 x4");
		pickaxeItemLabelPane.getChildren().add(pickaxeCraftingLabel);
		
		
	}
}
