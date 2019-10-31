package application;
	
import java.util.ArrayList;
import java.util.List;

import application.view.JavaFXController;
import datastructures.CyclistRecord;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class JavaFXStarter extends Application {
	@FXML
	private void initialize() 
	{
		
	}
	 JavaFXController fooController;
	public static List <Label> labelString = new ArrayList <Label>();
	 @Override
	    public void start(Stage stage) throws Exception {
		   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/scene.fxml"));
		   Parent root =(Parent) fxmlLoader.load();
		   
	       fooController = fxmlLoader.getController();
	       
	      
	       labelString = new ArrayList <Label>();
	       initLabels();
	       System.out.println(labelString);
	       
	       Scene scene = new Scene(root, 300, 275);
	       stage.setTitle("Race");
	       stage.setScene(scene);
	       stage.show();
	       initLabels();
	       DataAppClass data = new DataAppClass(this);
	       
	        
	       
	        
	    }
	private void initLabels() {
		labelString.add(fooController.name1);
		labelString.add(fooController.time1);
		labelString.add(fooController.name2);
		labelString.add(fooController.time2);
		labelString.add(fooController.name3);
		labelString.add(fooController.time3);
		labelString.add(fooController.name4);
		labelString.add(fooController.time4);
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	void setNamesWindow(List<CyclistRecord> list)
	{
		 Platform.runLater(new Runnable() {
		        @Override
		        public void run() {
		        	int indexLabel = 0;
		    		for (int i = 0; i < list.size(); i++) {
		    			list.get(i);
		    			
		    			labelString.get(indexLabel).setText(list.get(i).name.toString());
		    			labelString.get(indexLabel+1).setText(Double.toString(list.get(i).time));
		    			
		    			indexLabel +=2;
		    			if(i == 3){
		    				break;
		    			}
		    		}
		        	
		        	
		        	
		        	
		        }
		    });
		
	}
	
}
