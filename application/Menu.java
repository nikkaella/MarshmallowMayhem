package application;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Menu
{
	Stage stage = new Stage();
	Scene menuScene;	
	String highScoreString=" ";
	private static final Image GREEN = new Image("resources/greenPowerup.png");
	private static final Image RED = new Image("resources/redPowerup.png");
	private static final Image BLUE = new Image("resources/bluePowerup.png");
	private static final Image WALL = new Image("resources/Wall.png");
	private static final Image ENEMY = new Image("resources/enemy.png");
	private final Media m = new Media(Paths.get("src/resources/MySong.mp3").toUri().toString());
	private final MediaPlayer mp = new MediaPlayer(m);



	public Menu (Stage primaryStage)
	{
		try 
		{
			File highScores = new File("src/resources/highScores.txt");
			Scanner input =new Scanner(highScores);
			highScoreString = input.nextLine();
			input.close();
		}
		catch(Exception e)
		{
			System.out.println("FILE ERROR");
		}
		//System.out.println(com.sun.javafx.runtime.VersionInfo.getRuntimeVersion());

		Group menuRoot = new Group();
		Image backgroundImage = new Image("resources/greenBackground.png", 1000, 600, false, false);
		ImageView backgroundImageView = new ImageView(backgroundImage);		
		Button playButton = new Button ("Play");
		playButton.setLayoutX(250);
		playButton.setLayoutY(100);
		playButton.setFont(new Font("Roboto", 15));
		playButton.setStyle("-fx-base: #AA0121");
		playButton.setTextFill(Color.BISQUE);
		playButton.setPrefSize(100, 50);
		Button instructionsButton = new Button ("Instructions");
		instructionsButton.setLayoutX(650);
		instructionsButton.setLayoutY(100);
		instructionsButton.setFont(new Font("Roboto", 14));
		instructionsButton.setStyle("-fx-base: #AA0121");
		instructionsButton.setTextFill(Color.BISQUE);
		instructionsButton.setPrefSize(100, 50);
		Button creditsButton = new Button ("Credits");
		creditsButton.setLayoutX(250);
		creditsButton.setLayoutY(400);
		creditsButton.setFont(new Font("Roboto", 15));
		creditsButton.setStyle("-fx-base: #AA0121");
		creditsButton.setTextFill(Color.BISQUE);
		creditsButton.setPrefSize(100, 50);
		Button quitButton = new Button ("Quit");
		quitButton.setLayoutX(650);
		quitButton.setLayoutY(400);
		quitButton.setFont(new Font("Roboto", 15));
		quitButton.setStyle("-fx-base: #AA0121");
		quitButton.setTextFill(Color.BISQUE);
		quitButton.setPrefSize(100, 50);
		Text titleText = new Text (335,290,"Marshmallow Mayhem");
		titleText.setFill(Color.BISQUE);
		titleText.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));
		Text highScoreText = new Text(5, 20, highScoreString);
		highScoreText.setFont(Font.font ("Roboto", FontWeight.BOLD, 20));
		highScoreText.setFill(Color.BISQUE);

		Button backButton = new Button("Back");		

		quitButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle (ActionEvent event)
			{
				primaryStage.close();
			}
		});

		playButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle (ActionEvent event)
			{
				new World(primaryStage).display();	
			}
		});

		menuRoot.getChildren().addAll(backgroundImageView, playButton, instructionsButton, creditsButton, quitButton, titleText, highScoreText);		
		menuScene = new Scene (menuRoot, 1000, 600);

		primaryStage.setScene(menuScene);
		stage.setTitle("Marshmallow Mayhem");
		stage.setResizable(false);
		stage=primaryStage;
		stage.show();

		backButton.setOnAction(e -> setprimaryStage(primaryStage, menuScene));
		instructionsButton.setOnAction(e -> setInstructionsScene(primaryStage, backButton));
		creditsButton.setOnAction(e -> setCreditsScene(primaryStage, backButton));	
	}

	public void setprimaryStage (Stage mStage, Scene altScene)
	{
		mp.stop();
		mStage.setScene(altScene);
	}

	public void setInstructionsScene(Stage mStage, Button instructionsBackButton)
	{
		Group instrRoot = new Group();
		Image backgroundImage = new Image("resources/greenBackground.png", 1000, 600, false, false);
		ImageView backgroundImageView = new ImageView(backgroundImage);
		Rectangle greenKiss = new Rectangle();
		greenKiss.setWidth(30);
		greenKiss.setHeight(40);
		greenKiss.setTranslateX( 330 );
		greenKiss.setTranslateY( 290 );
		greenKiss.setFill( new ImagePattern(GREEN) );
		Rectangle blueKiss = new Rectangle();
		blueKiss.setWidth(30);
		blueKiss.setHeight(40);
		blueKiss.setTranslateX( 330 );
		blueKiss.setTranslateY( 340 );
		blueKiss.setFill( new ImagePattern(BLUE) );
		Rectangle redKiss = new Rectangle();
		redKiss.setWidth(30);
		redKiss.setHeight(40);
		redKiss.setTranslateX( 330 );
		redKiss.setTranslateY( 240 );
		redKiss.setFill( new ImagePattern(RED) );
		Rectangle wall = new Rectangle();
		wall.setWidth(25);
		wall.setHeight(40);
		wall.setTranslateX(333);
		wall.setTranslateY(393);
		wall.setFill( new ImagePattern(WALL));
		Rectangle enemy = new Rectangle();
		enemy.setWidth(35);
		enemy.setHeight(35);
		enemy.setTranslateX(328);
		enemy.setTranslateY(448);
		enemy.setFill( new ImagePattern(ENEMY));

		instructionsBackButton.setLayoutX(440);
		instructionsBackButton.setLayoutY(525);
		instructionsBackButton.setFont(new Font("Roboto", 15));
		instructionsBackButton.setStyle("-fx-base: #AA0121");
		instructionsBackButton.setTextFill(Color.BISQUE);
		instructionsBackButton.setPrefSize(100, 50);

		Text textW = new Text(180,75,"W/SPACE: Jump");
		Text textA = new Text(180,125,"A: Left");
		Text textD = new Text(180,175,"D: Right");
		Text textE = new Text(180,225,"E: Punch");
		Text textRed = new Text(180,275,"Extra Life");
		Text textGreen = new Text(180,325,"Jump Boost");
		Text textBlue = new Text(180,375,"Extra Points");
		Text textWall = new Text(180,425,"Wall: Punch it");
		Text textEnemy = new Text(180,475,"Enemy: Dodge it");

		textW.setFill(Color.BISQUE);
		textW.setLayoutX(200);
		textW.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));
		textA.setFill(Color.BISQUE);
		textA.setLayoutX(200);
		textA.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));
		textE.setFill(Color.BISQUE);
		textE.setLayoutX(200);
		textE.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));
		textD.setFill(Color.BISQUE);
		textD.setLayoutX(200);
		textD.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));
		textRed.setFill(Color.BISQUE);
		textRed.setLayoutX(200);
		textRed.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));
		textBlue.setFill(Color.BISQUE);
		textBlue.setLayoutX(200);
		textBlue.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));
		textGreen.setFill(Color.BISQUE);
		textGreen.setLayoutX(200);
		textGreen.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));
		textWall.setFill(Color.BISQUE);
		textWall.setLayoutX(200);
		textWall.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));
		textEnemy.setFill(Color.BISQUE);
		textEnemy.setLayoutX(200);
		textEnemy.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));

		Scene instructionsScene = new Scene(instrRoot, 1000, 600);
		instrRoot.getChildren().addAll(backgroundImageView, instructionsBackButton, textW, textA, textE, textD, textRed, textBlue, 
				textGreen, textWall, textEnemy, greenKiss, blueKiss, redKiss, wall, enemy);

		mStage.setScene(instructionsScene);
	}

	public void setCreditsScene(Stage mStage, Button creditsBackButton)
	{
		Group credRoot = new Group();
		Image backgroundImage = new Image("resources/greenBackground.png", 1000, 600, false, false);
		Image vampireImage = new Image("resources/vampireRobot.png", 50, 50, true, true);

		ImageView backgroundImageView = new ImageView(backgroundImage);
		ImageView vampire = new ImageView(vampireImage);
		vampire.setLayoutX(620);
		vampire.setLayoutY(210);

		creditsBackButton.setLayoutX(440);
		creditsBackButton.setLayoutY(525);
		creditsBackButton.setFont(new Font("Roboto", 15));
		creditsBackButton.setStyle("-fx-base: #AA0121");
		creditsBackButton.setTextFill(Color.BISQUE);
		creditsBackButton.setPrefSize(100, 50);

		Text creditsText = new Text(235,100,"Credits:");
		Text bradText = new Text(215,150,"Brad Eblin");
		Text samText = new Text(165,200,"Samuel Goldstein");
		Text danText = new Text(185,250,"Daniel Hannani");
		Text nikkaText = new Text(200,300,"Nikka Yalung");
		Text healthText = new Text(185,350,"Health: Artipho");
		Text powerUpText = new Text(90,400,"Power Up: candywarehouse");

		creditsText.setFill(Color.BISQUE);
		creditsText.setLayoutX(200);
		creditsText.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));
		bradText.setFill(Color.BISQUE);
		bradText.setLayoutX(200);
		bradText.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));
		samText.setFill(Color.BISQUE);
		samText.setLayoutX(200);
		samText.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));
		danText.setFill(Color.BISQUE);
		danText.setLayoutX(200);
		danText.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));
		nikkaText.setFill(Color.BISQUE);
		nikkaText.setLayoutX(200);
		nikkaText.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));
		healthText.setFill(Color.BISQUE);
		healthText.setLayoutX(200);
		healthText.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));
		powerUpText.setFill(Color.BISQUE);
		powerUpText.setLayoutX(200);
		powerUpText.setFont(Font.font ("Roboto", FontWeight.BOLD, 30));

		credRoot.getChildren().addAll(backgroundImageView, creditsBackButton, creditsText, bradText, 
				samText, danText, nikkaText, healthText, powerUpText, vampire);
		Scene creditScene = new Scene(credRoot, 1000, 600);
		mStage.setScene(creditScene);
		vampire.setOnMouseClicked(e -> mp.play());

	}

	public void displayMenu()
	{
		stage.setResizable(false);
		stage.setScene(menuScene);
		stage.centerOnScreen();
	}
}