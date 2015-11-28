/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
public class Search2DMatrix {
	// do a binary search and convert the mid number to matrix format col,row using a function
	//log(n) - complexity
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        if(M==1 && N == 1) return matrix[0][0] == target;
        
        int start=0,end=(M*N)-1,mid=0;
        
        while(end>=start){
            mid=(start+end)/ 2;
            int[] rowCol = getRowCol(M,N,mid);
            int ans = matrix[rowCol[0]][rowCol[1]];
            if(ans==target){
                return true;
            }
            else if(ans < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        
        return false;
    }
    
    public int[] getRowCol(int M,int N,int normalisedVal)
    {
        int row = normalisedVal / N;
        int col = normalisedVal % N;
        int[] rowCol = {row,col};
        
        return rowCol;
    }
}