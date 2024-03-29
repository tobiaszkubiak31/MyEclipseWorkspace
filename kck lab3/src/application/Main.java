package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene.fxml"));
			   Parent root =(Parent) fxmlLoader.load();
			   
		       JavaFXController fooController = fxmlLoader.getController();
		      
		       Scene scene = new Scene(root, 800, 800);
		        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		        
		       // Font.loadFont(CustomFontApp.class.getResource("TRON.TTF").toExternalForm(), 10);
		        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Mansalva&display=swap");
		        
		        
		       primaryStage.setScene(scene);
		
		        
		       primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
