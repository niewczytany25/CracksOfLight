package cracksOfLight.scenes.settingsScene;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class LanguageMenu extends MenuBar {

    private Menu languageMenu;

    public LanguageMenu() {
        super();
        languageMenu = new Menu("Choice");

        MenuItem item1 = new MenuItem("Polish");
        MenuItem item2 = new MenuItem("English");
        MenuItem item3 = new MenuItem("Italian");

        languageMenu.getItems().addAll(item1, item2, item3);

        getMenus().add(languageMenu);
        setLayoutX(420);
        setLayoutY(0);
    }

    public Menu getLanguageMenu() {
        return languageMenu;
    }
}
