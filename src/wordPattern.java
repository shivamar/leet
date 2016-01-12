import java.util.HashMap;
import java.util.Map;

public class wordPattern {
	public boolean wordPattern(String pattern, String str) {
        HashMap<String,String> hmap = new HashMap<>();
        HashMap<String,String> hmap2 = new HashMap<>();
        
        String[] words = str.split(" ");
        if(words.length != pattern.length()) return false;
        
        for(int i=0;i<words.length;i++)
        {
            if(!hmap.containsKey(String.valueOf(pattern.charAt(i)))){
                hmap.put(String.valueOf(pattern.charAt(i)), words[i]);
              if(!hmap2.containsKey(words[i]))
                  hmap2.put(words[i],String.valueOf(pattern.charAt(i)));
            else return false;
            }else{
                if(!words[i].equals(hmap.get(String.valueOf(pattern.charAt(i)))))
                    return false;
            }   
        }
        
        return true;
        
    }
    
    
    //Best solution
    public boolean wordPattern_Best(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}