import java.util.HashSet;
import java.util.Set;


public class Sudoku {
	
	private int counter=0;
	
	public static void main(String[] args)
	{		
		String[] bo = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		Sudoku s = new Sudoku();
		char[][] chArr = s.toCharArr(bo);		
		s.solveSudoku(chArr);
		System.out.println(s.counter);
	}
	    
	public char[][] toCharArr(String[] arr){
        char[][] chArr = new char[arr.length][arr.length];
		for(int i=0;i<arr.length;i++)
        {
			String str = arr[i];
			
			for(int ilen=0; ilen < str.length(); ilen++)
			{
				chArr[i][ilen] = str.charAt(ilen);
			}
        }
		
		return chArr;
    }
	
	   public char toChar(int i){
	        return (char)(i+48);
	    }
	    public char toChar(char i){
	        return i;
	    }
	    
	    //back track if a selected variable does not work when going to next level of selecting correct variables in sudoku
	    public boolean solveSudokuReturn(char[][] board) {
	    	counter++;
	    	
	         for(int row=0; row < 9; row++)
	        {
	            for(int col=0;col < 9;col++)
	            {
	                
	                if(board[row][col] == '.')
	                {
	                    Set<Character> setOfProbableValues = getProbableValues(row,col,board);
	                    
	                    for(int val=1;val<=9;val++)
	                    {
	                        if(setOfProbableValues.contains(toChar(val)))
	                        {
	                            board[row][col]=toChar(val);
	                            
	                            if(!solveSudokuReturn(board)) board[row][col]='.';	                           //if this number causes a false return value in the future
	                            else return true;
	                        }
	                    }
	                   
	                    	return false;
	                }
	                
	            }	           
	        }
	         
	        return true;
	    }
	    
	    private Set<Character> getProbableValues(int row, int col, char[][] board){
	        
	        Set<Character> set = new HashSet<>();
	        
	        //add all numbers to set
	        for(int i=1;i<10;i++)
	        {
	            set.add(toChar(i));
	        }
	        
	        //remove number if present in box var
	        for(int j=row/3 * 3; j < ((row/3)*3) + 3; j++)
	        {
	            for(int k=col/3 * 3; k < ((col/3)*3) + 3; k++)
	            {
	               if(board[j][k] != '.' && set.contains(toChar(board[j][k]))){
	                  set.remove(toChar(board[j][k]));
	               }
	            }
	        }
	        
	        //remove number if present in col var
	         for(int k=0; k < 9; k++)
	            {
	               if(board[k][col] != '.' && set.contains(toChar(board[k][col]))){
	                  set.remove(toChar(board[k][col]));
	               }
	            }
	        
	        //remove number if present in row var
	        for(int l=0; l < 9; l++)
	            {
	               if(board[row][l] != '.' && set.contains(toChar(board[row][l]))){
	                  set.remove(toChar(board[row][l]));
	               }
	            }
	            
	            return set;
	    }
	        
	    public void solveSudoku(char[][] board) {
	        
	        if(board == null || board[0].length < 2) return;
	       solveSudokuReturn(board);
	    }
	    
	    
	    /**
	     * 
	     * 
	     *  public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9 for each cell
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell
                            
                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int i, int j, char c){
        //Check colum
        for(int row = 0; row < 9; row++)
            if(board[row][j] == c)
                return false;
                
        //Check row
        for(int col = 0; col < 9; col++)
            if(board[i][col] == c)
                return false;
                
        //Check 3 x 3 block
        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for(int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                if(board[row][col] == c)
                    return false;
        return true;
    }
	     */
	    
	}
