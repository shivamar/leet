public class MySquareRoot {
    public int mySqrt(int a) {

    //also check if a==0 or a==1 because in these two cases sqrt(a) = a
    if(a==0 || a==1) return a;

    //now start the core part of the code
    double precision = 0.0000000000001;//define the precision, so we stop when precision is achieved
    
    double start = 0;
    double end = a;
    
    //we define these two start/end values because usually 0<sqrt(a)<a
    //however, if a<1; then 0<a<sqrt(a)
    if(a < 1)
        end = 1;

    //define a loop to continue if the precision is not yet achieved
    while(end-start>precision)
    {
       // System.out.println("end-start = "+(end-start));
      //  System.out.println("precision = "+precision);

    double mid = (start+end)/2;
    double midSqr = mid*mid;
    
    if(midSqr==a)
        return (int)mid;//we find the exact sqrt value!
    else if(midSqr<a)
        start = mid;//we shift our focus to bigger half
    else 
        end = mid;//shift focus to smaller half
    }

    
    //if we did not find exact sqrt value, we return the approxiated value with the defined precision
    return (int) start;
    
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MySquareRoot m = new MySquareRoot();
		System.out.println(m.mySqrt(101));		
	}

}
