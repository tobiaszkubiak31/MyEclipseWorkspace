package zad3;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zad3 {
	public static void main(String[] args) {
	
		//List<Double> li = List.of((double)-5100, 43.257, (double)200000, 2000000.5); 
		//formattedNumbers(nums, 0, '/',2, true);
		List<Double> li = new ArrayList<Double>();
		li.add((double)-5100);
		li.add(43.257);
		li.add((double)200000);
		li.add(2000000.5);
		List<String> fn = formattedNumbers(li, 3, '|', 2, false); 
	
		

	}
	
	static List<String> formattedNumbers(List<Double> nums, int group, char separator, int
			nDigits, boolean padding) {
			String [] s = new String [4];
			for (int i = 0; i < nums.size(); i++) {
			    //System.out.println(nums.get(i));
			    //round double 
			    s[i] = Double.valueOf(round(nums.get(i), nDigits)).toString();
			}
			
			setPadding(padding, s, nDigits);
			setFormatting(group,s,separator);
			List<String> result = new ArrayList<String>();
			for(int i = 0 ; i < s.length ; i++){
				System.out.println(s[i]);	
				result.add(s[i]);
			}
			
			
			
			return result;
		
	}
	
	private static void setFormatting(int group, String[] s, char separator) {
		
		for(int i = 0 ; i < s.length ; i++){
			boolean isNegative = false;
			if(s[i].charAt(0) == '-')
			{
				s[i] = s[i].substring(1,s[i].length());
				isNegative = true;
			}
			
			int index = s[i].indexOf('.');
			//find a last digit in upper
			if(index > 0)
			{
				
			}
			else if (index == -1)
			{
				index = s[i].length();
			}
			
			int nIndex = index - group;
			if(index-group > 0)
			//	s[i] = s[i].substring(0,nIndex) + separator + s[i].substring(nIndex,s[i].length());
					
			
			while(nIndex>0)
			{
				s[i] = s[i].substring(0,nIndex) + separator + s[i].substring(nIndex,s[i].length());
				nIndex = nIndex - group;
				
			}
			
			if(isNegative == true)
			{
				s[i] = '-' + s[i];
			}
			
			
			
			
		}
		 
		
	}

	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	
	
	static void  setPadding(boolean padding, String[] s, int nDigits)
	{
		for(int i = 0 ; i < s.length ; i++){
			
			
			//adding 00 to end
			if(padding==true){

					//System.out.println(s[i]);
					int index = s[i].indexOf(".");
					if(index > 0 ){
						
						int length = s[i].length();
						int digitsAfterComa = length - index;
						if(nDigits+1 - digitsAfterComa > 0){
							for(int l = 0 ; l < nDigits+1- digitsAfterComa  ; l++){
								s[i]+='0';
							}
						}
						
								
					}
					else if(index==-1){
						
					}

			}
			//delete 0 at the end
			else if(padding == false){
				int index = s[i].indexOf(".");
				if(index > 0 ){
					int lastIndex = s[i].length()-1 ;
					int placestoDelete = 0;
					while(true){
						if(s[i].charAt(lastIndex) == '0'){
							placestoDelete++;
						}
						else 
							break;
						lastIndex--;
					}
					if(placestoDelete>0){
						s[i] = s[i].substring(0,s[i].length()-placestoDelete);
					}
					if(s[i].charAt(s[i].length()-1) == '.'){
						s[i] = s[i].substring(0,s[i].length()-placestoDelete);
					}
					
							
				}
				else if(index==-1){
					
				}
				

			}
				
			
	}	
	}
	

}
