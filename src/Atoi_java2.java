
public class Atoi_java2 {
	
    public int myAtoi(String str) {
        if(str==null || str.equals("")) return 0; // null or empty string corner case
        str = str.trim(); //white space corner case
        
        int len = str.length();
        int num = 0, ans = 0, i = 0;
        boolean flag = false;
        
        char charac = str.charAt(i);
         
         if(charac == '+') i++;
         
         if(charac == '-') {
             flag = true; //negative number corner case
             i++;   
         }
        
        for(;i < len;i++)
        {
            charac = str.charAt(i);
            if(charac >= '0' && charac <= '9') num = charac - '0';
            else break;
              
          if((ans > Integer.MAX_VALUE/10 && !flag) || (ans == Integer.MAX_VALUE/10 && !flag && num > 7)) return Integer.MAX_VALUE;                 //MAX value corner case
          if((ans > Integer.MAX_VALUE/10 && flag) || (ans == Integer.MAX_VALUE/10 && flag && num > 8)) return Integer.MIN_VALUE;
          
              ans = ans * 10 + num;
        }
        
        if(flag == true) ans *= -1;
        
        return ans;
    }
}
