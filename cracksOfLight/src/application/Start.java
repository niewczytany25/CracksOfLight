package application;

import cracksOfLight.scenes.IntroScene.IntroScene;
import cracksOfLight.scenes.craftingScene.CraftingScene;
import cracksOfLight.scenes.gameScene.GameScene;
import cracksOfLight.scenes.mainMenuScene.*;
import cracksOfLight.scenes.settingsScene.SettingScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Start extends Application 
{
	MainMenuScene mainMenuScene;
	SettingScene settingScene;
	GameScene gameScene;
	CraftingScene craftingScene;
	IntroScene introScene;
	int sceneChoosing = 3; // main - 1 , settings - 2 , game - 3 , crafting - 4, 5 - intro
	
	
	@Override
	public void start(Stage stage) 
	{
		System.out.println("Hello world");
		
		stage.setWidth(640);
		stage.setHeight(480);
		stage.setResizable(false);
		
		if(sceneChoosing == 1)
		{
			mainMenuScene = new MainMenuScene();
			stage.setScene(mainMenuScene);
		} 
		else if(sceneChoosing == 2)
		{
			settingScene = new SettingScene();
			stage.setScene(settingScene);
		}
		else if(sceneChoosing == 3)
		{
			gameScene = new GameScene();
			stage.setScene(gameScene);
		}
		else if(sceneChoosing == 4)
		{
			craftingScene = new CraftingScene();
			stage.setScene(craftingScene);
		}
		else if(sceneChoosing == 5)
		{
            introScene = new IntroScene();
            stage.setScene(introScene);
        }
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
