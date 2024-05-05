package cracksOfLight.scenes.gameScene.gamePane;

import cracksOfLight.scenes.gameScene.gamePane.entity.Entity;

public class CollisionChecker 
{
	GamePane gamePane;
	
	public CollisionChecker(GamePane gamePane)
	{
		this.gamePane = gamePane;
		
		
	}
	
	public void checkTile(Entity entity)
	{
		int entityLeftWorldX = entity.collisionBoxWorldPositionX;
		int entityRightWorldX = entity.collisionBoxWorldPositionX + entity.collisionBoxWidth;
		
		int entityTopWorldY = entity.collisionBoxScreenPositionY;
		int entityBottomWorldY = entity.collisionBoxScreenPositionY - entity.collisionBoxWidth;
		
		int entityLeftCol = entityLeftWorldX / gamePane.tileSize;
		int entityRightCol = entityRightWorldX / gamePane.tileSize;
		
		int entityTopRow = entityTopWorldY / gamePane.tileSize;
		int entityBottomRow = entityBottomWorldY / gamePane.tileSize;
		
		if (entity.goNorth)
		{
			entityTopRow = (int) ((entityTopWorldY - entity.speed)/ gamePane.tileSize);
			
			if(gamePane.tileManager.tiles[entityLeftCol][entityTopRow].collision ||
					gamePane.tileManager.tiles[entityRightCol][entityTopRow].collision)
			{
				
			}
			else 
			{
				entity.dy = -entity.speed;
			}
			
			entityTopRow = entityTopWorldY / gamePane.tileSize;
		}
		if (entity.goSouth)
		{
			entityBottomRow = (int) ((entityBottomWorldY + entity.speed)/ gamePane.tileSize);
			
			if(gamePane.tileManager.tiles[entityLeftCol][entityBottomRow].collision ||
					gamePane.tileManager.tiles[entityRightCol][entityBottomRow].collision)
			{
				
			}
			else 
			{
				entity.dy = entity.speed;
			}
			
			entityBottomRow = entityBottomWorldY / gamePane.tileSize;
		}
		if (entity.goEast)
		{
			entityRightCol = (int) ((entityRightWorldX + entity.speed)/ gamePane.tileSize);
			
			if(gamePane.tileManager.tiles[entityRightCol][entityTopRow].collision ||
					gamePane.tileManager.tiles[entityRightCol][entityBottomRow].collision)
			{
				
			}
			else 
			{
				entity.dx = entity.speed;
			}
			
			entityRightCol = entityRightWorldX / gamePane.tileSize;
		}
		if (entity.goWest)
		{
			entityLeftCol = (int) ((entityLeftWorldX - entity.speed)/ gamePane.tileSize);
			
			if(gamePane.tileManager.tiles[entityLeftCol][entityTopRow].collision ||
					gamePane.tileManager.tiles[entityLeftCol][entityBottomRow].collision)
			{
				
			}
			else 
			{
				entity.dx = -entity.speed;
			}
			
			entityLeftCol = entityLeftWorldX / gamePane.tileSize;
		}
	}
}
