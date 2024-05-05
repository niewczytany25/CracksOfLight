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
        setLayoutY(0);
    }

    public Menu getKeyBindsMenu() {
        return keyBindsMenu;
    }
}
