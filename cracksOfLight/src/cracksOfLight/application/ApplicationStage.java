package cracksOfLight.application;

import cracksOfLight.scenes.IntroScene.IntroScene;
import cracksOfLight.scenes.craftingScene.CraftingScene;
import cracksOfLight.scenes.gameScene.GameScene;
import cracksOfLight.scenes.mainMenuScene.MainMenuScene;
import cracksOfLight.scenes.settingsScene.SettingsScene;
import javafx.stage.Stage;

public class ApplicationStage extends Stage 
{
	int sceneChoosing = 1; // main - 1 , settings - 2 , game - 3 , crafting - 4, intro - 5
	
	public MainMenuScene mainMenuScene;
	public SettingsScene settingsScene;
	public GameScene gameScene;
	public CraftingScene craftingScene;
	public IntroScene introScene;
	
	public ApplicationStage()
	{
		this.setWidth(640);
		this.setHeight(480);
		this.setResizable(false);
		this.setTitle("Cracks Of Light");
		
		mainMenuScene = new MainMenuScene(this);
		settingsScene = new SettingsScene(this);
		gameScene = new GameScene(this);
		craftingScene = new CraftingScene(this);
		introScene = new IntroScene();
		
		if(sceneChoosing == 1)
		{
			
			this.setScene(mainMenuScene);
		} 
		else if(sceneChoosing == 2)
		{
			
			this.setScene(settingsScene);
		}
		else if(sceneChoosing == 3)
		{
			
			this.setScene(gameScene);
		}
		else if(sceneChoosing == 4)
		{
			
			this.setScene(craftingScene);
		}
		else if(sceneChoosing == 5)
		{
            
            this.setScene(introScene);
        }
	}
}
