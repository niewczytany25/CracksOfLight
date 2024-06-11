package cracksOfLight.scenes.settingsScene;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class KeyBindsMenu extends MenuBar {

    private Menu keyBindsMenu;

    public KeyBindsMenu() {
        super();
        keyBindsMenu = new Menu("Choice");

        MenuItem item1 = new MenuItem("WSAD");
        MenuItem item2 = new MenuItem("Arrows");

        keyBindsMenu.getItems().addAll(item1, item2);

        getMenus().add(keyBindsMenu);
        setLayoutX(420);
        setLayoutY(30);
        
        this.setStyle("-fx-border-color: #171819; -fx-border-width: 2px; -fx-background-radius: 3; -fx-border-radius: 3;-fx-background-color: #5d9b79; -fx-text-fill: white;");
        
        keyBindsMenu.setStyle("-fx-background-color: #5d9b79; -fx-text-fill: white;");
        keyBindsMenu.setOnShowing(event -> keyBindsMenu.setStyle("-fx-background-color: #5d9b79; -fx-text-fill: black;"));
        keyBindsMenu.setOnHiding(event -> keyBindsMenu.setStyle("-fx-background-color: #5d9b79; -fx-text-fill: black;"));
    }

    public Menu getKeyBindsMenu() {
        return keyBindsMenu;
    }
}
