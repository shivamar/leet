
public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String countAndSay(int n) {
        if(n < 1) return "0";
        if(n==1) return "1";
        
        return count("1",n-1);
    }
    
    public String count(String val, int level)
    {
        if(level == 0) return val;
        
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        
        int count=1;
        
        int charCount=0;
        char prevChar = val.charAt(charCount);
        for(;charCount < val.length();charCount++)
        {
            if(prevChar == val.charAt(charCount)){
                count++;
            }
            else{
                sb.append(count).append(String.valueOf(prevChar)); //append to answer string builder
                
                count=1;  //reset count of currChar to 1
                prevChar = val.charAt(charCount); //reset prevChar
            }
        }
        
        sb.append(count).append(String.valueOf(prevChar));
        
        return count(sb.toString(), level-1);
    }
}