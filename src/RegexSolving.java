public class Solution {
    public boolean isMatch(String s, String p) {
        int pptr=0,sptr=0;
        
        while(sptr < s.length() && pptr < p.length())
        {
            if(pptr+1 < p.length() && p.charAt(pptr+1)=='*'){
                Character zeroOrMore = p.charAt(pptr);
                
                if(zeroOrMore == '.'){
                //if theres no more character after *
                  if(!(pptr+2 < p.length()))
                    return true;
                  else
                  {
                    //get the next should be matching character after * from p
                    //if u can reach the next character, keep going in the outer while loop
                    Character nextChar = p.charAt(pptr);
                    
                    while(sptr < s.length() && s.charAt(sptr) != nextChar)
                    {
                        sptr++;
                    }
                  }
                } 
                else 
                {
                    while(sptr < s.length() && s.charAt(sptr) == zeroOrMore)
                        sptr++;
                        
                    if(pptr+2 < p.length() && p.charAt(pptr+2) == p.charAt(pptr))
                    {
                        int countOfPostChar = 0;
                        
                        int ptr = pptr+2; 
                        
                        while(ptr < p.length() && zeroOrMore == p.charAt(ptr)){
                            countOfPostChar++;   
                            ptr++;
                        }
                        
                        int temp = countOfPostChar;
                        //check if countOfPostChar characters are present in S
                        while(countOfPostChar > 0 && (sptr-countOfPostChar) > 0 && 
                        zeroOrMore == s.charAt(sptr-countOfPostChar)){
                            countOfPostChar--;
                        }
                        
                        if(countOfPostChar != 0) return false;
                        else pptr = pptr + temp;
                    }
                }
                                    
                sptr--;
                pptr++;
            }
            else  if(p.charAt(pptr)=='.'){
                // sptr++;
                // pptr++;
            }
            else if(p.charAt(pptr) != s.charAt(sptr)){
                return false;
            }
            
            pptr++;
            sptr++;
        }
        
        //if one is not fully parsed, match hasnt been there
        if(sptr < s.length() || pptr < p.length()){
            return false;
        }
        
        return true;
    }
}