
public class ItoA {
	
	private static String IntToString(int number)
	{
		final int ASCII_ZERO = 48;
		
		 boolean negative = false;
	         if(number < 0) {
	            negative = true;
	            number = 0 - number;
	         }

		  if(number >= 0 && number <= 9) {
	          char temp = (char) (ASCII_ZERO + number);
	          if(!negative) {
	                return String.valueOf(temp);
	          }

	          char[] ch =  new char[] { '-', temp };
		  return String.valueOf(ch);
	        }

		char[] digits = new char[12];

		int digitPosition = 0;

		while(number > 0){
	           int remainder = number % 10;
	            number = number / 10;

	            digits[digitPosition++] = (char) (ASCII_ZERO + remainder);
		}
		
		if(negative) {
	            digits[digitPosition++] = '-';
	        }
		
		for(int i = 0; i < digitPosition / 2; i++) {
	            char temp = digits[i];
	            digits[i] = digits[digitPosition - i - 1];
	            digits[digitPosition - i - 1] = temp;
	        }

		return String.valueOf(digits);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(IntToString(122121212));

	}

}
