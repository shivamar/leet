
public class PalindromeNumber {
	
	/*
	 * Determine whether an integer is a palindrome. Do this without extra space.
	 */
	// int may overflow so u might have to use long!
	//which is bad coz it depends on language
    public boolean isPalindrome(int x) {
        int r = x,rev=0;
       
        while(r > 0){
            rev = rev * 10 + (r % 10);
            r /=10;
        }
        
        return rev == x;
    }
    
    // no extra space
    //better than pre coz u just check first n last digit 
    //language independent
    public boolean isPalindrome_(int x) {
    	  if (x < 0) return false;
    	  int div = 1;
    	  while (x / div >= 10) {
    	    div *= 10;
    	  }        
    	  while (x != 0) {
    	    int l = x / div;
    	    int r = x % 10;
    	    if (l != r) return false;
    	    x = (x % div) / 10;
    	    div /= 100;
    	  }
    	  return true;
    	}
}
