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

public class ToolbeltPopupPane extends Pane 
{
	double paneSizeX = 40;
	double paneSizeY = 132;
	
	String backgroundLocation = "/resources/ToolbeltPopupPaneBackground.png";
	Image backgroundImageSprite;
	BackgroundImage backgroundImage;
	Background background;
	
	
	Pane pane;
	
	GridPane toolbeltPopupGridPane;
	
	String[] tierNames = {"None", "Copper", "Iron", "Gold"};
	
	Label noneLabel, copperLabel, ironLabel, goldLabel;
	Label[] tierLabels = {noneLabel, copperLabel, ironLabel, goldLabel};
	
	StackPane nonePane, copperPane, ironPane, goldPane;
	StackPane[] tierPanes = {nonePane, copperPane, ironPane, goldPane};
	
	Rectangle noneRectangle, copperRectangle, ironRectangle, goldRectangle;
	Rectangle[] tierRectangles = {noneRectangle, copperRectangle, ironRectangle, goldRectangle};
	
	Color colors[] = {Color.GRAY, Color.ORANGE, Color.LIGHTGRAY, Color.YELLOW};
	
	double tierGridSize = 32;
	
	public ToolbeltPopupPane()
	{
		initializeBackground();
		initializePopupToolbelt();
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
	
	private void initializePopupToolbelt()
	{
		pane = new Pane();
		pane.setPrefSize(paneSizeX, paneSizeY);
		this.getChildren().add(pane);
		
		toolbeltPopupGridPane = new GridPane(1, 4);
		pane.getChildren().add(toolbeltPopupGridPane);
		toolbeltPopupGridPane.setLayoutX(4.0);
		toolbeltPopupGridPane.setLayoutY(4.0);
		
		toolbeltPopupGridPane.setHgap(-1.0);
		toolbeltPopupGridPane.setVgap(-1.0);
		
		for(int i = 3; i > -1; i--)
		{
			tierPanes[i]= new StackPane();
			
			tierRectangles[i]= new Rectangle(tierGridSize, tierGridSize, colors[i]);
			tierPanes[i].getChildren().add(tierRectangles[i]);
			tierRectangles[i].setStroke(Color.BLACK);
			
			tierLabels[i]= new Label(tierNames[i]);
			tierLabels[i].setFont(new Font(10.0));
			tierLabels[i].setTextFill(Color.WHITE);
			tierPanes[i].getChildren().add(tierLabels[i]);
			
			tierPanes[i].setPrefSize(tierGridSize, tierGridSize);
			
			GridPane.setConstraints(tierPanes[i], 0, i);
			
			toolbeltPopupGridPane.getChildren().add(tierPanes[i]);
		}
		
	}
}
