package cracksOfLight.scenes.gameScene.healthAndArmorBar;

import java.security.PublicKey;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HealthAndArmorBarsPane extends Pane 
{
	Rectangle mainBackground;
	
	ImageView[] armors;
	ImageView[] hearts;
	
	Image heartImage, emptyHeartImage, armorImage;
	
	String heartImageLocalization = "/resources/heart.png";
	String emptyHeartImageLocalization = "/resources/emptyHeart.png";
	String armorImageLocalization = "/resources/armorIcon.png";
	
	public int health = 10;
	public int armor = 0;
	
	
	public HealthAndArmorBarsPane()
	{
		this.setPrefSize(2 * 16, 10 * 16);
		
		mainBackground = new Rectangle(0, 0, 2 * 16, 10 * 16);
		mainBackground.setStroke(Color.BLACK);
		mainBackground.setFill(Color.rgb(93, 155, 121));
		this.getChildren().add(mainBackground);
		
		heartImage = new Image(getClass().getResourceAsStream(heartImageLocalization), 16, 16, false, false);
		emptyHeartImage = new Image(getClass().getResourceAsStream(emptyHeartImageLocalization), 16, 16, false, false);
		armorImage = new Image(getClass().getResourceAsStream(armorImageLocalization), 16, 16, false, false);
		
		hearts = new ImageView[10];
		
		armors = new ImageView[10];
		
		for(int ii = 0; ii < 10; ii++)
		{
			hearts[ii] = new ImageView();
			hearts[ii].setImage(heartImage);
			
			this.getChildren().add(hearts[ii]);
			hearts[ii].setLayoutX(0);
			hearts[ii].setLayoutY((9 - ii) * 16);
			
			armors[ii] = new ImageView();
			armors[ii].setImage(armorImage);
			
			this.getChildren().add(armors[ii]);
			armors[ii].setLayoutX(16);
			armors[ii].setLayoutY((9 - ii) * 16);
			
			
		}
		
		setHealth(10);
		setArmor(0);
	}
	
	public void setHealth(int health)
	{
		this.health = health;
		
		for(int ii = 0; ii < 10; ii++)
		{
			if(ii <= health - 1)
			{
				hearts[ii].setImage(heartImage);
			}
			else
			{
				hearts[ii].setImage(emptyHeartImage);
			}
		}
	}
	
	public void setArmor(int armor)
	{
		this.armor = armor;
		
		for(int ii = 0; ii < 10; ii++)
		{
			if(ii <= armor - 1)
			{
				armors[ii].setVisible(true);
			}
			else
			{
				armors[ii].setVisible(false);
			}
		}
	}
}
