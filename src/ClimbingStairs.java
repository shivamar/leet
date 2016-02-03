public class ClimbingStairs {
    /*
    You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    */
    
    /*
    there are 1 way of reaching step 1 and 2 ways of reaching step 2
    -ways to reach (n-1)step + ways to reach (n-2)steps = reaching step n;
    */
    public int climbStairs(int n) {
        if(n==0 || n == 1 || n==2) return n;
        
        int first = 1;
        int second = 2;
        
        int result=0;
        for(int i=3;i < n+1;i++)
        {
            result = first+second;
            
            first=second;
            second=result;
        }
        
        return result;
    }
}
