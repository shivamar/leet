
public class CountAllPalindromesInString {

	/*
	/*
	 * Complete the function below.
	 * count the pal in a string
	 */
	 static int count_palindromes(String S) {
	    if(S==null) return 0;
	    int count = S.length(),len = count;
	    if(count==0) return 0;
	    
	     int l = 0,r = 0; 
			//odd palindrome		
			for(int i=0; i < len; i++)
			{
				l = i==0 ? 0 : i-1;
				r = i== len-1 ? len-1 : i + 1;
				
				while(l >= 0 && r <= len - 1 && S.charAt(l) == S.charAt(r)){
					count++;
					
					l--;
					r++;
				}
				
				//even palindromes
				if(i <= len - 2) 
				{	
					if(S.charAt(i) == S.charAt(i+1)){	
	                    count++;
						 l = i==0 ? 0 : i -1;
						 r = i == len - 1 ? len - 1 :  i + 2;
						while(l >= 0 && r <= len-1 && S.charAt(l) == S.charAt(r)){
							count++;
							
							l--;
							r++;
						}
					}	
				}
			}
		
	    return count;
	}

}

