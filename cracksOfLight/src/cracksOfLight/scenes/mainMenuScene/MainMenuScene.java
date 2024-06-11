package cracksOfLight.scenes.mainMenuScene;

import java.io.InputStream;

import cracksOfLight.application.ApplicationStage;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainMenuScene extends Scene {
    private Pane root;

    ApplicationStage stage;

    private TitlePane titlePane;

    private CustomButton startButton, settingsButton, exitButton;

    public Font font;

    public MainMenuScene(ApplicationStage stage) {
        super(new Pane());

        this.stage = stage;
        
        this.font = stage.font;

        initializePane();

        initializeBackground();

        super.setRoot(root);
    }

    private void initializePane() {
        root = new Pane();

        int xxx = 30;

        titlePane = new TitlePane(font);
        titlePane.setLayoutX(96);
        titlePane.setLayoutY(192 - xxx);
        root.getChildren().add(titlePane);

        startButton = new CustomButton(font, "Start", 416, 120 - xxx);
        root.getChildren().add(startButton);
        startButton.setOnMousePressed(EventHandler -> {
            startButton.buttonView.setImage(startButton.buttonPressed);
            stage.setScene(stage.introScene);
            stage.introScene.timeline.play();
            stage.introScene.textAnimation.play();
        });

        settingsButton = new CustomButton(font, "Settings", 416, 216 - xxx);
        root.getChildren().add(settingsButton);
        settingsButton.setOnMousePressed(EventHandler -> {
            settingsButton.buttonView.setImage(settingsButton.buttonPressed);
            stage.setScene(stage.settingsScene);
            stage.musicPlayer.playMusic("/resources/settings.mp3");
        });

        exitButton = new CustomButton(font, "Exit", 416, 312 - xxx);
        root.getChildren().add(exitButton);
        exitButton.setOnMousePressed(EventHandler -> {
            exitButton.buttonView.setImage(exitButton.buttonPressed);
            Platform.exit();
        });
    }

    private void initializeBackground() {
        root.setBackground(new Background(new BackgroundFill(Color.rgb(181, 231, 203), null, root.getInsets())));
    }
}
