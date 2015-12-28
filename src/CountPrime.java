import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CountPrime {
    /*
     * Description:

Count the number of prime numbers less than a non-negative number, n.    
     */
public int countPrimes(int n) {
   boolean[] isPrime = new boolean[n];
   for (int i = 2; i < n; i++) {
      isPrime[i] = true;
   }
   // Loop's ending condition is i * i < n instead of i < sqrt(n)
   // to avoid repeatedly calling an expensive function sqrt().
   for (int i = 2; i * i < n; i++) {
      if (!isPrime[i]) continue;
      for (int j = i * i; j < n; j += i) {
         isPrime[j] = false;
      }
   }
   int count = 0;
   for (int i = 2; i < n; i++) {
      if (isPrime[i]) count++;
   }
   return count;
}

    public int countPrimes1(int n) {
        int count = 0;
        Set<Integer> hs = new HashSet<>();
        
        if(n >= 2){
            count++;
            hs.add(2);
        }
        if(n >= 3){
          count++;  
          hs.add(3);
        } 
        
        for(int i=5;i <= n; i+=2)
        {
           //if(isDividedByPrimes(i,hs)) continue;
            if(isPrime(i,hs))
                count++;
        }
        
        return count;
    }
    
    //u wont get even numbers
    public boolean isPrime(int n, Set<Integer> hs){
        int count=0;
       // for(int i=2; i <= n/2 ; i++){
       
       Iterator<Integer> it = hs.iterator();
       int next = 0;
       while(it.hasNext() && next * next <= n){
           next = it.next();
           if(n % next == 0) return false;
       }
       
        for(int i=2; i * i <= n && !hs.contains(i); i++){
            if(n % i == 0) return false;
        }
        
        if(count == 0){
            hs.add(n);
            return true;
        }
        else return false;
    }
}