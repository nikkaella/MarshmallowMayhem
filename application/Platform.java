package application;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Platform extends RectangleComponent
{
	protected static ArrayList<Platform> platformsArray = new ArrayList<Platform>();
	Group componentsGrp;
	private static final Image PLATFORM = new Image("resources/platform.png");
	//Rectangle component;
	
	public Platform(Group componentsGroup, double x, double y, double width, double height, Color color) 
	{
		this(componentsGroup, x, y, width);
		componentsGrp=componentsGroup;
		component.setHeight(height);
		component.setFill(color);
		platformsArray.add(0, this);
	}

	public Platform(Group componentsGroup, double x, double y, double width) 
	{
		//Set up component
		componentsGrp=componentsGroup;
		component = new Rectangle();
		component.setWidth(width);
		component.setHeight(20);
		component.setFill(new ImagePattern(PLATFORM));
		component.setTranslateX(x);
		component.setTranslateY(y);
		
		//Add Platform ArrayList
		platformsArray.add(0, this);
		
		//Add component to root of passed in scene
		componentsGroup.getChildren().add(component);
	}
	
	public static ArrayList<Platform> getPlatformsArrayList() 
	{
		return platformsArray;
	}
	
	public void delete() 
	{
		componentsGrp.getChildren().remove(component);
		platformsArray.remove(this);	
	}
	
	public static void reset() 
	{
		platformsArray.clear();
	}
}