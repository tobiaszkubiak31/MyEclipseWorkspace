package application;
import java.util.PriorityQueue;
import java.util.Set;
import Poligon.*;
import datastructures.CyclistRecord;
public class DataAppClass {
	public  Set<String> names;
	public static  PriorityQueue<CyclistRecord> queue ;
	JavaFXStarter window;
	
	public DataAppClass(JavaFXStarter window) throws Exception {
		this.window=window;
		Set names = URLReader.getNamesFromURL();
		Queue queueObject = new Queue();
		queue = queueObject.queue;
		System.out.println("main");
		AddCyclistTimer timer = new AddCyclistTimer(names,window);
	
		
		
	}

}
