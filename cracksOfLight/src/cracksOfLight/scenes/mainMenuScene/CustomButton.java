package cracksOfLight.scenes.mainMenuScene;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class CustomButton extends StackPane 
{
	public Image buttonIdle, buttonPressed, buttonHoveredOver;
	public ImageView buttonView;
	
	private Font font;
	
	private Label text;
	
	private String buttonLabel;
	
	public CustomButton(Font font, String buttonLabel, int posX, int posY)
	{
		this.font = font;
		this.buttonLabel = buttonLabel;
		
		initializeImages();
		
		initializeTitle();
		
		this.setOnMouseEntered(EventHandler -> MouseEntered());
		this.setOnMouseExited(EventHandler -> mouseExited());
		this.setOnMousePressed(EventHandler -> mousePressed());
		this.setOnMouseReleased(EventHandler -> mouseReleased());
		
		this.setLayoutX(posX);
		this.setLayoutY(posY);
	}
	
	private void initializeImages()
	{
		buttonIdle = new Image(getClass().getResourceAsStream("/resources/mainMenu/buttonIdle.png"), 128, 48, false, false);
		buttonPressed = new Image(getClass().getResourceAsStream("/resources/mainMenu/buttonPressed.png"), 128, 48, false, false);
		buttonHoveredOver = new Image(getClass().getResourceAsStream("/resources/mainMenu/buttonHoveredOver.png"), 128, 48, false, false);
		
		buttonView = new ImageView();
		buttonView.setImage(buttonIdle);
		
		this.getChildren().add(buttonView);
	}
	
	private void initializeTitle()
	{
		text = new Label(buttonLabel);
		text.setLayoutX(0);
		text.setLayoutY(0);
		text.setFont(font);
		text.setFont(new Font(15));
        this.getChildren().add(text);
	}
	
	private void MouseEntered()
	{
		buttonView.setImage(buttonHoveredOver);
	}
	
	private void mouseExited()
	{
		buttonView.setImage(buttonIdle);
	}
	
	private void mousePressed()
	{
		buttonView.setImage(buttonPressed);
	}
	
	private void mouseReleased()
	{
		buttonView.setImage(buttonHoveredOver);
	}
}
