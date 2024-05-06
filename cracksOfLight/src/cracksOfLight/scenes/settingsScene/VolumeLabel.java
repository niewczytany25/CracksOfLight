package cracksOfLight.scenes.settingsScene;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class VolumeLabel extends Label {

    public VolumeLabel() {
        super();
        setText("Volume");
        setFont(Font.font("Times New Roman", 25));
        setStyle("-fx-fill: white;");
        setLayoutX(100);
        setLayoutY(35);
    }
}
