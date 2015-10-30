
public class PalindromeNumber {
	
	/*
	 * Determine whether an integer is a palindrome. Do this without extra space.
	 */
    public boolean isPalindrome(int x) {
        int r = x,rev=0;
       
        while(r > 0){
            rev = rev * 10 + (r % 10);
            r /=10;
        }
        
        return rev == x;
    }
}
