package cracksOfLight.scenes.mainMenuScene;


import java.io.*;

public class SettingsManager {

    private static double volume = 1.0;

    static {
        loadSettings();
    }

    public static double getVolumeSetting() {
        return volume;
    }

    public static void setVolumeSetting(double newVolume) {
        volume = newVolume;
        saveSettings();
    }

    private static void loadSettings() {
        try {
            File settingsFile = new File("src/cracksOfLight/scenes/IntroScene/Ustawionka.txt");
            if (!settingsFile.exists()) {
                throw new FileNotFoundException("Plik Ustawionka.txt nie został znaleziony");
            }
            BufferedReader reader = new BufferedReader(new FileReader(settingsFile));
            String volumeLine = reader.readLine();
            reader.close();
            volume = Double.parseDouble(volumeLine);
        } catch (Exception e) {
            e.printStackTrace();
            volume = 1.0;
        }
    }

    private static void saveSettings() {
        try {
            File settingsFile = new File("src/cracksOfLight/scenes/IntroScene/Ustawionka.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(settingsFile));
            writer.write(Double.toString(volume));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
