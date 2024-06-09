package cracksOfLight.scenes.gameScene.gamePane;

import cracksOfLight.scenes.gameScene.gamePane.entity.Entity;

public class CollisionChecker 
{
    GamePane gamePane;
    boolean debuggingMode = false;

    public CollisionChecker(GamePane gamePane)
    {
        this.gamePane = gamePane;
    }

    public void checkTile(Entity entity)
    {
        int entityLeftWorldX = entity.collisionBoxWorldPositionX;
        int entityRightWorldX = entity.collisionBoxWorldPositionX + entity.collisionBoxWidth;

        int entityTopWorldY = entity.collisionBoxWorldPositionY; 
        int entityBottomWorldY = entity.collisionBoxWorldPositionY + entity.collisionBoxHeight;

        int entityLeftCol = entityLeftWorldX / gamePane.tileSize;
        int entityRightCol = entityRightWorldX / gamePane.tileSize;

        int entityTopRow = entityTopWorldY / gamePane.tileSize;
        int entityBottomRow = entityBottomWorldY / gamePane.tileSize;

        if(debuggingMode)
        {
	        System.out.println("Entity Position: (" + entityLeftWorldX + ", " + entityTopWorldY + ")");
	        System.out.println("Entity Columns: Left = " + entityLeftCol + ", Right = " + entityRightCol);
	        System.out.println("Entity Rows: Top = " + entityTopRow + ", Bottom = " + entityBottomRow);
        }


        if (entity.goNorth)
        {
            entityTopRow = (int) ((entityTopWorldY - entity.speed) / gamePane.tileSize);

            if(gamePane.tileManager.tiles[entityLeftCol][entityTopRow].collision ||
                gamePane.tileManager.tiles[entityRightCol][entityTopRow].collision)
            {
                entity.dy = 0; 
            }
            else 
            {
                entity.dy = -entity.speed;
            }
            
            if(debuggingMode)
            {
            	System.out.println("Checking North: TopRow = " + entityTopRow + ", Speed = " + entity.dy);
            }
            
        }

        if (entity.goSouth)
        {
            entityBottomRow = (int) ((entityBottomWorldY + entity.speed) / gamePane.tileSize);

            if(gamePane.tileManager.tiles[entityLeftCol][entityBottomRow].collision ||
                gamePane.tileManager.tiles[entityRightCol][entityBottomRow].collision)
            {
                entity.dy = 0; 
            }
            else 
            {
                entity.dy = entity.speed;
            }
            
            if(debuggingMode)
            {
            	System.out.println("Checking South: BottomRow = " + entityBottomRow + ", Speed = " + entity.dy);
            }
            
        }

        if (entity.goEast)
        {
            entityRightCol = (int) ((entityRightWorldX + entity.speed) / gamePane.tileSize);

            if(gamePane.tileManager.tiles[entityRightCol][entityTopRow].collision ||
                gamePane.tileManager.tiles[entityRightCol][entityBottomRow].collision)
            {
                entity.dx = 0; 
            }
            else 
            {
                entity.dx = entity.speed;
            }

            if(debuggingMode)
            {
            	System.out.println("Checking East: RightCol = " + entityRightCol + ", Speed = " + entity.dx);
            }
            
        }

        if (entity.goWest)
        {
            entityLeftCol = (int) ((entityLeftWorldX - entity.speed) / gamePane.tileSize);

            if(gamePane.tileManager.tiles[entityLeftCol][entityTopRow].collision ||
                gamePane.tileManager.tiles[entityLeftCol][entityBottomRow].collision)
            {
                entity.dx = 0; 
            }
            else 
            {
                entity.dx = -entity.speed;
            }

            if(debuggingMode)
            {
            	System.out.println("Checking West: LeftCol = " + entityLeftCol + ", Speed = " + entity.dx);
            }
            
        }
    }
}
