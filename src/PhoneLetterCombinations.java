
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneLetterCombinations {
	
	/*
	Given a digit string, return all possible letter combinations that the number could represent.

			A mapping of digit to letters (just like on the telephone buttons) is given below.



			Input:Digit string "23"
			Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
			Note:
			Although the above answer is in lexicographical order, your answer could be in any order you want.
			
			*/
    
private static HashMap<Character,String> pN = new HashMap<Character,String>();
    
    private static void pop(){
        pN.put('2',"abc");
        pN.put('3',"def");
        pN.put('4',"ghi");
        pN.put('5',"jkl");
        pN.put('6',"mno");
        pN.put('7',"pqrs");
        pN.put('8',"tuv");
        pN.put('9',"wxyz");        
    }
    
    public static List<String> letterCombinations(String digits) {        
        
        String in = digits;
        List<String> li = new ArrayList<String>();
        if(in.length()==0) return li;
        
        for(int i=0;i < in.length();i++)
        {
            Character num = in.charAt(i);
            
            li.add(pN.get(num));
        }
        
        
        String str = li.get(0);
        List<String> new_li = li.subList(1, li.size());
        List<String> answers = new ArrayList<String>();
        
        for(int i=0;i<str.length();i++)
        {
        	genOutput(String.valueOf(str.charAt(i)),new_li,answers);
        }
        
        
        for(String an : answers)
        {
        	System.out.println(an);
        }
        
        return answers;
        
    }

	private static void genOutput(String str, List<String> li, List<String> ans) {
		
		if(li==null || li.size() == 0)
		{
		    ans.add(str);
		    return;
		}
		String nStr = li.get(0);
		if(li.size() == 1)
		{							
			for(int i=0;i<nStr.length();i++)
			{
				String result = str.concat(String.valueOf(nStr.charAt(i)));
				ans.add(result);				
			}			
			return;
		} 
		
		
		for(int i=0;i<nStr.length();i++)
		{
			genOutput(str+nStr.charAt(i), li.subList(1, li.size()), ans);
		}
	}
//		String nStr = li.get(0);
//		
//		if(li.size() == 1)
//		{							
//			for(int i=0;i<nStr.length();i++)
//			{
//				String result = str.concat(String.valueOf(nStr.charAt(i)));
//				ans.add(result);				
//			}			
//			return;
//		}   			
//		
//		for(int i=0;i<nStr.length();i++)
//		{
//			genOutput(str+nStr.charAt(i), li.subList(1, li.size()), ans);
//		}							
//	}
	
	public static void main(String[] args)
	{
		pop();
		letterCombinations("23");		
	}        
  }