package cracksOfLight.scenes.gameScene.gamePane.tile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cracksOfLight.scenes.gameScene.gamePane.GamePane;
import javafx.scene.image.Image;

public class TileManager{
	
	boolean debuginggMode = false;
	
	GamePane gamePane;
	
	public int[][] tileMap;
	
	public Tile[][] tiles;
	
	Image[] tileImages;
	
	int screenX;
	int screenY;
	
	public TileManager(GamePane gamePane)
	{
		this.gamePane = gamePane;
		
		tileMap = loadTileMapFromFile("src/resources/maps/map.txt");
		
		if(debuginggMode)
		{
			for (int i = 0; i < tileMap.length; i++) 
			{
	            for (int j = 0; j < tileMap[0].length; j++) 
	            {
	                System.out.print(tileMap[i][j] + " ");
	            }
	            System.out.print("aha \n");
	        }
		}
		
		tiles = new Tile[tileMap.length][tileMap[0].length];
		
		tileImages = new Image[10];
		
		tileImages[0] = new Image(getClass().getResourceAsStream("/resources/tiles/stoneFlor.png"), gamePane.tileSize, gamePane.tileSize, false, false);
		tileImages[1] = new Image(getClass().getResourceAsStream("/resources/tiles/stoneWall.png"), gamePane.tileSize, gamePane.tileSize, false, false);
		
		
		for (int i = 0; i < tileMap.length; i++) 
		{
			for (int j = 0; j < tileMap[0].length; j++) 
            {
				tiles[i][j] = new Tile(tileMap[i][j], gamePane.tileSize, tileImages);
                tiles[i][j].setLayoutX(j * gamePane.tileSize);
                tiles[i][j].setLayoutY(i * gamePane.tileSize);
            }
        }
		
		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[0].length; j++)
			{
				gamePane.getChildren().add(tiles[i][j]);
			}
		}
	}
	
	private int[][] loadTileMapFromFile(String filePath) {
	    int[][] tileMap = null;
	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
	    {
	        List<String> lines = new ArrayList<>();
	        String line;
	        while ((line = reader.readLine()) != null) 
	        {
	            lines.add(line);
	        }
	        int rowCount = lines.size();
	        tileMap = new int[rowCount][];
	        for (int i = 0; i < rowCount; i++) 
	        {
	            String[] parts = lines.get(i).trim().split("\\s+");
	            int colCount = parts.length;
	            tileMap[i] = new int[colCount];
	            for (int j = 0; j < colCount; j++) 
	            {
	                tileMap[i][j] = Integer.parseInt(parts[j]);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return tileMap;
	}
	
	public void moveMap()
	{
		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[0].length; j++)
			{
				if(true)
				{
					tiles[i][j].setLayoutX(i * gamePane.tileSize - gamePane.player.worldPositionX + gamePane.player.screenPositionX);
					
					tiles[i][j].setLayoutY(j * gamePane.tileSize - gamePane.player.worldPositionY + gamePane.player.screenPositionY); 
					
					if(     i * gamePane.tileSize + gamePane.tileSize > gamePane.player.worldPositionX - gamePane.player.screenPositionX &&
							i * gamePane.tileSize - gamePane.tileSize < gamePane.player.worldPositionX + gamePane.player.screenPositionX &&
							j * gamePane.tileSize - gamePane.tileSize < gamePane.player.worldPositionY + gamePane.player.screenPositionY &&
							j * gamePane.tileSize + gamePane.tileSize > gamePane.player.worldPositionY - gamePane.player.screenPositionY)
					{
						tiles[i][j].setVisible(true);
					}
					else 
					{
						tiles[i][j].setVisible(false);
					}
				}
			}
		}
	}
    
}
