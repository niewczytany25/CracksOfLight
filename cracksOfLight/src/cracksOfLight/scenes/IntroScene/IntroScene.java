package cracksOfLight.scenes.IntroScene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import cracksOfLight.application.ApplicationStage;

public class IntroScene extends Scene {

    private List<String> slidesText = new ArrayList<>();
    private int currentSlide = 0;
    private Timeline timeline;
    private ApplicationStage stage;
    private Timeline textAnimation;

    public IntroScene(ApplicationStage stage) {
        super(new StackPane(), 600, 400);
        this.stage = stage;
        loadSlidesText();

        Text slideText = new Text();
        slideText.setStyle("-fx-font-size: 24;");
        StackPane.setAlignment(slideText, Pos.CENTER);
        StackPane root = (StackPane) this.getRoot();
        root.getChildren().add(slideText);

        Button nextButton = new Button("Następny");
        nextButton.setOnAction(event -> nextSlide(slideText));
        StackPane.setAlignment(nextButton, Pos.BOTTOM_CENTER);
        root.getChildren().add(nextButton);

        animateText(slideText, getNextSlideText());
        currentSlide++;

        timeline = new Timeline(
                new KeyFrame(Duration.seconds(10), event -> nextSlide(slideText))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void loadSlidesText() {
        slidesText.clear();
        currentSlide = 0;
        int languageSetting = readSettingValue("Ustawionka.txt", 1);
        String slidesFileName;
        switch (languageSetting) {
            case 1:
                slidesFileName = "polski.txt";
                break;
            case 2:
                slidesFileName = "english.txt";
                break;
            case 3:
                slidesFileName = "italiano.txt";
                break;
            default:
                slidesFileName = "polski.txt";
        }

        try (InputStream is = getClass().getResourceAsStream(slidesFileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            StringBuilder slideBuilder = new StringBuilder();
            int currentLine = 0;
            int slideIndex = 0;
            while ((line = reader.readLine()) != null) {
                currentLine++;
                if (currentLine >= getStartLine(slideIndex) && currentLine <= getEndLine(slideIndex)) {
                    slideBuilder.append(line).append("\n");
                }
                if (currentLine == getEndLine(slideIndex)) {
                    slidesText.add(slideBuilder.toString());
                    slideBuilder = new StringBuilder();
                    slideIndex++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getStartLine(int slideIndex) {
        int[] startLines = {1, 6, 11, 16, 21, 26, 31, 36, 41, 46, 51, 56, 61, 66, 71, 76, 81};
        return startLines[slideIndex];
    }

    private int getEndLine(int slideIndex) {
        int[] endLines = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 84};
        return endLines[slideIndex];
    }

    private String getNextSlideText() {
        if (currentSlide < slidesText.size()) {
            return slidesText.get(currentSlide);
        } else {
            Platform.runLater(() -> stage.startGameAfterIntro());
            return "";
        }
    }

    private void nextSlide(Text slideText) {
        if (textAnimation != null && textAnimation.getStatus() == Timeline.Status.RUNNING) {
            textAnimation.stop();
        }
        String nextSlideText = getNextSlideText();
        if (!nextSlideText.isEmpty()) {
            animateText(slideText, nextSlideText);
            currentSlide++;
        }
    }

    private void animateText(Text textNode, String text) {
        final int[] currentIndex = {0};
        textAnimation = new Timeline(new KeyFrame(Duration.millis(60), event -> {
            textNode.setText(text.substring(0, currentIndex[0]++));
        }));
        textAnimation.setCycleCount(text.length() + 1);
        textAnimation.play();
    }

    private int readSettingValue(String settingFileName, int lineIndex) {
        int value = 0;
        try (InputStream is = getClass().getResourceAsStream(settingFileName)) {
            if (is != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line;
                int currentLine = 0;
                while ((line = reader.readLine()) != null && currentLine <= lineIndex) {
                    if (currentLine == lineIndex) {
                        value = Integer.parseInt(line.trim());
                        break;
                    }
                    currentLine++;
                }
                reader.close();
            } else {
                System.err.println("Plik " + settingFileName + " nie został znaleziony");
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }

    public void resetSlides() {
        currentSlide = 0;
    }
}