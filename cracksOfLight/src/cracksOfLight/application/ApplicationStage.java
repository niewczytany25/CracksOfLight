package cracksOfLight.application;

import cracksOfLight.scenes.mainMenuScene.MusicPlayer;

import java.io.InputStream;

import cracksOfLight.scenes.IntroScene.IntroScene;
import cracksOfLight.scenes.craftingScene.CraftingScene;
import cracksOfLight.scenes.gameScene.GameScene;
import cracksOfLight.scenes.mainMenuScene.MainMenuScene;
import cracksOfLight.scenes.settingsScene.SettingsScene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ApplicationStage extends Stage {
    int sceneChoosing = 1; // main - 1 , settings - 2 , game - 3 , crafting - 4, intro - 5
    public MusicPlayer musicPlayer;
    
    public Font font;

    public MainMenuScene mainMenuScene;
    public SettingsScene settingsScene;
    public GameScene gameScene;
    public CraftingScene craftingScene;
    public IntroScene introScene;

    public ApplicationStage() {
    	
    	initializeFonts();
    	
        this.setWidth(640);
        this.setHeight(480);
        this.setResizable(false);
        this.setTitle("Cracks Of Light");
        mainMenuScene = new MainMenuScene(this);
        musicPlayer = new MusicPlayer();
        settingsScene = new SettingsScene(this);
        
        gameScene = new GameScene(this);
        craftingScene = new CraftingScene(this);
        introScene = new IntroScene(this);

        if (sceneChoosing == 1) {
            this.setScene(mainMenuScene);
            musicPlayer.playMusic("/resources/game.mp3");
        } else if (sceneChoosing == 2) {
            this.setScene(settingsScene);
            musicPlayer.playMusic("/resources/settings.mp3");
        } else if (sceneChoosing == 3) {
            this.setScene(gameScene);
            musicPlayer.playMusic("/resources/game.mp3");
        } else if (sceneChoosing == 4) {
            this.setScene(craftingScene);
            musicPlayer.playMusic("/resources/game.mp3");
        }
    }
    
    private void initializeFonts() {
        try {
            InputStream stream = getClass().getResourceAsStream("/resources/RobotoMono-Regular.ttf");
            font = Font.loadFont(stream, 30);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
