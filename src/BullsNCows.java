
public class BullsNCows {
/*
 * You are playing the following Bulls and Cows game with your friend: 
 * You write a 4-digit secret number and ask your friend to guess it, each time your friend guesses a number, 
 * you give a hint, the hint tells your friend how many digits are in the correct positions (called "bulls") and how 
 * many digits are in the wrong positions (called "cows"), 
 * for those digits not found in secret number u dont increment cow or bull
 * your friend will use those hints to find out the secret number	
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str =  getHint("1","0");
		System.out.println(str);
	}
	/*
	 * since the number of digits is between 0 to 9
	 * u can use counting sort intuituion
	 * and do the problem in single pass 
	 */
    public static String getHint(String secret, String guess) {
        int bull=0,cow=0,i=0;
        int[] cnt = new int[10];
        
        while (i < secret.length())
        {    
            if (secret.charAt(i) == guess.charAt(i))
                bull++;
            else{
                if(++cnt[Integer.valueOf(String.valueOf(secret.charAt(i)))] <= 0) cow++;
                if(--cnt[Integer.valueOf(String.valueOf(guess.charAt(i)))] >= 0) cow++;
            }
            i++;
        }
        
        return bull+"A"+cow+"B";        
        }
}
