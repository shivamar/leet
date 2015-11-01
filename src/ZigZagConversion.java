
public class ZigZagConversion {
	
    public static String convert(String s, int numRows) {
        int len = s.length();
        
        //edge case
        if(len < 2 || numRows == 1) return s;
        
        if(numRows == 2){
            int str = 0;
            String oddStr = "";
            String evenStr = "";
            while(str < len){
                if(str % 2 == 0)
                    evenStr += s.charAt(str);
                else
                    oddStr+=s.charAt(str);
                
                str++;
            }
            
//            int minCnt = Math.min(oddStr.length(),evenStr.length());
//            String ans  = "";
//            int cnt = 0;
//            
//            while(cnt < minCnt){
//                ans += String.valueOf(evenStr.charAt(cnt))+oddStr.charAt(cnt);
//                cnt++;
//            }
//            
//            if(oddStr.length() == evenStr.length()) return ans;
//            
//            char residue = 'a';
//            if( evenStr.length() == minCnt)
//                residue = oddStr.charAt(cnt);
//            else residue = evenStr.charAt(cnt);
//            ans = ans + residue;
            
            return evenStr+oddStr;
        }
        
        
        int barrier = numRows + (numRows - 2);
        
        int numColPerBarrier = (barrier / numRows) + (barrier % numRows);
        int numCols = calculateColumns(len, barrier,numColPerBarrier,numRows);
        
        int[][] table = new int[numRows][numCols];
        for(int i=0; i < numRows;i++){
            for(int j=0; j < numCols; j++)
            {
                table[i][j] = 0;    
            }
        }
            
        int stringIndex = 0,R=-1,C=0;
        
        while(stringIndex < len){
            
            for(int i=1; i <= barrier; i++){
                if(stringIndex == len) break;
                if(i <= numRows){
                	R++;
                	table[R][C] = (int) s.charAt(stringIndex);                    
                }
                else {
                    R--;
                    C++;
                    table[R][C] = (int)s.charAt(stringIndex);
                    
                    //barrier end so reset the R,C pointers
                    if(i == barrier) {
                        R = -1;
                        C++;
                    }
                }
                stringIndex++;
            }
        }
        
        
        //iterate the matrix to form the String
        String ans = "";
        
        for(int i=0; i < numRows;i++)
            for(int j=0; j < numCols; j++)
            {
                if(table[i][j] != 0){
                    ans += (char)table[i][j];
                }
            }
            
        return ans;
    }
    
    public static int calculateColumns(int wordLength, int barrier,int numColPerBarrier,int numRows){
        int div = wordLength / barrier;
        int rem = wordLength % barrier;
        
        int numCol = div * numColPerBarrier + (rem <= numRows ? 1 : 1 + (rem % numRows) );
        
        return numCol;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	
    	String ans = convert("ABC", 2);
    	
    	System.out.println(ans);
    			
	}
    
}

