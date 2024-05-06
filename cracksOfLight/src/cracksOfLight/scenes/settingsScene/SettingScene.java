package cracksOfLight.scenes.settingsScene;

import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SettingScene extends Scene {

    private int volume;
    private int language;
    private int keyBinds;

    private BackButton backButton;
    private LanguageMenu languageMenu;
    private KeyBindsMenu keyBindsMenu;

    private Text title;
    private VolumeLabel volumeLabel;
    private LanguageLabel languageLabel;
    private KeybindsLabel keybindsLabel;
    private VolumeSlider slider;

    private File settingsFile;

    public SettingScene() {
        super(new Pane(), 640, 480);

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
        });

        languageMenu.getLanguageMenu().setOnAction(event -> {
            MenuItem menuItem = (MenuItem) event.getTarget();
            setLanguage(menuItem.getText());
        });

        setLanguage("English"); // Default language
        this.setRoot(root);

        settingsFile = new File("src\\cracksOfLight\\scenes\\IntroScene\\Ustawionka.txt");

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
            keyBinds = 2; // Ustawiamy odpowiednią wartość dla strzałek
            keyBindsMenu.getKeyBindsMenu().setText(arrowsItem.getText()); // Ustawiamy tekst dla menu
        });

        keyBindsMenu.getKeyBindsMenu().getItems().set(1, arrowsItem); // Zastępujemy poprzedni MenuItem nowym

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
            volume = Integer.parseInt(reader.readLine().trim());
            language = Integer.parseInt(reader.readLine().trim());
            keyBinds = Integer.parseInt(reader.readLine().trim());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void saveSettings() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(settingsFile))) {
            writer.write(volume + "\n");
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
}
