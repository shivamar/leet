public class Pow {
    //Implement pow(x, n). 
    public double myPow(double x, int n) {
        
        //edge cases ; x =0,1,-1 ; n= negative powers
        if(x==-1) return (n%2 == 0) ? 1:-1;
        if(x == 0.0 || x ==1.0) return x;
        if(n < 0) 
        {
            x = 1/x;
            n *= -1;
        }
        
        double ans=1;
        for(int i=0;i<n;i++)
        {
            ans = ans * x;
            if(ans == 0.0) return ans;
        }
        
        return ans;
    }
}