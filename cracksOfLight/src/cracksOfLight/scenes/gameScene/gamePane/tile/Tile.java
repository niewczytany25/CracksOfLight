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
		case 2: 
			{
				this.setImage(tileImages[2]);
				collision = true;
				break;
			}
		case 3: 
			{
				this.setImage(tileImages[3]);
				collision = true;
				break;
			}
		case 4:
			{
				this.setImage(tileImages[4]);
				collision = true;
				break;
			}
		case 5:
			{
				this.setImage(tileImages[5]);
				collision = true;
				break;
			}
		case 6:
			{
				this.setImage(tileImages[6]);
				collision = true;
				break;
			}
		}
	}
}
