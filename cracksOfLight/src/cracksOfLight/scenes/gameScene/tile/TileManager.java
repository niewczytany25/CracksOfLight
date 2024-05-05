package cracksOfLight.scenes.gameScene.tile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cracksOfLight.scenes.gameScene.GamePane;
import javafx.scene.image.Image;

public class TileManager{
	
	GamePane gamePane;
	
	int[][] tileMap;
	
	Tile[][] tiles;
	
	Image[] tileImages;
	
	int screenX;
	int screenY;
	
	public TileManager(GamePane gamePane)
	{
		this.gamePane = gamePane;
		System.out.println("gp");
		
		System.out.println("tt");
		
		tileMap = loadTileMapFromFile("C:\\Users\\Admin\\git\\CracksOfLight\\cracksOfLight\\src\\resources\\maps\\map.txt");
		System.out.println("tilemap");
		
		for (int i = 0; i < tileMap.length; i++) 
		{
            for (int j = 0; j < tileMap[0].length; j++) 
            {
                System.out.print(tileMap[i][j] + " ");
            }
            System.out.print("aha \n");
        }
		
		
		System.out.println("tiletypes");
		
		tiles = new Tile[tileMap.length][tileMap[0].length];
		System.out.println("tiles");
		
		tileImages = new Image[10];
		
		tileImages[0] = new Image(getClass().getResourceAsStream("/resources/tiles/stoneFlor.png"), gamePane.tileSize, gamePane.tileSize, false, false);
		tileImages[1] = new Image(getClass().getResourceAsStream("/resources/tiles/stoneWall.png"), gamePane.tileSize, gamePane.tileSize, false, false);
		
		
		for (int i = 0; i < tileMap.length; i++) 
		{
			System.out.println("i " + i);
			
			for (int j = 0; j < tileMap[0].length; j++) 
            {
				System.out.println("j " + j);
				
				tiles[i][j] = new Tile(tileMap[i][j], gamePane.tileSize, tileImages);
                tiles[i][j].setLayoutX(j * gamePane.tileSize);
                tiles[i][j].setLayoutY(i * gamePane.tileSize);

				System.out.println("Add " + i + " " + j);
            }
        }
		
		for(int i = 0; i < tiles.length; i++)
		{
			System.out.println("i " + i);
			for(int j = 0; j < tiles[0].length; j++)
			{
				System.out.println("j " + j);
				
				gamePane.getChildren().add(tiles[i][j]);
				
				System.out.println("Add " + i + " " + j);
			}
		}
	}
	
	/*
    private int[][] loadTileMapFromFile(String filePath) 
    {
        int[][] tileMap = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            int rowCount = 0;
            while ((line = reader.readLine()) != null) 
            {
                if (tileMap == null) 
                {
                    String[] parts = line.split(" ");
                    tileMap = new int[parts.length][];
                }
                String[] parts = line.split(" ");
                tileMap[rowCount] = new int[parts.length];
                for (int i = 0; i < parts.length; i++) 
                {
                    tileMap[rowCount][i] = Integer.parseInt(parts[i]);
                }
                rowCount++;
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return tileMap;
    }*/
	
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
	
	public void moveMap(int playerPositionX, int playerPositionY)
	{
		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[0].length; j++)
			{
				if(true)
				{
					tiles[i][j].setLayoutX(i * gamePane.tileSize - playerPositionX + gamePane.playerScreenPositionX); 
					tiles[i][j].setLayoutY(j * gamePane.tileSize - playerPositionY + gamePane.playerScreenPositionY); 
				}
			}
		}
		

		System.out.println("Pos set to " + playerPositionX + " " + playerPositionY);
	}
    
}
