package application;

import java.util.ArrayList;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Enemy extends RectangleComponent
{
	protected static ArrayList<Enemy> enemiesArray = new ArrayList<Enemy>();
	protected Color enemyColor;
	Group componentGrp;
	private static final Image ENEMY = new Image("resources/enemy.png");
	
	public Enemy(Group componentsGroup, double xCoord, double yCoord) 
	{	
		component = new Rectangle(-50, yCoord,35,35);
		component.setWidth(50);
		component.setHeight(50);
		component.setFill(new ImagePattern(ENEMY));
		componentsGroup.getChildren().add(component);
		enemiesArray.add(0, this);
	}
	
	public static ArrayList<Enemy> getEnemiesArrayList() 
	{
		return enemiesArray;
	}
	
	public Bounds getBounds() 
	{
		return component.getBoundsInParent();
	}
	
	public static void reset() 
	{
		enemiesArray.clear();
	}

	public void delete()
	{
		componentGrp.getChildren().remove(component);
		enemiesArray.remove(this);
		
	}
}