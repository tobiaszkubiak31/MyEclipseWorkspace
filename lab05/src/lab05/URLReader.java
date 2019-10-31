package lab05;
import java.net.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.io.*;

public class URLReader {
    public static ArrayList<String> getDataFromURL(String URL) throws Exception {

        URL oracle = new URL(URL);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));
        Set<String> names = new HashSet<String>();
        String inputLine;
        
        Random random = new Random();
        ArrayList<String> array = new ArrayList<>();
        
        while ((inputLine = in.readLine()) != null)
        {
        	array.add(inputLine);
            
        }
        
        
      
        //while(names.size()<1500)
       // {
        //	names.add(array.get(random.nextInt(array.size())));
        //}
        
        in.close();
        return array;
    }
    
}