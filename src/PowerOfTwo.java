
public class PowerOfTwo {
/*
 * check if given number is power of 2 ??
 */
	public PowerOfTwo() {
		// TODO Auto-generated constructor stub
	}
    
    public static void main(String[] args){
    	System.out.println(Math.pow(2, 31) + " " + isPowerOfTwo1((int)Math.pow(2, 30)));
    }
    
    public static boolean isPowerOfTwo1(int n) {
        if(n < 1) return false;
        if(n==1 || n==2 || n==4) return true;  //math problem for n = 2 power 31 n 30 erroneously math.log(n)/math.log(2)
        double a = (double) n/4; // shows a decimal		
                
        double ans = (double) Math.log(n) / Math.log(2);
        
        if(ans % 1 == 0) return true;
        
        return false;
    }
    
    //using bit manipulators 
    //bug: does not work for 2^31 and 32
    public static boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        if((n > 0) && (n & n-1) == 0) return true; // if positive, number unary-and with number - 1;        
        //if((n & -n) == n) return true; // number unary-and with its negative equals number 
        
        //if(Integer.bitCount(n) == 1) return true;  //bitCount method specific to java
        
        return false;
    }
    
}
