
public class Atoi_Java {

	public class Solution {
	    public int myAtoi(String str) {
	        if(str==null || str.equals("")) return 0; // null or empty string corner case
	        str = str.trim(); //white space corner case
	        
	        int len = str.length();
	        int num = 0, ans = 0, i = 0;
	        boolean flag = false;
	        
	         String a = String.valueOf(str.charAt(i));
	        // String a = str.substring(i,i+1);
	             if(a.equals("+")) i++;
	             
	             if(a.equals("-")) {
	                 flag = true; //negative number corner case
	                 i++;   
	             }
	        
	        for(;i < len;i++)
	        {
	             a = String.valueOf(str.charAt(i));
	            // a = str.substring(i,i+1);
	            // if(a.equals(".")) break; //real number corner case
	             
	             try{
	              num = Integer.parseInt(a);
	              
	              if((ans > Integer.MAX_VALUE/10 && !flag) || (ans == Integer.MAX_VALUE/10 && !flag && num > 7)) return Integer.MAX_VALUE; //MAX value corner case
	              if((ans > Integer.MAX_VALUE/10 && flag) || (ans == Integer.MAX_VALUE/10 && flag && num > 8)) return Integer.MIN_VALUE;
	              ans = ans * 10 + num;
	             }
	             catch(Exception e){
	                 break;
	             }
	        }
	        
	        if(flag == true) ans *= -1;
	        
	        return ans;
	    }
	}
}
