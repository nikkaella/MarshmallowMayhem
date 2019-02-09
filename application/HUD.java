package application;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HUD extends RectangleComponent
{
	Group HUDGroup = new Group();	
	ArrayList<ImageView> healthCount = new ArrayList<ImageView>();
	ArrayList<Circle> powerUp = new ArrayList<Circle>();

	private static final Image POWERUP = new Image("resources/greenPowerup.png");
	int healthCountPos;
	int x = 13;
	int y = 20;
	ImageView livesView;
	String score="0";
	Circle cInvincible = new Circle(10);
	Text highScoreText = new Text(20, 20, score);
	Rectangle component = new Rectangle();


	private static final Image HEARTS = new Image("resources/chocolate.png");

	public HUD(Group root, int lifeCount) 
	{
		component.setWidth(20);
		component.setHeight(30);
		component.setFill(new ImagePattern(POWERUP));
		
		root.getChildren().add(HUDGroup);
		for (int i = 0; i <= lifeCount-1; i++) 
		{
			livesView = new ImageView(HEARTS);
			livesView.setFitWidth(50);
			livesView.setPreserveRatio(true);
			livesView.setSmooth(true);

			healthCount.add(livesView);
			healthCount.trimToSize();

			livesView.setTranslateX(x);
			livesView.setTranslateY(y);

			HUDGroup.getChildren().add(livesView);
			x = x + 35;
		}
		healthCountPos = healthCount.size() - 1;
		component.setLayoutX(20);
		component.setLayoutY(50);
		cInvincible.setCenterX(280);
		cInvincible.setCenterY(10);
		cInvincible.setFill(Color.BLUE);
		
		highScoreText.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
		highScoreText.setFill(Color.BISQUE);
		HUDGroup.getChildren().add(highScoreText);
	}

	public void removeHealth() 
	{
		if (healthCountPos > -1) 
		{
			HUDGroup.getChildren().remove(healthCount.get(healthCountPos));
			healthCount.remove(healthCount.size() - 1);
			healthCount.trimToSize();
			healthCountPos--;
			x = x - 35;
		}
	}

	public void addHealth() 
	{	
		livesView = new ImageView(HEARTS);
		livesView.setFitWidth(50);
		livesView.setPreserveRatio(true);
		livesView.setSmooth(true);
		healthCount.add(livesView);
		healthCount.trimToSize();

		livesView.setTranslateX(x);
		livesView.setTranslateY(y);

		HUDGroup.getChildren().add(livesView);
		x = x + 35;
		healthCountPos++;
	}

	public void showPowerUp(int type)
	{
		component.setWidth(20);
		component.setHeight(30);
		component.setFill(new ImagePattern(POWERUP));	

		if(type==1)
		{
			HUDGroup.getChildren().add(component);
		}
		if(type==2)
		{
			HUDGroup.getChildren().add(cInvincible);
		}	
	}
	public void removePowerUp(int type)
	{
		
		if(type==1)
		{
			HUDGroup.getChildren().remove(component);
		}	
		if(type==2)
		{
			HUDGroup.getChildren().remove(cInvincible);
		}	
	}
	public void setScore(String score)
	{
		
		highScoreText.setText(score);
	}
}