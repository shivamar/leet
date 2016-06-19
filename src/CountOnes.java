public class CountOnes {
    public int countDigitOne(int n) {
        if(n < 1) return 0;
        int tenthPow = findPowerOfTen(n);
        
        int result=countDigitOne(n, tenthPow, 0);
        return result;
    }
    
    private int findPowerOfTen(int n){
        int count=0;
        while((n = n/10) > 0){
            count++;
        }
        return count+1;
    }
    
    //For every place in a digit, one occurs 10^currTenthPower-1 times every 10^(currentTenthPow).
    //so calculate how many times [ 10^(currentTenthPow) ] are present in n n apply frmula [Math.pow(10, lowerPow) * prevQuo;]4
    // and add the remainder of ones on that position
    public int countDigitOne(int n, int currTenthPow, int result)
    {
        if(currTenthPow == 0) return result;
        
        int lowerPow = currTenthPow-1;
        int prevQuo = n / (int) Math.pow(10, currTenthPow);
        int totalOnesInCurrPosition = (int) Math.pow(10, lowerPow) * prevQuo;
       
        int remainder = n % (int) Math.pow(10, currTenthPow);
        int currPositionNumber =  remainder/ (int)Math.pow(10, lowerPow);
        totalOnesInCurrPosition += (currPositionNumber > 1) ? (1 * Math.pow(10, lowerPow) ) : (currPositionNumber == 1 ? (remainder % Math.pow(10, lowerPow)) +1 : 0) ;
         
        result+=totalOnesInCurrPosition;
        
        return countDigitOne(n, currTenthPow-1,result);
    }
    
}