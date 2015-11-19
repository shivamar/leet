
public class LongestSubstringPalindrome {

	//o(n^2) Solution	
	public static String findLongestSubStringPalindrome_n2(String inputStr)
	{
		String longestPalindrome = "";
		
		int l = 0,r = 0; 
		int len = inputStr.length();
		//odd palindrome		
		for(int i=0; i < len; i++)
		{

		    //super optimization - string size - 100 and if longest is 50 and if i is at 80, 
			//len-i is 20 and longest possible palindrome at i=80 is only 2 (len-i) = 40 
			//so stop iterating any more.
		    if(longestPalindrome.length()  >= 2 * (len - i)) return longestPalindrome;
		    
			l = i==0 ? 0 : i-1;
			r = i== len-1 ? len-1 : i + 1;
			
			while(l >= 0 && r <= len - 1 && inputStr.charAt(l) == inputStr.charAt(r)){
				if(r+1-l > longestPalindrome.length()){
					longestPalindrome = inputStr.substring(l,r+1);				
				}
				
				l--;
				r++;
			}
			
			//even palindromes
			if(i <= len - 2) 
			{	
				if(inputStr.charAt(i) == inputStr.charAt(i+1)){	
					 l = i==0 ? 0 : i -1;
					 r = i == len - 1 ? len - 1 :  i + 2;
					while(l >= 0 && r <= len-1 && inputStr.charAt(l) == inputStr.charAt(r)){
						if(r-l+1 > longestPalindrome.length()){
							longestPalindrome = inputStr.substring(l,r+1);
						}
						
						l--;
						r++;
					}
				}	
			}
		}
		
		///even palindromes
		//check every 2 letters
//		for(int i=0; i < len-1;i++)
//		{
//			//String str = inputStr.substring(l,r);
//			if(inputStr.charAt(i) == inputStr.charAt(i+1)){	
//				 l = i==0 ? 0 : i -1;
//				 r = i == len - 1 ? len - 1 :  i + 2;
//				while(l >= 0 && r <= len-1 && inputStr.charAt(l) == inputStr.charAt(r)){
//					if(r-l+1 > longestPalindrome.length()){
//						longestPalindrome = inputStr.substring(l,r+1);
//					}
//					
//					l--;
//					r++;
//				}
//			}			
//		}
				
		return longestPalindrome;
	}
	
	//o(n^3 solution)
	public static String findLongestSubstringPalindrome(String inputStr){		
	//generate all substrings
	//check if each substring is a palindrome
	
	int len = inputStr.length();
	String longestPalindrome = "";
	
	for(int i=0; i < len; i++)
		for(int j=i+1; j <= len; j++)
		{
			String str = inputStr.substring(i,j);
			
			if(isPalindrome(str)){
				if(longestPalindrome.length() < str.length()) longestPalindrome = str;
			}			
		}
	return longestPalindrome;
				
	}
	
	private static boolean isPalindrome(String str) {
		// TODO Auto-generated method stub
		
		int l = 0;
		int r = str.length();
		
		while(r > l)
		{
			if(str.charAt(l) == str.charAt(r-1)){
				r--;
				l++;
			}
			else return false;			
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(findLongestSubstringPalindrome("01malayalam"));
		
		System.out.println(findLongestSubStringPalindrome_n2("3988malaalam"));

	}

}