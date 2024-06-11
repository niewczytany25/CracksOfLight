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
    public MusicPlayer musicPlayer;
    
    public Font font;

    public MainMenuScene mainMenuScene;
    public SettingsScene settingsScene;
    public GameScene gameScene;
    public CraftingScene craftingScene;
    public IntroScene introScene;

    public ApplicationStage() {
    	
    	System.out.println("Szczególne podziekowania dla Mateusza Roszkowskiego, za pomoc w tłumaczeniu hitorii na język angielski.");
    	
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

        this.setScene(mainMenuScene);
        musicPlayer.playMusic("/resources/game.mp3");

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
