package cracksOfLight.scenes.craftingScene;

import cracksOfLight.application.ApplicationStage;
import cracksOfLight.scenes.gameScene.toolbeltPane.ToolbeltItem;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CraftingScene extends Scene 
{
	ApplicationStage stage;
	
	Pane root;
	
	Pane mainPane;
	
	Image mainPaneBackground;
	ImageView mainPaneBackgroundView;
	
	Image smallerPaneBackground;
	
	Pane helmetPane;
	ImageView helmetPaneBackgroundView;
	ToolbeltItem helmetItem;
	Label helmetLabel;
	String[] helmetLabelTexts = {"Leather Helmet: \n 5 Leather", "Copper Helmet: \n 5 Copper", "Iron Helmet: \n 5 Iron", "Gold Helmet: \n 5 Gold", "Your helmet has \n maximum level"};
	int helmetLevel = 0;
	
	Pane chestplatePane;
	ImageView chestplatePaneBackgroundView;
	ToolbeltItem chestplateItem;
	Label chestplateLabel;
	String[]chestplateLabelTexts = {"Leather Chestplate: \n 5 Leather", "Copper Chestplate: \n 5 Copper", "Iron Chestplate: \n 5 Iron", "Gold Chestplate: \n 5 Gold", "Your chestplate has \n maximum level"};
	int chestplateLevel = 0;
	
	Pane leggingsPane;
	ImageView leggingsPaneBackgroundView;
	ToolbeltItem leggingsItem;
	Label leggingsLabel;
	String[] leggingsLabelTexts = {"Leather Leggings: \n 5 Leather", "Copper Leggings: \n 5 Copper", "Iron Leggings: \n 5 Iron", "Gold Leggings: \n 5 Gold", "Your leggings has \n maximum level"};
	int leggingsLevel = 0;
	
	Pane bootsPane;
	ImageView bootsPaneBackgroundView;
	ToolbeltItem bootsItem;
	Label bootsLabel;
	String[] bootsLabelTexts = {"Leather Boots: \n 5 Leather", "Copper Boots: \n 5 Copper", "Iron Boots: \n 5 Iron", "Gold Boots: \n 5 Gold", "Your boots has \n maximum level"};
	int bootsLevel = 0;
	
	Pane pickaxePane;
	ImageView pickaxePaneBackgroundView;
	ToolbeltItem pickaxeItem;
	Label pickaxeLabel;
	String[] pickaxeLabelTexts = {"Leather Pickaxe: \n 5 Stone", "Copper Pickaxe: \n 5 Copper", "Iron Pickaxe: \n 5 Iron", "Gold Pickaxe: \n 5 Gold", "Your pickaxe has \n maximum level"};
	int pickaxeLevel = 0;
	
	Pane swordPane;
	ImageView swordPaneBackgroundView;
	ToolbeltItem swordItem;
	Label swordLabel;
	String[] swordLabelTexts = {"Leather Sword: \n 5 Stone", "Copper Sword: \n 5 Copper", "Iron Sword: \n 5 Iron", "Gold Sword: \n 5 Gold", "Your sword has \n maximum level"};
	int swordLevel = 0;
	
	public CraftingScene(ApplicationStage stage)
	{
		super(new Pane());
		
		this.stage = stage;
		
		initializeRoot();
		
		//initializeMainPane();
		
		initializeSmallerPanes();
		
		initializeEventHandlers();
	}
	
	private void initializeRoot()
	{
		root = new Pane();
		super.setRoot(root);
		root.setPrefSize(640, 480);
		
		root.setBackground(new Background(new BackgroundFill(Color.rgb(134, 198, 154), null, null)));
	}
	
	private void initializeMainPane()
	{
		/*
		mainPane = new Pane();
		mainPane.setPrefSize(3*2 + 2*276, 390);
		
		mainPane.setLayoutX(42);
		mainPane.setLayoutY(40);
		
		root.getChildren().add(mainPane);
		
		
		mainPaneBackground = new Image(getClass().getResourceAsStream("/resources/craftingScene/craftingSceneBackground.png"), 272 * 2, 195 * 2, true, false);
		
		mainPaneBackgroundView = new ImageView();
		mainPaneBackgroundView.setImage(mainPaneBackground);
		
		mainPane.getChildren().add(mainPaneBackgroundView);
		*/
		
	}
	
	private void initializeSmallerPanes()
	{
		smallerPaneBackground = new Image(getClass().getResourceAsStream("/resources/craftingScene/smallerPartBackground.png"), 136 * 2, 63 * 2, true, false);
		
		initializeHelmetPane();
		
		initializeChestplatePane();
		
		initializeLeggingsPane();
		
		initializeBootsPane();
		
		initializePickaxePane();
		
		initializeSwordPane();
		
		
	}
	
	private void initializeHelmetPane()
	{
		helmetPane = new Pane();
		helmetPane.setPrefSize(272, 126);
		
		root.getChildren().add(helmetPane);
				
		helmetPane.setLayoutX(40);
		helmetPane.setLayoutY(44);
		
		helmetPaneBackgroundView = new ImageView();
		helmetPaneBackgroundView.setImage(smallerPaneBackground);
		
		helmetPane.getChildren().add(helmetPaneBackgroundView);
		
		helmetPaneBackgroundView.setLayoutX(0);
		helmetPaneBackgroundView.setLayoutY(0);
		
		helmetItem = new ToolbeltItem(stage.gameScene.toolbeltPane.itemBackground, stage.gameScene.toolbeltPane.itemTextures, stage.gameScene.toolbeltPane.toolImages[1][0]);
		helmetPane.getChildren().add(helmetItem);
		
		helmetItem.setLayoutX(40);
		helmetItem.setLayoutY(40);
		
		helmetLabel = new Label(helmetLabelTexts[helmetLevel]);
		helmetPane.getChildren().add(helmetLabel);
		
		helmetLabel.setLayoutX(100);
		helmetLabel.setLayoutY(20);
		
		
		helmetPane.setOnMouseClicked(EventHandler -> 
		{
			switch (helmetLevel)
			{
				case 0: 
				{
					if (stage.gameScene.inventoryPane.itemAmounts[2] >= 5) {
						stage.gameScene.toolbeltPane.items[0].setItem(stage.gameScene.toolbeltPane.toolImages[helmetLevel + 1][0]);
						
						helmetLevel++;
						
						helmetItem.setItem(stage.gameScene.toolbeltPane.toolImages[helmetLevel + 1][0]);
						helmetLabel.setText(helmetLabelTexts[helmetLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[2]);
						stage.gameScene.inventoryPane.itemAmounts[2] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[2]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					
					
					break;
				}
				case 1:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[3] >= 5) {
						stage.gameScene.toolbeltPane.items[0].setItem(stage.gameScene.toolbeltPane.toolImages[helmetLevel + 1][0]);
						
						helmetLevel++;
						
						helmetItem.setItem(stage.gameScene.toolbeltPane.toolImages[helmetLevel + 1][0]);
						helmetLabel.setText(helmetLabelTexts[helmetLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[3]);
						stage.gameScene.inventoryPane.itemAmounts[3] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[3]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				case 2:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[4] >= 5) {
						stage.gameScene.toolbeltPane.items[0].setItem(stage.gameScene.toolbeltPane.toolImages[helmetLevel + 1][0]);
						
						helmetLevel++;
						
						helmetItem.setItem(stage.gameScene.toolbeltPane.toolImages[helmetLevel + 1][0]);
						helmetLabel.setText(helmetLabelTexts[helmetLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[4]);
						stage.gameScene.inventoryPane.itemAmounts[4] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[4]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				case 3:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[5] >= 5)
					{
						stage.gameScene.toolbeltPane.items[0].setItem(stage.gameScene.toolbeltPane.toolImages[helmetLevel + 1][0]);
						helmetLevel++;
						helmetLabel.setText(helmetLabelTexts[helmetLevel]);
						stage.gameScene.inventoryPane.itemAmounts[5] -= 5;
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				default:
				{
					
					break;
				}
				
			}
		});
		
	}
	
	private void initializeChestplatePane()
	{
		chestplatePane = new Pane();
		chestplatePane.setPrefSize(272, 126);
		
		root.getChildren().add(chestplatePane);
		
		chestplatePane.setLayoutX(40 + 272 + 2);
		chestplatePane.setLayoutY(44);
		
		chestplatePaneBackgroundView = new ImageView();
		chestplatePaneBackgroundView.setImage(smallerPaneBackground);
		
		chestplatePane.getChildren().add(chestplatePaneBackgroundView);
		
		chestplatePaneBackgroundView.setLayoutX(0);
		chestplatePaneBackgroundView.setLayoutY(0);
		
		chestplateItem = new ToolbeltItem(stage.gameScene.toolbeltPane.itemBackground, stage.gameScene.toolbeltPane.itemTextures, stage.gameScene.toolbeltPane.toolImages[1][1]);
		chestplatePane.getChildren().add(chestplateItem);
		
		chestplateItem.setLayoutX(40);
		chestplateItem.setLayoutY(40);
		
		chestplateLabel = new Label(chestplateLabelTexts[chestplateLevel]);
		chestplatePane.getChildren().add(chestplateLabel);
		
		chestplateLabel.setLayoutX(100);
		chestplateLabel.setLayoutY(20);
		
		chestplatePane.setOnMouseClicked(EventHandler -> 
		{
			switch (chestplateLevel)
			{
				case 0: 
				{
					if (stage.gameScene.inventoryPane.itemAmounts[2] >= 5) {
						stage.gameScene.toolbeltPane.items[1].setItem(stage.gameScene.toolbeltPane.toolImages[chestplateLevel + 1][1]);
						
						chestplateLevel++;
						
						chestplateItem.setItem(stage.gameScene.toolbeltPane.toolImages[chestplateLevel + 1][1]);
						chestplateLabel.setText(chestplateLabelTexts[chestplateLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[2]);
						stage.gameScene.inventoryPane.itemAmounts[2] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[2]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					
					
					break;
				}
				case 1:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[3] >= 5) {
						stage.gameScene.toolbeltPane.items[1].setItem(stage.gameScene.toolbeltPane.toolImages[chestplateLevel + 1][1]);
						
						chestplateLevel++;
						
						chestplateItem.setItem(stage.gameScene.toolbeltPane.toolImages[chestplateLevel + 1][1]);
						chestplateLabel.setText(chestplateLabelTexts[chestplateLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[3]);
						stage.gameScene.inventoryPane.itemAmounts[3] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[3]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				case 2:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[4] >= 5) {
						stage.gameScene.toolbeltPane.items[1].setItem(stage.gameScene.toolbeltPane.toolImages[chestplateLevel + 1][1]);
						
						chestplateLevel++;
						
						chestplateItem.setItem(stage.gameScene.toolbeltPane.toolImages[chestplateLevel + 1][1]);
						chestplateLabel.setText(chestplateLabelTexts[chestplateLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[4]);
						stage.gameScene.inventoryPane.itemAmounts[4] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[4]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				case 3:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[5] >= 5)
					{
						stage.gameScene.toolbeltPane.items[1].setItem(stage.gameScene.toolbeltPane.toolImages[chestplateLevel + 1][1]);
						chestplateLevel++;
						chestplateLabel.setText(chestplateLabelTexts[chestplateLevel]);
						stage.gameScene.inventoryPane.itemAmounts[5] -= 5;
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				default:
				{
					
					break;
				}
				
			}
		});
		
	}
	
	private void initializeLeggingsPane()
	{
		leggingsPane = new Pane();
		leggingsPane.setPrefSize(272, 126);
		
		root.getChildren().add(leggingsPane);
		
		leggingsPane.setLayoutX(40);
		leggingsPane.setLayoutY(44 + 2 + 130);
		
		leggingsPaneBackgroundView = new ImageView();
		leggingsPaneBackgroundView.setImage(smallerPaneBackground);
		
		leggingsPane.getChildren().add(leggingsPaneBackgroundView);
		
		leggingsPaneBackgroundView.setLayoutX(0);
		leggingsPaneBackgroundView.setLayoutY(0);
		
		leggingsItem = new ToolbeltItem(stage.gameScene.toolbeltPane.itemBackground, stage.gameScene.toolbeltPane.itemTextures, stage.gameScene.toolbeltPane.toolImages[1][2]);
		leggingsPane.getChildren().add(leggingsItem);
		
		leggingsItem.setLayoutX(40);
		leggingsItem.setLayoutY(40);
		
		leggingsLabel = new Label(leggingsLabelTexts[leggingsLevel]);
		leggingsPane.getChildren().add(leggingsLabel);
		
		leggingsLabel.setLayoutX(100);
		leggingsLabel.setLayoutY(20);
		
		leggingsPane.setOnMouseClicked(EventHandler -> 
		{
			switch (leggingsLevel)
			{
				case 0: 
				{
					if (stage.gameScene.inventoryPane.itemAmounts[2] >= 5) {
						stage.gameScene.toolbeltPane.items[2].setItem(stage.gameScene.toolbeltPane.toolImages[leggingsLevel + 1][2]);
						
						leggingsLevel++;
						
						leggingsItem.setItem(stage.gameScene.toolbeltPane.toolImages[leggingsLevel + 1][2]);
						leggingsLabel.setText(leggingsLabelTexts[leggingsLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[2]);
						stage.gameScene.inventoryPane.itemAmounts[2] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[2]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					
					
					break;
				}
				case 1:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[3] >= 5) {
						stage.gameScene.toolbeltPane.items[2].setItem(stage.gameScene.toolbeltPane.toolImages[leggingsLevel + 1][2]);
						
						leggingsLevel++;
						
						leggingsItem.setItem(stage.gameScene.toolbeltPane.toolImages[leggingsLevel + 1][2]);
						leggingsLabel.setText(leggingsLabelTexts[leggingsLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[3]);
						stage.gameScene.inventoryPane.itemAmounts[3] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[3]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				case 2:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[4] >= 5) {
						stage.gameScene.toolbeltPane.items[2].setItem(stage.gameScene.toolbeltPane.toolImages[leggingsLevel + 1][2]);
						
						leggingsLevel++;
						
						leggingsItem.setItem(stage.gameScene.toolbeltPane.toolImages[leggingsLevel + 1][2]);
						leggingsLabel.setText(leggingsLabelTexts[leggingsLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[4]);
						stage.gameScene.inventoryPane.itemAmounts[4] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[4]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				case 3:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[5] >= 5)
					{
						stage.gameScene.toolbeltPane.items[2].setItem(stage.gameScene.toolbeltPane.toolImages[leggingsLevel + 1][2]);
						leggingsLevel++;
						leggingsLabel.setText(leggingsLabelTexts[leggingsLevel]);
						stage.gameScene.inventoryPane.itemAmounts[5] -= 5;
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				default:
				{
					
					break;
				}
				
			}
		});
		
	}
	
	private void initializeBootsPane()
	{
		bootsPane = new Pane();
		bootsPane.setPrefSize(272, 126);
		
		root.getChildren().add(bootsPane);
		
		bootsPane.setLayoutX(40 + 272 + 2);
		bootsPane.setLayoutY(44 + 2 + 130);
		
		bootsPaneBackgroundView = new ImageView();
		bootsPaneBackgroundView.setImage(smallerPaneBackground);
		
		bootsPane.getChildren().add(bootsPaneBackgroundView);
		
		bootsPaneBackgroundView.setLayoutX(0);
		bootsPaneBackgroundView.setLayoutY(0);
		
		bootsItem = new ToolbeltItem(stage.gameScene.toolbeltPane.itemBackground, stage.gameScene.toolbeltPane.itemTextures, stage.gameScene.toolbeltPane.toolImages[1][3]);
		bootsPane.getChildren().add(bootsItem);
		
		bootsItem.setLayoutX(40);
		bootsItem.setLayoutY(40);
		
		bootsLabel = new Label(bootsLabelTexts[bootsLevel]);
		bootsPane.getChildren().add(bootsLabel);
		
		bootsLabel.setLayoutX(100);
		bootsLabel.setLayoutY(20);
		
		bootsPane.setOnMouseClicked(EventHandler -> 
		{
			switch (bootsLevel)
			{
				case 0: 
				{
					if (stage.gameScene.inventoryPane.itemAmounts[2] >= 5) {
						stage.gameScene.toolbeltPane.items[3].setItem(stage.gameScene.toolbeltPane.toolImages[bootsLevel + 1][3]);
						
						bootsLevel++;
						
						bootsItem.setItem(stage.gameScene.toolbeltPane.toolImages[bootsLevel + 1][3]);
						bootsLabel.setText(bootsLabelTexts[bootsLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[2]);
						stage.gameScene.inventoryPane.itemAmounts[2] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[2]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					
					
					break;
				}
				case 1:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[3] >= 5) {
						stage.gameScene.toolbeltPane.items[3].setItem(stage.gameScene.toolbeltPane.toolImages[bootsLevel + 1][3]);
						
						bootsLevel++;
						
						bootsItem.setItem(stage.gameScene.toolbeltPane.toolImages[bootsLevel + 1][3]);
						bootsLabel.setText(bootsLabelTexts[bootsLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[3]);
						stage.gameScene.inventoryPane.itemAmounts[3] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[3]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				case 2:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[4] >= 5) {
						stage.gameScene.toolbeltPane.items[3].setItem(stage.gameScene.toolbeltPane.toolImages[bootsLevel + 1][3]);
						
						bootsLevel++;
						
						bootsItem.setItem(stage.gameScene.toolbeltPane.toolImages[bootsLevel + 1][3]);
						bootsLabel.setText(bootsLabelTexts[bootsLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[4]);
						stage.gameScene.inventoryPane.itemAmounts[4] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[4]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				case 3:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[5] >= 5)
					{
						stage.gameScene.toolbeltPane.items[3].setItem(stage.gameScene.toolbeltPane.toolImages[bootsLevel + 1][3]);
						bootsLevel++;
						bootsLabel.setText(bootsLabelTexts[bootsLevel]);
						stage.gameScene.inventoryPane.itemAmounts[5] -= 5;
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				default:
				{
					
					break;
				}
				
			}
		});
		
	}
	
	private void initializePickaxePane()
	{
		pickaxePane = new Pane();
		pickaxePane.setPrefSize(272, 126);
		
		root.getChildren().add(pickaxePane);
		
		pickaxePane.setLayoutX(42);
		pickaxePane.setLayoutY(44 + 2 + 2 + 130 + 130);
		
		pickaxePaneBackgroundView = new ImageView();
		pickaxePaneBackgroundView.setImage(smallerPaneBackground);
		
		pickaxePane.getChildren().add(pickaxePaneBackgroundView);
		
		pickaxePaneBackgroundView.setLayoutX(0);
		pickaxePaneBackgroundView.setLayoutY(0);
		
		pickaxeItem = new ToolbeltItem(stage.gameScene.toolbeltPane.itemBackground, stage.gameScene.toolbeltPane.itemTextures, stage.gameScene.toolbeltPane.toolImages[1][4]);
		pickaxePane.getChildren().add(pickaxeItem);
		
		pickaxeItem.setLayoutX(40);
		pickaxeItem.setLayoutY(40);
		
		pickaxeLabel = new Label(pickaxeLabelTexts[pickaxeLevel]);
		pickaxePane.getChildren().add(pickaxeLabel);
		
		pickaxeLabel.setLayoutX(100);
		pickaxeLabel.setLayoutY(20);
		
		pickaxePane.setOnMouseClicked(EventHandler -> 
		{
			switch (pickaxeLevel)
			{
				case 0: 
				{
					if (stage.gameScene.inventoryPane.itemAmounts[1] >= 5) {
						stage.gameScene.toolbeltPane.items[4].setItem(stage.gameScene.toolbeltPane.toolImages[pickaxeLevel + 1][4]);
						
						pickaxeLevel++;
						
						pickaxeItem.setItem(stage.gameScene.toolbeltPane.toolImages[pickaxeLevel + 1][4]);
						pickaxeLabel.setText(pickaxeLabelTexts[pickaxeLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[1]);
						stage.gameScene.inventoryPane.itemAmounts[1] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[1]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					
					
					break;
				}
				case 1:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[3] >= 5) {
						stage.gameScene.toolbeltPane.items[4].setItem(stage.gameScene.toolbeltPane.toolImages[pickaxeLevel + 1][4]);
						
						pickaxeLevel++;
						
						pickaxeItem.setItem(stage.gameScene.toolbeltPane.toolImages[pickaxeLevel + 1][4]);
						pickaxeLabel.setText(pickaxeLabelTexts[pickaxeLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[3]);
						stage.gameScene.inventoryPane.itemAmounts[3] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[3]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				case 2:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[4] >= 5) {
						stage.gameScene.toolbeltPane.items[4].setItem(stage.gameScene.toolbeltPane.toolImages[pickaxeLevel + 1][4]);
						
						pickaxeLevel++;
						
						pickaxeItem.setItem(stage.gameScene.toolbeltPane.toolImages[pickaxeLevel + 1][4]);
						pickaxeLabel.setText(pickaxeLabelTexts[pickaxeLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[4]);
						stage.gameScene.inventoryPane.itemAmounts[4] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[4]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				case 3:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[5] >= 5)
					{
						stage.gameScene.toolbeltPane.items[4].setItem(stage.gameScene.toolbeltPane.toolImages[pickaxeLevel + 1][4]);
						pickaxeLevel++;
						pickaxeLabel.setText(pickaxeLabelTexts[pickaxeLevel]);
						stage.gameScene.inventoryPane.itemAmounts[5] -= 5;
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				default:
				{
					
					break;
				}
				
			}
		});
		
	}
	
	private void initializeSwordPane()
	{
		swordPane = new Pane();
		swordPane.setPrefSize(272, 126);
		
		root.getChildren().add(swordPane);
		
		swordPane.setLayoutX(42 + 272 + 2);
		swordPane.setLayoutY(44 + 2 + 130 + 2 + 130);
		
		swordPaneBackgroundView = new ImageView();
		swordPaneBackgroundView.setImage(smallerPaneBackground);
		
		swordPane.getChildren().add(swordPaneBackgroundView);
		
		swordPaneBackgroundView.setLayoutX(0);
		swordPaneBackgroundView.setLayoutY(0);
		
		swordItem = new ToolbeltItem(stage.gameScene.toolbeltPane.itemBackground, stage.gameScene.toolbeltPane.itemTextures, stage.gameScene.toolbeltPane.toolImages[1][5]);
		swordPane.getChildren().add(swordItem);
		
		swordItem.setLayoutX(40);
		swordItem.setLayoutY(40);
		
		swordLabel = new Label(swordLabelTexts[swordLevel]);
		swordPane.getChildren().add(swordLabel);
		
		swordLabel.setLayoutX(100);
		swordLabel.setLayoutY(20);
		
		swordPane.setOnMouseClicked(EventHandler -> 
		{
			switch (swordLevel)
			{
				case 0: 
				{
					if (stage.gameScene.inventoryPane.itemAmounts[1] >= 5) {
						stage.gameScene.toolbeltPane.items[5].setItem(stage.gameScene.toolbeltPane.toolImages[swordLevel + 1][5]);
						
						swordLevel++;
						
						swordItem.setItem(stage.gameScene.toolbeltPane.toolImages[swordLevel + 1][5]);
						swordLabel.setText(swordLabelTexts[swordLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[1]);
						stage.gameScene.inventoryPane.itemAmounts[1] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[1]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					
					
					break;
				}
				case 1:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[3] >= 5) {
						stage.gameScene.toolbeltPane.items[5].setItem(stage.gameScene.toolbeltPane.toolImages[swordLevel + 1][5]);
						
						swordLevel++;
						
						swordItem.setItem(stage.gameScene.toolbeltPane.toolImages[swordLevel + 1][5]);
						swordLabel.setText(swordLabelTexts[swordLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[3]);
						stage.gameScene.inventoryPane.itemAmounts[3] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[3]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				case 2:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[4] >= 5) {
						stage.gameScene.toolbeltPane.items[5].setItem(stage.gameScene.toolbeltPane.toolImages[swordLevel + 1][5]);
						
						swordLevel++;
						
						swordItem.setItem(stage.gameScene.toolbeltPane.toolImages[swordLevel + 1][5]);
						swordLabel.setText(swordLabelTexts[swordLevel]);
						
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[4]);
						stage.gameScene.inventoryPane.itemAmounts[4] -= 5;
						System.out.println(stage.gameScene.inventoryPane.itemAmounts[4]);
						
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				case 3:
				{
					if (stage.gameScene.inventoryPane.itemAmounts[5] >= 5)
					{
						stage.gameScene.toolbeltPane.items[5].setItem(stage.gameScene.toolbeltPane.toolImages[swordLevel + 1][5]);
						swordLevel++;
						swordLabel.setText(swordLabelTexts[swordLevel]);
						stage.gameScene.inventoryPane.itemAmounts[5] -= 5;
						stage.gameScene.inventoryPane.updateLabels();
					}
					break;
				}
				default:
				{
					
					break;
				}
				
			}
		});
		
	}
	
	private void initializeEventHandlers()
	{
		this.setOnKeyPressed(new EventHandler<KeyEvent>() 
		{

			@Override
			public void handle(KeyEvent event) 
			{
                switch (event.getCode()) 
                {
				case E:
					stage.setScene(stage.gameScene);
					break;
				default:
					break;
                }
			}
		});
		
		this.setOnKeyReleased(new EventHandler<KeyEvent>() 
		{
            @Override
            public void handle(KeyEvent event) 
            {

            }
        });
		
		this.setOnKeyTyped(new EventHandler<KeyEvent>() 
		{
            @Override
            public void handle(KeyEvent event) 
            {

            }
        });
		
	}
	
}
