package application;

import java.util.ArrayList;
import javafx.geometry.Bounds;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;

public class PowerUp extends RectangleComponent
{
	private static final Image GREEN = new Image("resources/greenPowerup.png");
	private static final Image RED = new Image("resources/redPowerup.png");
	private static final Image BLUE = new Image("resources/bluePowerup.png");
	Group powerUpGroup;
	protected static ArrayList<PowerUp> powerUpArray = new ArrayList<PowerUp>();
	private int type;

	public PowerUp( Group g, double x, double y, int type )
	{
		powerUpGroup = g;
		component = new Rectangle();
		powerUpArray.add( 0, this );
		component.setWidth(30);
		component.setHeight(40);
		component.setTranslateX( x );
		component.setTranslateY( y );
		if( type == 1 )
		{
			component.setFill( new ImagePattern(GREEN) );
			setType(1);
		}
		else if( type == 2 )
		{
			component.setFill( new ImagePattern(BLUE) );
			setType(2);
		}
		else if( type == 3 )
		{
			component.setFill( new ImagePattern(RED) );
			setType(3);
		}
		g.getChildren().add( component );
	}

	public Bounds getBounds() 
	{
		return component.getBoundsInParent();
	}
	
	public void setType(int type) 
	{
		this.type = type;
	}
	
	public int getType() 
	{
		return this.type;
	}
	
	public void delete() 
	{
		powerUpGroup.getChildren().remove(component);
		powerUpArray.remove(this);
	}

	public static ArrayList<PowerUp> getPowerUpArrayList() 
	{
		return powerUpArray;
	}

	public static void resetArrayList() 
	{
		powerUpArray.clear();
	}
}