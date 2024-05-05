package cracksOfLight.scenes.gameScene.entity;

import javafx.scene.shape.Rectangle;

public class Entity 
{
	private Rectangle body;
	private Rectangle collisionBox;
	
	int width;
	int height;
	
	public int worldPositionX;
	public int worldPositionY;
	
	public int screenPositionX;
	public int screenPositionY;
	
	public int collisionBoxScreenPositionX;
	public int collisionBoxScreenPositionY;
	
	public int collisionBoxWorldPositionX;
	public int collisionBoxWorldPositionY;
	
	int collisionBoxWidth;
	int collisionBoxHeight;
	
	public Entity()
	{
		
	}
	
	
	
	
	
	

	public Rectangle getCollisionBox() {
		return collisionBox;
	}

	public void setCollisionBox(Rectangle collisionBox) {
		this.collisionBox = collisionBox;
	}

	public Rectangle getBody() {
		return body;
	}

	public void setBody(Rectangle body) {
		this.body = body;
	}
}
