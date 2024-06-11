package cracksOfLight.scenes.gameScene;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class InventoryPane extends Pane 
{
	double paneSizeX = 148;
	double paneSizeY = 76;
	
	Pane pane;
	GridPane inventoryGridPane;
	
	StackPane woodPane, stonePane, leatherPane, copperPane, ironPane, goldPane;
	StackPane[] itemPanes = { woodPane, stonePane, leatherPane, copperPane, ironPane, goldPane};
	
	Label woodLabel, stoneLabel, leatherLabel, copperLabel, ironLabel, goldLabel;
	Label[] itemLabels = { woodLabel, stoneLabel, leatherLabel, copperLabel, ironLabel, goldLabel};
	
	String[] itemNames = {"Wood", "Stone", "Leather", "Copper", "Iron", "Gold"};
	
	public int woodAmount = 0, stoneAmount = 0, leatherAmount = 0, copperAmount = 0, ironAmount = 0, goldAmount = 0;
	public int[] itemAmounts = {woodAmount, stoneAmount, leatherAmount, copperAmount, ironAmount, goldAmount};
	
	double gridSizeX = 72;
	double gridSizeY = 24;
	private Rectangle mainBackground;
	
	public InventoryPane()
	{
		super();
		this.setPrefSize(paneSizeX, paneSizeY);
		
		initializeBackground();
		initializeIventoryGrid();
	}
	
	private void initializeBackground()
	{
		mainBackground = new Rectangle(0, 0, paneSizeX, paneSizeY);
		mainBackground.setStroke(Color.BLACK);
		mainBackground.setFill(Color.rgb(134, 198, 154));
		this.getChildren().add(mainBackground);
	}
	
	private void initializeIventoryGrid()
	{
		pane = new Pane();
		pane.setPrefSize(gridSizeX*2, gridSizeY*3);
		this.getChildren().add(pane);
		
		inventoryGridPane = new GridPane(2, 3);
		pane.getChildren().add(inventoryGridPane);
		
		inventoryGridPane.setHgap(0);
		inventoryGridPane.setVgap(0);
		
		for(int i = 0; i < 6; i++)
		{
			itemPanes[i] = new StackPane();
			itemLabels[i] = new Label(itemAmounts[i] + "x " +  itemNames[i]);
			itemPanes[i].getChildren().add(itemLabels[i]);
			
			itemPanes[i].setPrefSize(gridSizeX, gridSizeY);
			
			int row = i % 3; // Oblicz indeks wiersza
		    int col = i / 3; // Oblicz indeks kolumny
		    
		    GridPane.setConstraints(itemPanes[i], col, row);
		    inventoryGridPane.getChildren().add(itemPanes[i]);
		}
	}
	
	public void updateLabels()
	{
		for(int i = 0; i < 6; i++)
		{
			itemLabels[i].setText(itemAmounts[i] + "x " +  itemNames[i]);
		}
	}
}
