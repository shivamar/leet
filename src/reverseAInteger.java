
public class reverseAInteger {
	
public int reverse(int x) {
        
        if(x < 10 && x > 0) return x;
        
       // if(x == 1534236469 || x == 2147483647) return 0;
        
        if(x > Integer.MAX_VALUE) return 0;
        
        int num = 10;
        int ans = 0;
        boolean flag = false;
        
        if(x < 0) {
            flag = true;
            x = -1 * x;
        }
        
         while(x > 0)
	        {
	            if(ans > Integer.MAX_VALUE/10) return 0; // overflow or underflow checker!!!!
	            ans = (ans*10) + x % num;
	            
	            x = x / 10;
	        }
        
        if(flag) ans = ans * -1;
        
        return ans;
    }
	
	    public static void main(String[] args)
	    {	  	    
	    	reverseAInteger r = new reverseAInteger();
	    	int ans = r.reverse(-2147483412);
	    	
	    	System.out.println(ans); // 2147483647 is max
	    }
}
