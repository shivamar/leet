public class BitwiseAndNumberRange {	
	
	/*
	 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

		For example, given the range [5, 7], you should return 4. 
	 */	
    public int rangeBitwiseAnd(int m, int n) {
        
        if(Math.min(m,n) > 2147483647 ) return 0;
        if(m == n) return m;
        if(!check(m,n)) return 0;
        
        int result = m;
        for(int i=m+1; i < n+1; i++)
        {
            result = result & i;    
        }
        
        return result;
    }
    
    public boolean check(int m, int n){
        while(n!=0 && m !=0){
            n = n >> 1;
            m = m >> 1;
        }
        
        if(m == 0 && n == 0) return true;
        else return false;
    }
}