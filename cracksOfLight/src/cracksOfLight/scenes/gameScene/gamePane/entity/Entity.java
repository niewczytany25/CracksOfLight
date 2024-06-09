package cracksOfLight.scenes.gameScene.gamePane.entity;

import javafx.scene.shape.Rectangle;

public class Entity 
{
	public boolean goNorth, goSouth, goEast, goWest;
	
	public int facing = 0; // 0 - north, 1 - south, 2 - east, 3 - west
	
    public double dx, dy;
    public double speed;

	
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
	
	public int collisionBoxWidth;
	public int collisionBoxHeight;
	
	public boolean collision = false;
	
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
