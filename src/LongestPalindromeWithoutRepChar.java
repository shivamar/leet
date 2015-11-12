import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestPalindromeWithoutRepChar {
	
	public static void main(String[] args)
	{
		System.out.println(lengthOfLongestSubstring("gasdfzxcvbnnmlopi"));
		
	}
	
    public static int lengthOfLongestSubstring(String s) {
    	int maxCount=0;
        if(s.length() < 2) return s.length();
        Set<Character> hs = new LinkedHashSet<Character>();
        
        for(int i=0;i<s.length();i++)
        {       
            Character c = s.charAt(i);
            if(!hs.contains(c)){
            	hs.add(c);            
             }
             else{
            	 if(hs.size() > maxCount) maxCount = hs.size(); 
            	 Iterator<Character> itr = hs.iterator();
            	 Character curr = null;
                 while(c!=curr)
                 {
                	 curr = itr.next();
                	 itr.remove();
                 }
             }
        }
        
        return maxCount;
    }
}