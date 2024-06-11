package cracksOfLight.scenes.gameScene.gamePane.tile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cracksOfLight.scenes.gameScene.gamePane.GamePane;
import javafx.scene.image.Image;

public class TileManager{
	
	boolean debuginggMode = true;
	
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
		
		tiles = new Tile[tileMap[0].length][tileMap.length];
		
		tileImages = new Image[10];
		
		tileImages[0] = new Image(getClass().getResourceAsStream("/resources/tiles/stoneFlor.png"), gamePane.tileSize, gamePane.tileSize, false, false);
		tileImages[1] = new Image(getClass().getResourceAsStream("/resources/tiles/stoneWall.png"), gamePane.tileSize, gamePane.tileSize, false, false);
		tileImages[2] = new Image(getClass().getResourceAsStream("/resources/tiles/crate.png"), gamePane.tileSize, gamePane.tileSize, false, false);
		tileImages[3] = new Image(getClass().getResourceAsStream("/resources/tiles/stone.png"), gamePane.tileSize, gamePane.tileSize, false, false);
		tileImages[4] = new Image(getClass().getResourceAsStream("/resources/tiles/copperOre.png"), gamePane.tileSize, gamePane.tileSize, false, false);
		tileImages[5] = new Image(getClass().getResourceAsStream("/resources/tiles/ironOre.png"), gamePane.tileSize, gamePane.tileSize, false, false);
		tileImages[6] = new Image(getClass().getResourceAsStream("/resources/tiles/goldOre.png"), gamePane.tileSize, gamePane.tileSize, false, false);
		
		
		for (int i = 0; i < tileMap[0].length; i++) 
		{
			for (int j = 0; j < tileMap.length; j++) 
            {
				tiles[i][j] = new Tile(tileMap[j][i], gamePane.tileSize, tileImages);
                tiles[i][j].setLayoutX(i * gamePane.tileSize);
                tiles[i][j].setLayoutY(j * gamePane.tileSize);
            }
        }
		
		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[0].length; j++)
			{
				gamePane.getChildren().add(tiles[i][j]);
			}
		}
		
		//changeTile(4, 16, 0);
		generateStoneFlor();
		generateCopperFlor();
		generateIronFlor();
		generateGoldFlor();
	}
	
	private int[][] loadTileMapFromFile(String filePath) 
	{
		
		int[][] map = null;
	    
	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
	    {
	        List<String> lines = new ArrayList<>();
	        
	        String line;
	        
	        while ((line = reader.readLine()) != null) 
	        {
	            lines.add(line);
	        }
	        
	        int rowCount = lines.size();
	        
	        map = new int[rowCount][];
	        
	        for (int i = 0; i < rowCount; i++) 
	        {
	            String[] parts = lines.get(i).trim().split("\\s+");
	            
	            int colCount = parts.length;
	            
	            map[i] = new int[colCount];
	            
	            for (int j = 0; j < colCount; j++) 
	            {
	                map[i][j] = Integer.parseInt(parts[j]);
	            }
	            
	        }
	        
	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	    
	    return map;
	}
	
	public void moveMap()
	{
	    if (gamePane.player == null) 
	    {
	        return;
	    }
		
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
	
	public void changeTile(int row, int col, int type)
	{
	    if (row >= 0 && row < tiles.length && col >= 0 && col < tiles[0].length) {
	        int index = gamePane.getChildren().indexOf(tiles[col][row]);

	        tiles[col][row] = new Tile(type, gamePane.tileSize, tileImages);
	        tiles[col][row].setLayoutX(col * gamePane.tileSize);  
	        tiles[col][row].setLayoutY(row * gamePane.tileSize); 

	        gamePane.getChildren().set(index, tiles[col][row]);
	        moveMap();
	    }
	}
	
	void generateStoneFlor() 
	{
	    int rows = 11;
	    int cols = 16;
	    int[][] florLayout = new int[cols][rows];
	    Random random = new Random();

	    for (int i = 0; i < cols; i++) {
	        for (int j = 0; j < rows; j++) {
	            florLayout[i][j] = 0;
	        }
	    }
	    
	    for (int i = 0; i < 30; i++) {
	        int randomRow = random.nextInt(rows);
	        int randomCol = random.nextInt(cols);
	        florLayout[randomCol][randomRow] = 2;
	    }
	    
	    for (int i = 0; i < 25; i++) {
	        int randomRow = random.nextInt(rows);
	        int randomCol = random.nextInt(cols);
	        florLayout[randomCol][randomRow] = 3;
	    }

	    for (int i = 0; i < cols; i++) {
	        for (int j = 0; j < rows; j++) {
	            changeTile(i + 1, 20 + j, florLayout[i][j]);
	        }
	    }
	}
    
	void generateCopperFlor() 
	{
	    int rows = 22;
	    int cols = 11;
	    int[][] florLayout = new int[cols][rows];
	    Random random = new Random();

	    for (int i = 0; i < cols; i++) {
	        for (int j = 0; j < rows; j++) {
	            florLayout[i][j] = 0;
	        }
	    }
	    
	    for (int i = 0; i < 30; i++) {
	        int randomRow = random.nextInt(rows);
	        int randomCol = random.nextInt(cols);
	        florLayout[randomCol][randomRow] = 3;
	    }
	    
	    for (int i = 0; i < 25; i++) {
	        int randomRow = random.nextInt(rows);
	        int randomCol = random.nextInt(cols);
	        florLayout[randomCol][randomRow] = 4;
	    }

	    for (int i = 0; i < cols; i++) {
	        for (int j = 0; j < rows; j++) {
	            changeTile(i + 18, 20 + j, florLayout[i][j]);
	        }
	    }
	}
	
	void generateIronFlor() 
	{
	    int rows = 15;
	    int cols = 11;
	    int[][] florLayout = new int[cols][rows];
	    Random random = new Random();

	    for (int i = 0; i < cols; i++) {
	        for (int j = 0; j < rows; j++) {
	            florLayout[i][j] = 0;
	        }
	    }
	    
	    for (int i = 0; i < 30; i++) {
	        int randomRow = random.nextInt(rows);
	        int randomCol = random.nextInt(cols);
	        florLayout[randomCol][randomRow] = 4;
	    }
	    
	    for (int i = 0; i < 25; i++) {
	        int randomRow = random.nextInt(rows);
	        int randomCol = random.nextInt(cols);
	        florLayout[randomCol][randomRow] = 5;
	    }

	    for (int i = 0; i < cols; i++) {
	        for (int j = 0; j < rows; j++) {
	            changeTile(i + 30, 27 + j, florLayout[i][j]);
	        }
	    }
	}
	void generateGoldFlor() 
	{
	    int rows = 11;
	    int cols = 13;
	    int[][] florLayout = new int[cols][rows];
	    Random random = new Random();

	    for (int i = 0; i < cols; i++) {
	        for (int j = 0; j < rows; j++) {
	            florLayout[i][j] = 0;
	        }
	    }
	    
	    for (int i = 0; i < 30; i++) {
	        int randomRow = random.nextInt(rows);
	        int randomCol = random.nextInt(cols);
	        florLayout[randomCol][randomRow] = 5;
	    }
	    
	    for (int i = 0; i < 50; i++) {
	        int randomRow = random.nextInt(rows);
	        int randomCol = random.nextInt(cols);
	        florLayout[randomCol][randomRow] = 6;
	    }

	    for (int i = 0; i < cols; i++) {
	        for (int j = 0; j < rows; j++) {
	            changeTile(i + 30, 15 + j, florLayout[i][j]);
	        }
	    }
	}
}
