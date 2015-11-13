

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Write a function to find the longest common prefix string amongst an array of strings.
    public String longestCommonPrefix(String[] strs) {
        if(strs == null) return "";
        
        if(strs.length== 0) return "";
        String ans = strs[0];
        
        for(String str : strs)
        {
            if(ans.length() > str.length()) {
                String temp = ans;
                ans = str;
                str = temp;
            }
            for(int i=0;i<str.length();i++)
            {
                if(i > ans.length()-1) continue;
                
                if(str.charAt(i) != ans.charAt(i)){
                   if(i>0) ans = ans.substring(0,i);
                   else ans = "";
                }
            }
        }
        
        return ans;
    }
}
