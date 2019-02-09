package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MarshmallowMayhem extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() 
		{
			public void handle(WindowEvent event) 
			{
				System.exit(0);
			}
		});
		new Menu(primaryStage).displayMenu();
		primaryStage.setTitle("Marshmallow Mayhem");
		primaryStage.show();
	}

	public static void main(String[] args) 
	{		
		launch(args);
	}
}
