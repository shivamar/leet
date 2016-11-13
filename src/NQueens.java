import java.util.*;


public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
                
        ArrayList<String> solution = new ArrayList<String>();
        solveNQueensUtil(n, 0, 0, solution,solutions); 
        
        return solutions;
    }
    
    //stop if u reach n th row and add sol to solutions
   // for each row and col ceck if its a vaid space , 
   //if so, mark it as Q in solution and pass it on to next row; and then mark it as . and go on to next space
   //else go to next col
    public void solveNQueensUtil(int n, int col, int row, List<String> solution, List<List<String>> solutions)
    {
        if(row == n) {
            solutions.add(solution);
        }
        
        for(int i=0;i<n;i++)
        {
            if(isValid(n, i, row, solution))
            {
                List<String> solutionWithThisRow = new ArrayList<>();
                solutionWithThisRow.addAll(solution);
                String thisRowStr = getString(i,n);
                solutionWithThisRow.add(thisRowStr);
                
                solveNQueensUtil(n, 0, row+1, solutionWithThisRow, solutions);
            }
            else
            {
                solution.add(".");
            }
        }
        
        
    }
    
    private boolean isValid(int n, int i, int row, List<String> solution) {		
		return false;
	}

	public String getString(int queenChar, int totalChar)
    {
        StringBuilder strB = new StringBuilder(totalChar);
        
        for(int i=0;i<totalChar;i++)
        {
            if(i != queenChar)
            strB.append(".");
            else strB.append("Q");
        }
        
        return strB.toString();
    }
}
