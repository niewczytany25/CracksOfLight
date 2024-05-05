package cracksOfLight.scenes.gameScene.gamePane.tile;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tile extends ImageView
{
	public boolean collision = false;
	public int type;
	public int tileSize;
	
	public Tile(int type, int tileSize, Image[] tileImages)
	{
		super();
		
		this.type = type;
		this.tileSize = tileSize;
		
		switch (type) 
		{
		case 0: 
			{
				this.setImage(tileImages[0]);
				break;
			}
		case 1: 
			{
				this.setImage(tileImages[1]);
				collision = true;
				break;
			}
		}
	}
}
