package cracksOfLight.scenes.gameScene.toolbeltPane;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ToolbeltPane extends Pane
{
	public Image itemBackground;
	
	public Image itemTextures;
	
	public Rectangle2D[][] toolImages;

	Rectangle mainBackground;
	
	public ToolbeltItem[] items;
	
	
	public ToolbeltPane() 
	{
	    this.setPrefSize(18 * 2 * 6 , 18 * 2 * 1);
	    
	    toolImages = new Rectangle2D[5][6];
	    
	    initializeImages();
	    
	    items = new ToolbeltItem[6];
	    
	    initializeItemBackgrounds();
	    
	    //items[0].setItem(toolImages[4][0]);
	    //items[1].setItem(toolImages[2][1]);
	}
	
	private void initializeImages()
	{
		itemBackground = new Image(getClass().getResourceAsStream("/resources/itemBackground.png"), 18 * 2, 18 * 2, true, false);
		itemTextures = new Image(getClass().getResourceAsStream("/resources/itemTextures.png"), 6 * 16 * 2, 5 * 18 * 2, true, false);
		
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				toolImages[i][j] = new Rectangle2D(j * 16 * 2, i * 16 * 2 , 16 * 2, 16 * 2);
				if(toolImages[i][j] == null)
				{
					System.out.println(i + " " + j);
				}
			}
		}
	}
	
	private void initializeItemBackgrounds()
	{
		mainBackground = new Rectangle(0, 0, 18 * 2 * 6, 18 * 2 * 1);
		mainBackground.setStroke(Color.rgb(93, 155, 121));
		this.getChildren().add(mainBackground);
		
		for(int i = 0; i < 6; i++)
		{
			items[i]= new ToolbeltItem(itemBackground, itemTextures, toolImages[0][i]);
			items[i].setLayoutX(i * 18 * 2);
			items[i].setLayoutY(0);
			
			this.getChildren().add(items[i]);
		}
	}
}
