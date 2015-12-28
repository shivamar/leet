public class reverseASentence {
    public String reverseWords(String s) {
        String ans="";
        int end=-1;
        for(int i=s.length()-1; i >=0; i--)
        {
            if(s.charAt(i)==' ') continue;
            
            if(end == -1) end  = i;
            while(i >= 0 && s.charAt(i) != ' ') i--;
             ans = ans + s.substring(i+1,end+1)+" ";
             end  = -1;
        }
        
        return ans.trim();
    }
}