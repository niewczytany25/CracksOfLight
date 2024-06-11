package cracksOfLight.scenes.settingsScene;

import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class VolumeSlider extends Slider {



    public VolumeSlider() 
    {
        super();
        setLayoutX(350);
        setLayoutY(40);
        setMin(0);
        setMax(100);
        setValue(50);
        setPrefWidth(200);
        setBlockIncrement(20);
        setShowTickMarks(true);
        setMajorTickUnit(20);
        setShowTickLabels(true);

    }
}
