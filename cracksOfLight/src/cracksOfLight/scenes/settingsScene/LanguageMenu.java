package cracksOfLight.scenes.settingsScene;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Font;

public class LanguageMenu extends MenuBar {

    private Menu languageMenu;
    
    MenuItem item1;
    MenuItem item2;
    MenuItem item3;

    public LanguageMenu() {
        super();
        languageMenu = new Menu("Choice");

        MenuItem item1 = new MenuItem("Polish");
        MenuItem item2 = new MenuItem("English");
        MenuItem item3 = new MenuItem("Italian");

        languageMenu.getItems().addAll(item1, item2, item3);

        getMenus().add(languageMenu);
        setLayoutX(420);
        setLayoutY(30);
        
        this.setStyle("-fx-border-color: #171819; -fx-border-width: 2px; -fx-background-radius: 3; -fx-border-radius: 3; -fx-background-color: #5d9b79; -fx-text-fill: white;");
        
        languageMenu.setStyle("-fx-background-color: #5d9b79; -fx-text-fill: white;");
        languageMenu.setOnShowing(event -> languageMenu.setStyle("-fx-background-color: #5d9b79; -fx-text-fill: black;"));
        languageMenu.setOnHiding(event -> languageMenu.setStyle("-fx-background-color: #5d9b79; -fx-text-fill: black;"));
        
        
    }

    public Menu getLanguageMenu() {
        return languageMenu;
    }
    
    private void styleMenu(Menu menu) {
        // Stylizacja menu
        menu.setStyle("-fx-background-color: #5d9b79; -fx-text-fill: white;");
        menu.setOnShowing(event -> menu.setStyle("-fx-background-color: #3b5998; -fx-text-fill: white;"));
        menu.setOnHiding(event -> menu.setStyle("-fx-background-color: #3b5998; -fx-text-fill: white;"));
    }
    
    private void styleMenuItem(MenuItem menuItem) {
        // Stylizacja elementów menu
        menuItem.setStyle("-fx-background-color: #8b9dc3; -fx-text-fill: white;");
        menuItem.setOnAction(event -> menuItem.setStyle("-fx-background-color: #8b9dc3; -fx-text-fill: white;"));
    }
}
