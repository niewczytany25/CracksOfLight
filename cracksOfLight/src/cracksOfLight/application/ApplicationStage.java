package cracksOfLight.application;

import cracksOfLight.scenes.mainMenuScene.MusicPlayer;
import cracksOfLight.scenes.IntroScene.IntroScene;
import cracksOfLight.scenes.craftingScene.CraftingScene;
import cracksOfLight.scenes.gameScene.GameScene;
import cracksOfLight.scenes.mainMenuScene.MainMenuScene;
import cracksOfLight.scenes.settingsScene.SettingsScene;
import javafx.stage.Stage;

public class ApplicationStage extends Stage {
    int sceneChoosing = 1; // main - 1 , settings - 2 , game - 3 , crafting - 4, intro - 5
    public MusicPlayer musicPlayer;

    public MainMenuScene mainMenuScene;
    public SettingsScene settingsScene;
    public GameScene gameScene;
    public CraftingScene craftingScene;

    public ApplicationStage() {
        this.setWidth(640);
        this.setHeight(480);
        this.setResizable(false);
        this.setTitle("Cracks Of Light");

        musicPlayer = new MusicPlayer();
        mainMenuScene = new MainMenuScene(this);
        settingsScene = new SettingsScene(this);
        gameScene = new GameScene(this);
        craftingScene = new CraftingScene(this);

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

    public void goToSettingsScene() {
        musicPlayer.playMusic("/resources/settings.mp3");
        this.setScene(settingsScene);
    }

    public void goToMainMenuScene() {
        this.setScene(mainMenuScene);
        musicPlayer.playMusic("/resources/game.mp3");
    }

    public void goToGameScene() {
        this.setScene(gameScene);
        musicPlayer.playMusic("/resources/game.mp3");
    }

    public void goToCraftingScene() {
        this.setScene(craftingScene);
        musicPlayer.playMusic("/resources/game.mp3");
    }

    public void goToIntroScene() {
        IntroScene introScene = new IntroScene(this); // Tworzenie nowej sceny intro za każdym razem
        this.setScene(introScene);
        musicPlayer.playMusic("/resources/game.mp3");
    }

    public void startGameAfterIntro() {
        this.setScene(gameScene);
        musicPlayer.playMusic("/resources/game.mp3");
    }
}
