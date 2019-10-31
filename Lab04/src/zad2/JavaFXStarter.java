package zad2;
	
import zad2.JavaFXController;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class JavaFXStarter extends Application {
	protected JavaFXController fooController;
	private Stage stage;
	@FXML
	private void initialize() 
	{
		
	}
	 @Override
	    public void start(Stage stage) throws Exception {
		   this.stage = stage;
		   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene.fxml"));
		   Parent root =(Parent) fxmlLoader.load();
		   
	       fooController = fxmlLoader.getController();
	      
	       Scene scene = new Scene(root, 600, 400);
	        
	        
	        
	       stage.setTitle("Race");
	        
	        
	       stage.setScene(scene);
	
	        
	       stage.show();
	       zad2 runner = new zad2(this);
	       
	       
	        
	    }
	 protected void setScoreScene() throws IOException
	 {
		 
		 /*
		  FXMLLoader loader = new FXMLLoader(getClass()
		            .getResource("score.fxml"));
		   
		   
		    Parent root = (Parent)loader.load();
		        
		        this.stage.setScene(new Scene(root));
		    */

	 }
	 
	 
	public static void main(String[] args) {
		launch(args);
	}
}
