package cracksOfLight.scenes.settingsScene;

import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class VolumeSlider extends Slider {

    private TextField textField;

    public VolumeSlider() {
        super();
        setLayoutX(350);
        setLayoutY(20);
        setMin(0);
        setMax(100);
        setValue(50);
        setPrefWidth(200);
        setBlockIncrement(20);
        setShowTickMarks(true);
        setMajorTickUnit(20);
        setShowTickLabels(true);

        textField = new TextField();
        textField.setLayoutX(300);
        textField.setLayoutY(20);
        textField.setPrefWidth(35);
        textField.setEditable(false);
        textField.setText(String.valueOf((int) getValue()));

        valueProperty().addListener((observable, oldValue, newValue) -> {
            textField.setText(String.valueOf(newValue.intValue()));
        });
    }

    public TextField getTextField() {
        return textField;
    }
}
