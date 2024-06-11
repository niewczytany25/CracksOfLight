package cracksOfLight.scenes.settingsScene;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import cracksOfLight.application.ApplicationStage;
import cracksOfLight.scenes.mainMenuScene.CustomButton;
import cracksOfLight.scenes.mainMenuScene.MusicPlayer;
import cracksOfLight.scenes.mainMenuScene.SettingsManager;

import java.io.*;

public class SettingsScene extends Scene {

    ApplicationStage stage;

    private int language;
    public int keyBinds;

    private BackButton backButton;
    public CustomButton customButton;
    private LanguageMenu languageMenu;
    private KeyBindsMenu keyBindsMenu;

    private Text title;
    private VolumeLabel volumeLabel;
    private LanguageLabel languageLabel;
    private KeybindsLabel keybindsLabel;
    private VolumeSlider slider;

    private File settingsFile;
    private MusicPlayer musicPlayer;
    
    Font font;

    public SettingsScene(ApplicationStage stage) {
        super(new Pane(), 640, 480);

        this.stage = stage;
        this.musicPlayer = stage.musicPlayer;
        this.font = stage.font != null ? stage.font : new Font("Arial", 30);

        Pane panel1 = new Pane();
        Pane panel2 = new Pane();
        Pane panel3 = new Pane();
        Pane panel4 = new Pane();
        panel1.setBackground(new Background(new BackgroundFill(Color.rgb(93, 155, 121), null, panel1.getInsets())));
        panel2.setBackground(new Background(new BackgroundFill(Color.rgb(134, 198, 154), null, panel2.getInsets())));
        panel3.setBackground(new Background(new BackgroundFill(Color.rgb(134, 198, 154), null, panel3.getInsets())));
        panel4.setBackground(new Background(new BackgroundFill(Color.rgb(134, 198, 154), null, panel4.getInsets())));

        VBox root = new VBox();
        root.getChildren().addAll(panel1, panel2, panel3, panel4);

        double height = 160;
        panel1.setPrefHeight(height);
        panel2.setPrefHeight(height);
        panel3.setPrefHeight(height);
        panel4.setPrefHeight(height);

        backButton = new BackButton();
        panel1.getChildren().add(backButton);

        title = new Text("Settings");
        title.setX(250);
        title.setY(70);
        title.setFont(font);
        title.setStyle("-fx-fill: white;");
        panel1.getChildren().add(title);

        volumeLabel = new VolumeLabel();
        volumeLabel.setFont(font);
        panel2.getChildren().add(volumeLabel);

        slider = new VolumeSlider();
        panel2.getChildren().add(slider);

        languageLabel = new LanguageLabel();
        languageLabel.setFont(font);
        panel3.getChildren().add(languageLabel);

        languageMenu = new LanguageMenu();
        panel3.getChildren().add(languageMenu);

        keybindsLabel = new KeybindsLabel();
        keybindsLabel.setFont(font);
        panel4.getChildren().add(keybindsLabel);

        keyBindsMenu = new KeyBindsMenu();
        panel4.getChildren().add(keyBindsMenu);

        backButton.setOnAction(event -> {
            saveSettings();
            stopMusic();
            stage.setScene(stage.mainMenuScene);
            stage.musicPlayer.playMusic("/resources/game.mp3");
        });
        
        backButton.setStyle("-fx-border-color: #171819; -fx-border-width: 2px; -fx-background-radius: 3; -fx-border-radius: 3; -fx-background-color: #486859; -fx-text-fill: white;");

        languageMenu.getLanguageMenu().setOnAction(event -> {
            MenuItem menuItem = (MenuItem) event.getTarget();
            setLanguage(menuItem.getText());
        });

        setLanguage("English");
        this.setRoot(root);

        slider.setValue(SettingsManager.getVolumeSetting() * 100);
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double volume = newValue.doubleValue() / 100;
                SettingsManager.setVolumeSetting(volume);
                musicPlayer.adjustVolume(volume);
            }
        });


        settingsFile = new File("src/cracksOfLight/scenes/IntroScene/Ustawionka.txt");
        loadSettings();
    }

    private void setLanguage(String selectedLanguage) {
        
        MenuItem arrowsItem = new MenuItem("Arrows");
        MenuItem wsadItem = new MenuItem("WSAD");

        arrowsItem.setOnAction(event -> {
            keyBinds = 2;
            keyBindsMenu.getKeyBindsMenu().setText(arrowsItem.getText());
        });
        
        wsadItem.setOnAction(event -> {
            keyBinds = 1;
            keyBindsMenu.getKeyBindsMenu().setText(wsadItem.getText());
        });

        keyBindsMenu.getKeyBindsMenu().getItems().set(0, wsadItem);
        keyBindsMenu.getKeyBindsMenu().getItems().set(1, arrowsItem);
    	
    	if (selectedLanguage == "Polish")
    	{
    		title.setText("Ustawienia");
    		volumeLabel.setText("Głośność");
    		languageLabel.setText("Język");
    		keybindsLabel.setText("Przypisania klawiszy");
    		
    		backButton.setText("Powrót");
    		
    		languageMenu.getLanguageMenu().setText("Polski");
    		keyBindsMenu.getKeyBindsMenu().setText(keyBinds == 1 ? "WSAD" : "Strzałki");
    		
    		arrowsItem.setText("Strzałki");
    		wsadItem.setText("WSAD");
    	}
    	
    	if (selectedLanguage == "Italian")
    	{
    		title.setText("Impostazioni");
    		volumeLabel.setText("Volume");
    		languageLabel.setText("Lingua");
    		keybindsLabel.setText("Tasti di scelta rapida");
    		
    		backButton.setText("Indietro");
    		
    		languageMenu.getLanguageMenu().setText("Italiano");
    		keyBindsMenu.getKeyBindsMenu().setText(keyBinds == 1 ? "WSAD" : "Frecce");
    		
    		arrowsItem.setText("Frecce");
    		wsadItem.setText("WSAD");
    	}
    	
    	if (selectedLanguage == "English")
    	{
    		title.setText("Settings");
    		volumeLabel.setText("Volume");
    		languageLabel.setText("Language");
    		keybindsLabel.setText("Keybings");
    		
    		backButton.setText("Return");
    		
    		languageMenu.getLanguageMenu().setText("English");
    		keyBindsMenu.getKeyBindsMenu().setText(keyBinds == 1 ? "WSAD" : "Arrows");
    		
    		arrowsItem.setText("Arrows");
    		wsadItem.setText("WSAD");
    	}




        switch (selectedLanguage) {
            case "Polish":
                language = 1;
                break;
            case "English":
                language = 2;
                break;
            case "Italian":
                language = 3;
                break;
        }
    }

    private void loadSettings() {
        try (BufferedReader reader = new BufferedReader(new FileReader(settingsFile))) {
            double volume = Double.parseDouble(reader.readLine().trim());
            language = Integer.parseInt(reader.readLine().trim());
            keyBinds = Integer.parseInt(reader.readLine().trim());
            slider.setValue(volume * 100);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Apply loaded settings
        setLanguage(language == 1 ? "Polish" : (language == 3 ? "Italian" : "English"));
    }

    private void saveSettings() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(settingsFile))) {
            writer.write(Double.toString(slider.getValue() / 100) + "\n");
            writer.write(language + "\n");
            writer.write(keyBinds + "\n");

            switch (language) {
                case 1:
                    System.out.println("Ustawienia zostały zapisane");
                    break;
                case 2:
                    System.out.println("Settings saved");
                    break;
                case 3:
                    System.out.println("Impostazioni sono state configurate");
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playMusic() {
        musicPlayer.playMusic("/resources/settings.mp3");
    }

    public void stopMusic() {
        musicPlayer.stopMusic();
    }
}
