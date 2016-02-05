import java.util.*;

public class GenerateParanthesis
{
    public static List<String> generateParenthesis(int n)
    {
        Set<String> set = new HashSet<String>();
        List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> li =  new ArrayList<String>();
        li.add("");
        
        res.add(li);
        
        for(int i=1; i < n+1;i++)
        {
             ArrayList<String> latest = res.remove(res.size()-1);    
             ArrayList<String> newList = new ArrayList<String>();
            for(String str: latest)
            {
                String str1 = "()"+str;
                if(!set.contains(str1)){
                	set.add(str1);                    
                	newList.add(str1);
                }
                for(int ch=0;ch < str.length();ch++)
                {
                 if(str.charAt(ch)==')'){
                        String g = str.substring(0,ch)+"()"+str.substring(ch,str.length());
                            
                        if(!set.contains(g)){
                        	set.add(g);                    
                        	newList.add(g);
                        }
                 }
               }
           }
           
           res.add(newList);
        }
        
        return res.get(0);
    }
   
    
    public static void main(String[] args)
    {
      List<String> li = generateParenthesis(3);
      
      System.out.println(li.toString());
    }
}
