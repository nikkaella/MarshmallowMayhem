package application;

import java.util.*;

import application.SpriteAnimation;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Character 
{
	Enemy enemy;
	Wall wall;
	private int lives=5;
	private int speed;
	private boolean stateOnPlatform;
	private boolean stateAlive=true;
	private boolean stateInvincible;
	private boolean stateOnEnemy;
	private boolean stateOnWall;
	private boolean stateCanJump;
	private boolean stateRunning;
	public boolean statePunching=false;
	private double xPos;
	private double yPos;
	//	Rectangle mainCharField;

	ImageView mainCharField;
	Animation animation;

	//Spritesheet stuff
	private static final Image PUNCH = new Image("resources/punch.png");
	private static final Image RUNNING = new Image("resources/running.png");
	private static final Image JUMP = new Image("resources/jumping.png");
	private static final int COLUMNS = 2;
	private static final int COUNT = 4;
	private static final int OFFSET_X = 0;
	private static final int OFFSET_Y = 0;
	private static final int WIDTH = 59;
	private static final int HEIGHT = 60;



	public Character(Group g, int lifeCount)
	{

		new Timer().schedule(new TimerTask() {public void run() {stateInvincible = false;}
		}, 0, 2000);


		mainCharField = new ImageView(RUNNING);
		mainCharField.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH,HEIGHT ));
		mainCharField.setLayoutX(0);
		mainCharField.setLayoutY(0);
		mainCharField.setX(0);
		mainCharField.setY(-120);

		g.getChildren().add(mainCharField);

		Animation animation = new SpriteAnimation(
				mainCharField, Duration.millis(400),
				COUNT, COLUMNS, OFFSET_X, OFFSET_Y,
				WIDTH, HEIGHT
				);
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();

	}

	public void loadRunning(Group charGroup) 
	{
		this.stateRunning = true;
		mainCharField.setImage(RUNNING);
		mainCharField.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH,HEIGHT ));

		animation = new SpriteAnimation(
				mainCharField, Duration.millis(4000),
				COUNT, COLUMNS, OFFSET_X, OFFSET_Y,
				WIDTH, HEIGHT
				);
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();
	}

	public void loadPunch() 
	{
		mainCharField.setImage(PUNCH);
		mainCharField.setViewport(new Rectangle2D(0,0, 79, 60));
		//animation.stop();
	}

	public void loadJump()
	{
		this.stateRunning = false;
		mainCharField.setImage(JUMP);
		mainCharField.setViewport(new Rectangle2D(0,0, 59, 59));
	}

	public void jump()
	{	
	}

	public void punch (Wall wall)
	{
		wall.breakWall(wall);
	}

	//Get Bounds
	public double getMinY()
	{
		return mainCharField.getBoundsInParent().getMinY();
	}

	public double getMaxY()
	{
		return mainCharField.getBoundsInParent().getMaxY();
	}
	public double getMinX()
	{
		return mainCharField.getBoundsInParent().getMinX();
	}

	public double getMaxX()
	{
		return mainCharField.getBoundsInParent().getMaxX();
	}

	///Movement
	public void move(double x, double y)
	{

	}

	//adds a Life
	public void addLife(int lives)
	{
		lives++;
	}

	//Removes a life

	////Setters/Getters
	public int getLives() 
	{
		return lives;
	}

	public void setLives(int lives) 
	{
		this.lives = lives;
	}

	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public boolean isStateOnPlatform()
	{
		return stateOnPlatform;
	}

	public void setStateOnPlatform(boolean stateOnPlatform) 
	{
		this.stateOnPlatform = stateOnPlatform;
	}

	public boolean isStateAlive() 
	{
		return stateAlive;
	}

	public void setStateAlive(boolean stateAlive) 
	{
		this.stateAlive = stateAlive;
	}

	public boolean isStateInvincible()
	{
		return stateInvincible;
	}

	public void setStateInvincible(boolean stateInvincible) 
	{
		this.stateInvincible = stateInvincible;
	}

	public double getxPos()
	{
		return xPos;
	}

	public void setxPos(double xPos)
	{
		this.xPos = xPos;
	}

	public double getyPos() 
	{
		return yPos;
	}

	public void setyPos(double yPos) 
	{
		this.yPos = yPos;
	}

	public Enemy getEnemy()
	{
		return enemy;
	}

	public void setEnemy(Enemy enemy) 
	{
		this.enemy = enemy;
	}

	public Wall getWall() 
	{
		return wall;
	}

	public void setWall(Wall wall) {
		this.wall = wall;
	}

	public boolean isStateOnEnemy() 
	{
		return stateOnEnemy;
	}

	public void setStateOnEnemy(boolean stateOnEnemy) 
	{
		this.stateOnEnemy = stateOnEnemy;
	}

	public boolean isStateOnWall() 
	{
		return stateOnWall;
	}

	public void setStateOnWall(boolean stateOnWall) 
	{
		this.stateOnWall = stateOnWall;
	}

	public boolean getStateCanJump() 
	{
		return stateCanJump;
	}

	public void setStateCanJump(boolean stateCanJump)
	{
		this.stateCanJump = stateCanJump;
	}

	public boolean isStateRunning()
	{
		return stateRunning;
	}

	public void setStateRunning(boolean stateRunning)
	{
		this.stateRunning = stateRunning;
	}

	public boolean isStatePunching()
	{
		return statePunching;
	}

	public void setStatePunching(boolean statePunching)
	{
		this.statePunching = statePunching;
	}
}