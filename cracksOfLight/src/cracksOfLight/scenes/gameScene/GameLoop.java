package cracksOfLight.scenes.gameScene;

import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer 
{

	GameScene gameScene;
	
	float fps = 60;
	float frameTime = 1000000000 / fps;
	
	float startTime = System.currentTimeMillis();
	float finishTime;
	float sleepTime;
	float currentTime;
	
	
	public GameLoop(GameScene gameScene)
	{
		this.gameScene = gameScene;
	}
	
	@Override
	public void handle(long arg0) 
	{
		finishTime = startTime + frameTime;
		
		
		
		gameScene.gamePane.player.update();
		
		currentTime = System.currentTimeMillis();
		
		sleepTime = finishTime - finishTime;
		
		try {
			Thread.sleep((long) sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		startTime = finishTime;
	}

}
