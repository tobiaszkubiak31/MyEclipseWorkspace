package lab05;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LearnEnglish {
	static Random random = new Random(); 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int k = 3;
		int daysToForgot = k;
		int n = 10;
		ArrayList baseWords = new ArrayList();
		ArrayList semilearnedWords = new ArrayList();
		ArrayList learnedWords = new ArrayList();
		
		baseWords = URLReader.getDataFromURL("http://szgrabowski.kis.p.lodz.pl/zpo19/1500.txt");
		
		//shouldForgotRandom();
		//String[] s = new String[2];
		
		for(int day = 0 ; day < n ; day++)
		{
			//losowanie 2//print
			//s[0] = baseWords.
			//add to learned and remove from base
			int random1 = random.nextInt(baseWords.size());
			semilearnedWords.add((String) baseWords.get(random1));
			System.out.print("\nNew words: " + (String) baseWords.get(random1));
			baseWords.remove(random1);
			
			//add to learned and remove from base
			random1 = random.nextInt(baseWords.size());
			semilearnedWords.add((String) baseWords.get(random1));
			System.out.println(" " + baseWords.get(random1));
			baseWords.remove(random1);
			
			
			//zapominanie max 2 print
			System.out.println(semilearnedWords);
			System.out.print("Forgotten words: ");
			
			for(int d = 0 ,forgotten=0; d < semilearnedWords.size() ; d++){
				
				if(forgotten == 2){
					break;
				}
				if(shouldForgotRandom()){
					System.out.print(" " + (String) semilearnedWords.get(d));
					baseWords.add((String) semilearnedWords.get(d));
					
					semilearnedWords.remove(d);
					forgotten++;
					
				}
			}
			
			if(daysToForgot<day)
			{
				try{
				
				learnedWords.add((String) semilearnedWords.get(0));
				semilearnedWords.remove(0);
				learnedWords.add((String) semilearnedWords.get(1));
				semilearnedWords.remove(1);
				System.out.print("You constatnt learned " + learnedWords);
				}
				catch(Exception e){
				}
				
			}
			
			
			System.out.println("");
		
			
			//print slownika
			//System.out.println(learnedWords);
		}
		  
		

		
		System.out.println("semi learned word" + semilearnedWords);
		System.out.println("constant learned word" + learnedWords);
		
}

	private static boolean shouldForgotRandom() {
		
		//int choice = random.nextInt(2);
		if(random.nextInt(2)==0)
		 return true;
		else
		 return false;
		
	}

	
}
