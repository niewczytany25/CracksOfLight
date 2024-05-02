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
import javafx.scene.text.Font;

public class ToolbeltPane extends Pane
{
	
	double paneSizeX = 196;
	double paneSizeY = 36;
	
	String backgroundLocation = "/resources/ToolbeltMainPaneBackground.png";
	Image backgroundImageSprite;
	BackgroundImage backgroundImage;
	Background background;
	
	Pane pane;
	
	GridPane toolbeltGridPane;
	
	String[] toolNames = {"Helmet", "Chestplate", "Pants", "Boots", "Pickaxe", "Sword"};
	
	Label helmetLabel, chestplateLabel, pantsLabel, bootsLabel, pickaxeLabel, swordLabel;
	Label[] toolLabels = {helmetLabel, chestplateLabel, pantsLabel, bootsLabel, pickaxeLabel, swordLabel};
	
	StackPane helmetPane, chestplatePane, pantsPane, bootsPane, pickaxePane, swordPane;
	StackPane[] toolPanes = {helmetPane, chestplatePane, pantsPane, bootsPane, pickaxePane, swordPane};
	
	Rectangle helmetRectangle, chestplaterRectangle, pantsRectangle, bootsRectangle, pickaxerRectangle, swordrRectangle;
	Rectangle[] toolRectangles = {helmetRectangle, chestplaterRectangle, pantsRectangle, bootsRectangle, pickaxerRectangle, swordrRectangle};
	
	double toolGridSize = 32;
	
	public ToolbeltPane()
	{
		initializeBackground();
		initializeToolbet();
	}
	
	private void initializeBackground()
	{
		backgroundImageSprite = new Image(getClass().getResourceAsStream(backgroundLocation), paneSizeX, paneSizeY, false, false);
		
		backgroundImage = new BackgroundImage(backgroundImageSprite, 
				BackgroundRepeat.NO_REPEAT, 
				BackgroundRepeat.NO_REPEAT, 
				BackgroundPosition.DEFAULT, 
				BackgroundSize.DEFAULT);
		
		background = new Background(backgroundImage);
		this.setBackground(background);
	}
	
	private void initializeToolbet()
	{
		pane = new Pane();
		pane.setPrefSize(paneSizeX, paneSizeY);
		this.getChildren().add(pane);
		pane.setLayoutX(-0.5);
		pane.setLayoutY(4);
		
		toolbeltGridPane = new GridPane(6, 1);
		pane.getChildren().add(toolbeltGridPane);
		
		toolbeltGridPane.setHgap(-0.5);
		toolbeltGridPane.setVgap(-0.5);
		
		for(int i = 0; i < 6; i++)
		{
			toolPanes[i] = new StackPane();
			
			toolRectangles[i] = new Rectangle(toolGridSize - 0.5, toolGridSize - 0.5, Color.BLUE);
			toolPanes[i].getChildren().add(toolRectangles[i]);
			toolRectangles[i].setStroke(Color.BLACK);
			
			toolLabels[i]= new Label(toolNames[i]);
			toolLabels[i].setFont(new Font(10.0));
			toolLabels[i].setTextFill(Color.WHITE);
			toolPanes[i].getChildren().add(toolLabels[i]);
			
			toolPanes[i].setPrefSize(toolGridSize, toolGridSize);
			
			GridPane.setConstraints(toolPanes[i], i, 0);
			
			toolbeltGridPane.getChildren().add(toolPanes[i]);
		}
	}
	
	
}
