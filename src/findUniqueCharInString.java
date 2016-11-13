import java.util.*;


public class findUniqueCharInString {

	    public int firstUniqChar(String s) {
	        LinkedHashMap<String,Integer> lHs = new LinkedHashMap<String,Integer>();
	        Set<String> set = new HashSet<>();
	        
	        for(int index=0; index < s.length();index++)
	        {
	            String key = String.valueOf(s.charAt(index));
	            Integer val = lHs.get(key);
	            if(val == null && !set.contains(key))
	              lHs.put(key, index);
	            else{
	                lHs.remove(key);
	                set.add(key);
	            }
	        }
	        
	        Iterator<Map.Entry<String,Integer>> itr = lHs.entrySet().iterator();
	        while(itr.hasNext()){
	            Map.Entry<String,Integer> entryValue = itr.next();
	            return entryValue.getValue();
	        }
	        
	        return -1;
	    }
	}