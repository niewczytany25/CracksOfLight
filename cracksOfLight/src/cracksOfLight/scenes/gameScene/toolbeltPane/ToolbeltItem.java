package cracksOfLight.scenes.gameScene.toolbeltPane;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ToolbeltItem extends Pane 
{
	ImageView backgroundView;
	
	ImageView itemView;
	
	Image itemTextures;
	
	
	
	public ToolbeltItem(Image backgroundImage, Image itemTextures, Rectangle2D rectangle2d)
	{
		this.setPrefSize(18 * 2, 18 * 2);
		
		backgroundView = new ImageView();
		backgroundView.setImage(backgroundImage);
		backgroundView.setLayoutX(0);
		backgroundView.setLayoutY(0);
		this.getChildren().add(backgroundView);
		
		itemView = new ImageView();
		itemView.setImage(itemTextures);
		itemView.setViewport(rectangle2d);
		itemView.setLayoutX(2);
		itemView.setLayoutY(2);
		this.getChildren().add(itemView);
		
	}
	
	public void setItem(Rectangle2D rectangle2d)
	{
		itemView.setViewport(rectangle2d);
	}
}
