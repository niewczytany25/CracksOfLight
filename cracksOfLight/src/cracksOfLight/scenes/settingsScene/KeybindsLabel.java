package cracksOfLight.scenes.settingsScene;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class KeybindsLabel extends Label {

    public KeybindsLabel() {
        super();
        setText("KeyBinds");
        setFont(Font.font("Times New Roman", 25));
        setStyle("-fx-fill: white;");
        setLayoutX(100);
        setLayoutY(25);
    }
}
