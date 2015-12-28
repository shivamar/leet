public class RevereseASentence {
    /*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the". 
    */
    public static String reverseWords(String s) {
        if(s.equals("")) return "";
        s = s.trim().replaceAll(" ","99");
        String[] strarr = s.split("99");
        
        for(int i=0; i < strarr.length && strarr.length-1-i > i;i++)
        {
            String temp = strarr[i];
            strarr[i] = strarr[strarr.length-1-i];
            strarr[strarr.length-1-i]= temp;
        }
        
        StringBuilder strB =  new StringBuilder();
        
        for(String str : strarr)
        	strB.append(str).append(" ");
        
        return strB.toString().trim();        
    }
    
    public static void main(String[] args)
    {
    	String ans = reverseWords("Hi    kk");
    	print(ans);
    }
    
    private static void print(String s){
    	System.out.println(s);
    }
   
}