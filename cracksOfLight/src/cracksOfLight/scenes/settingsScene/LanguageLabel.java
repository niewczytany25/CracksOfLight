package cracksOfLight.scenes.settingsScene;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LanguageLabel extends Label {

    public LanguageLabel() {
        super();
        setText("Language");
        setFont(Font.font("Times New Roman", 25));
        setStyle("-fx-fill: white;");
        setLayoutX(100);
        setLayoutY(25);
    }
}
