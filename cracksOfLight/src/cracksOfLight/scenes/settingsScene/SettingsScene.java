package cracksOfLight.scenes.settingsScene;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import cracksOfLight.application.ApplicationStage;
import cracksOfLight.scenes.mainMenuScene.MusicPlayer;
import cracksOfLight.scenes.mainMenuScene.SettingsManager;

import java.io.*;

public class SettingsScene extends Scene {

    ApplicationStage stage;

    private int language;
    public int keyBinds;

    private BackButton backButton;
    private LanguageMenu languageMenu;
    private KeyBindsMenu keyBindsMenu;

    private Text title;
    private VolumeLabel volumeLabel;
    private LanguageLabel languageLabel;
    private KeybindsLabel keybindsLabel;
    private VolumeSlider slider;

    private File settingsFile;
    private MusicPlayer musicPlayer;

    public SettingsScene(ApplicationStage stage) {
        super(new Pane(), 640, 480);

        this.stage = stage;
        this.musicPlayer = stage.musicPlayer;

        Pane panel1 = new Pane();
        Pane panel2 = new Pane();
        Pane panel3 = new Pane();
        Pane panel4 = new Pane();
        panel1.setStyle("-fx-background-color: black;");
        panel2.setStyle("-fx-background-color: grey;");
        panel3.setStyle("-fx-background-color: grey;");
        panel4.setStyle("-fx-background-color: grey;");

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
        title.setFont(Font.font("Times New Roman", 30));
        title.setStyle("-fx-fill: white;");
        panel1.getChildren().add(title);

        volumeLabel = new VolumeLabel();
        panel2.getChildren().add(volumeLabel);

        slider = new VolumeSlider();
        panel2.getChildren().add(slider);
        panel2.getChildren().add(slider.getTextField());

        languageLabel = new LanguageLabel();
        panel3.getChildren().add(languageLabel);

        languageMenu = new LanguageMenu();
        panel3.getChildren().add(languageMenu);

        keybindsLabel = new KeybindsLabel();
        panel4.getChildren().add(keybindsLabel);

        keyBindsMenu = new KeyBindsMenu();
        panel4.getChildren().add(keyBindsMenu);

        backButton.setOnAction(event -> {
            saveSettings();
            stopMusic();
            stage.goToMainMenuScene();
        });

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
        volumeLabel.setText(selectedLanguage.equals("Polish") ? "Głośność" : (selectedLanguage.equals("Italian") ? "Volume" : "Volume"));
        languageLabel.setText(selectedLanguage.equals("Polish") ? "Język" : (selectedLanguage.equals("Italian") ? "Lingua" : "Language"));
        keybindsLabel.setText(selectedLanguage.equals("Polish") ? "Klawisze" : (selectedLanguage.equals("Italian") ? "Tasti di scelta rapida" : "KeyBinds"));
        backButton.setText(selectedLanguage.equals("Polish") ? "Powrót" : (selectedLanguage.equals("Italian") ? "Indietro" : "Back"));
        languageMenu.getLanguageMenu().setText(selectedLanguage.equals("Polish") ? "Wybór" : (selectedLanguage.equals("Italian") ? "Scelta" : "Choice"));
        keyBindsMenu.getKeyBindsMenu().setText(selectedLanguage.equals("Polish") ? "Wybór" : (selectedLanguage.equals("Italian") ? "Scelta" : "Choice"));

        MenuItem arrowsItem = new MenuItem();
        switch (selectedLanguage) {
            case "Polish":
                arrowsItem.setText("Strzałki");
                break;
            case "English":
                arrowsItem.setText("Arrows");
                break;
            case "Italian":
                arrowsItem.setText("Frecce");
                break;
        }

        arrowsItem.setOnAction(event -> {
            keyBinds = 2;
            keyBindsMenu.getKeyBindsMenu().setText(arrowsItem.getText());
        });

        keyBindsMenu.getKeyBindsMenu().getItems().set(1, arrowsItem);

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
