package cracksOfLight.scenes.settingsScene;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SettingScene extends Scene {

	public SettingScene() {
		super(new Pane(), 640, 480);
		
		Pane panel1 = new Pane();
		Pane panel2 = new Pane();
		Pane panel3 = new Pane();
		Pane panel4 = new Pane();
		panel1.setStyle("-fx-background-color: black;"); //zobacz, czemu to wszystko w stage musi być
		panel2.setStyle("-fx-background-color: grey;"); 
		panel3.setStyle("-fx-background-color: grey;"); 
		panel4.setStyle("-fx-background-color: grey;");
		Menu languageMenu;
		Menu KeyBindsMenu;
		
		VBox root = new VBox(); //tworzę Vbox/Hbox w root, Vbox - góradół, Hbox - lewoprawo
		root.getChildren().addAll(panel1, panel2, panel3, panel4); //zobacz, czemu się to do roota dodaje
		
		double height = 160;
		panel1.setPrefHeight(height); // to samo mogę zrobić dla PrefSize i PrefWidth
	    panel2.setPrefHeight(height);
	    panel3.setPrefHeight(height);
	    panel4.setPrefHeight(height);
	    
	    //poniżej podział na poszczególne komponenty,które będą w panelach
	    //Panel1
	    Button backButton = new Button("Back");
	    backButton.setPrefSize(70, 40);
	    backButton.setLayoutX(35);
	    backButton.setLayoutY(35);
	    panel1.getChildren().add(backButton);
	    
	    Text title = new Text("Settings");
	    title.setX(750);// od 0 do prawej
	    title.setY(70); // 0 do dołu
	    title.setFont(Font.font("Times New Roman", 30));
	    title.setStyle("-fx-fill: white;");
	    panel1.getChildren().add(title);

	    //panel2
	    Text volume = new Text("Volume");
	    volume.setFont(Font.font("Times New Roman", 25));
	    volume.setStyle("-fx-fill: white;");
	    volume.setLayoutX(100);
	    volume.setLayoutY(35);
	    panel2.getChildren().add(volume);

	    Slider slider = new Slider();
	    slider.setLayoutX(350);
	    slider.setLayoutY(20);
	    slider.setMin(0);
	    slider.setMax(100);
	    slider.setValue(50);
	    slider.setPrefWidth(200);
	    // Ustawienie kroku co 20
	    slider.setBlockIncrement(20);

	    // Dodanie podziałki i ustawienie kroku większej podziałki
	    slider.setShowTickMarks(true);
	    slider.setMajorTickUnit(20);
	    slider.setShowTickLabels(true);
	    panel2.getChildren().add(slider);

	    // Pole tekstowe do wyświetlania wartości suwaka
	    TextField textField = new TextField();
	    textField.setLayoutX(300);
	    textField.setLayoutY(20);
	    textField.setPrefWidth(35);
	    textField.setEditable(false); // Nieedytowalne pole tekstowe
	    textField.setText(String.valueOf((int) slider.getValue())); // Ustawienie początkowej wartości

	    // Nasłuchiwanie zmian wartości suwaka i aktualizacja wartości pola tekstowego
	    slider.valueProperty().addListener(new ChangeListener<Number>() {
	        @Override
	        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
	            textField.setText(String.valueOf(newValue.intValue()));
	        }
	    });
	    panel2.getChildren().add(textField);
	  //panel3
	  	 Text language = new Text("Language");
	  	 language.setFont(Font.font("Times New Roman", 25));
	  	 language.setStyle("-fx-fill: white;");
	  	 language.setLayoutX(100);
	  	 language.setLayoutY(25);
	       panel3.getChildren().add(language);
	       
	       MenuBar menuBar = new MenuBar();
	       Menu menu = new Menu("Choice");
	       languageMenu = menu;

	       MenuItem item1 = new MenuItem("Polish");
	       MenuItem item2 = new MenuItem("English");
	       MenuItem item3 = new MenuItem("Italian");

	       item1.setOnAction(event -> {
	           languageMenu.setText("Polish");
	       });

	       item2.setOnAction(event -> {
	           languageMenu.setText("English");
	       });

	       item3.setOnAction(event -> {
	           languageMenu.setText("Italian");
	       });

	       menu.getItems().addAll(item1, item2, item3);
	       menuBar.getMenus().add(menu);
	       menuBar.setLayoutX(420);
	       menuBar.setLayoutY(0);
	       panel3.getChildren().add(menuBar);

	  	//panel4
	       Text keybinds = new Text("KeyBinds");
	       keybinds.setFont(Font.font("Times New Roman", 25));
	       keybinds.setStyle("-fx-fill: white;");
	       keybinds.setLayoutX(100);
	       keybinds.setLayoutY(25);
	       panel4.getChildren().add(keybinds);
	       

	       MenuBar menuBar2 = new MenuBar();
	       Menu menu2 = new Menu("Choice");
	       KeyBindsMenu = menu2;

	       MenuItem item4 = new MenuItem("WSAD");
	       MenuItem item5 = new MenuItem("Arrows");

	       item4.setOnAction(event -> {
	           KeyBindsMenu.setText("WSAD");
	       });

	       item5.setOnAction(event -> {
	           KeyBindsMenu.setText("Arrows");
	       });

	       menu2.getItems().addAll(item4, item5);
	       menuBar2.getMenus().add(menu2);
	       menuBar2.setLayoutX(420);
	       menuBar2.setLayoutY(0);
	       panel4.getChildren().add(menuBar2);
	       
	       this.setRoot(root);

	       
	}

}
