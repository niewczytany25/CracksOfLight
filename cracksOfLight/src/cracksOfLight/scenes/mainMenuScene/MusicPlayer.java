package cracksOfLight.scenes.mainMenuScene;


import java.net.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicPlayer {
    private MediaPlayer mediaPlayer;

    public void playMusic(String musicFilePath) {
        stopMusic();
        URL resource = getClass().getResource(musicFilePath);
        if (resource == null) {
            System.err.println("Plik muzyczny nie został znaleziony: " + musicFilePath);
            return;
        }
        Media media = new Media(resource.toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        double volume = SettingsManager.getVolumeSetting();
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public void adjustVolume(double volume) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume);
        }
    }
}
