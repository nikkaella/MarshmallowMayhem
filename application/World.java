package application;

import java.util.Random;

import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class World extends GameLoop 
{
	Image rF;
	Rectangle rainforest;
	private static final Image RAINFOREST = new Image("resources/greenBackground.png");
	protected ImageView background;

	public World(Stage primaryStage) 
	{
		super(primaryStage);
		super.stageWidth=1000;
		super.stageHeight=600;
	}

	@Override
	public void initBackground() 
	{
		background = new ImageView(RAINFOREST);
		TranslateTransition backgroundTranslate = new TranslateTransition(Duration.millis(7500), background);
		backgroundTranslate.setFromX(0);
		backgroundTranslate.setToX(-1024);
		backgroundTranslate.setInterpolator( Interpolator.LINEAR );
		backgroundTranslate.setCycleCount(Timeline.INDEFINITE);
		componentsGroup.getChildren().add(background);
		backgroundTranslate.play();
	}

	@Override
	public void initStage() 
	{
		//So array isnt empty
		new Platform(componentsGroup,0, -20, 100);
		new Wall(componentsGroup,2000, 2000, 1, 1);
		new PowerUp(componentsGroup, 2000, 2000,1);
		new Enemy(componentsGroup, 2000, 2000);

		mainChar = new Character(componentsGroup, 3);
		hud = new HUD(componentsGroup, 3);
	}

	public static void createPlatform(Group componentsGroup, Random n)
	{

		new Platform(componentsGroup, 900,(n.nextInt(20))*40,100);

	}

	public void display()
	{
		stage.setScene(scene);
		stage.centerOnScreen();
	}
}