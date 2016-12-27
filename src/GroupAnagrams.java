import java.util.*;


/**
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 * @author Shiva
 *
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        int[] nu = {1,2,3};
        nu.clone();
        for(String str :  strs)
        {
            char[] chArr =  str.toCharArray();
            Arrays.sort(chArr);
            String strSorted=String.valueOf(chArr);
            List<String> res = map.get(strSorted);
            if( res == null){
                res = new ArrayList<String>();
                res.add(str);
                map.put(strSorted, res);
            }
            else{
                res.add(str);
                map.put(strSorted, res);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(List<String> li : map.values())
        {
            ans.add(li);
        }
        
        return ans;
    }
}