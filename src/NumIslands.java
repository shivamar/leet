/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
 *
 */

/*

//Union Find Solution - 10ms
public class NumIslands {
		
	int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};
	public int numIslands(char[][] grid) {  
	    if (grid == null || grid.length == 0 || grid[0].length == 0)  {
	        return 0;  
	    }
	    UnionFind uf = new UnionFind(grid);  
	    int rows = grid.length;  
	    int cols = grid[0].length;  
	    for (int i = 0; i < rows; i++) {  
	        for (int j = 0; j < cols; j++) {  
	            if (grid[i][j] == '1') {  
	                for (int[] d : distance) {
	                    int x = i + d[0];
	                    int y = j + d[1];
	                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {  
	                        int id1 = i*cols+j;
	                        int id2 = x*cols+y;
	                        uf.union(id1, id2);  
	                    }  
	                }  
	            }  
	        }  
	    }  
	    return uf.count;  
	}

}


class UnionFind {
    int[] father;  
    int m, n;
    int count = 0;
    UnionFind(char[][] grid) {  
        m = grid.length;  
        n = grid[0].length;  
        father = new int[m*n];  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (grid[i][j] == '1') {
                    int id = i * n + j;
                    father[id] = id;
                    count++;
                }
            }  
        }  
    }
    public void union(int node1, int node2) {  
        int find1 = find(node1);
        int find2 = find(node2);
        if(find1 != find2) {
            father[find1] = find2;
            count--;
        }
    }
    public int find (int node) {  
        if (father[node] == node) {  
            return node;
        }
        father[node] = find(father[node]);  
        return father[node];
    }
}

 * 
 */

//*** test solution
public class NumIslands {
	//test case
	public static void main(String[] args)
	{
		NumIslands nu = new NumIslands();
		char[][] grid = {{'1','1','1'},{'1','0','0'},{'1','1','1'}};
		int ans = nu.numIslands(grid);
		System.out.println(ans);
	}
	
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length == 0) return 0;
        UnionFind uF = new UnionFind(grid);
        
        for(int row=0;row < grid.length;row++)
        {
            for(int col=0;col < grid[0].length;col++)
            {
                if(grid[row][col] == '1')
                {
                     //System.out.println(row+" start "+ col);
                    doUnionOfAllNeighbours(row,col,grid,uF);
                }
            }
        }
        
        return uF.count;
    }
    
    int[][] distance = {{0,-1},{0,1},{-1,0},{1,0}};
    public void doUnionOfAllNeighbours(int row, int col, char[][] grid, UnionFind uF) {
        int calNum = (row * grid[0].length) + col;
        
        for(int[] arr : distance)
        {
            int newRow = row+arr[0];
            int newCol =col+arr[1];
            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length)
            {
                if(grid[newRow][newCol] == '1'){
                   uF.union(calNum, newCol+(grid[0].length*newRow));
                }
            }
        }
    }
}

class UnionFind{
   // int[][] grid;
    int[] oneDGrid; // u need a one d grid to denote each location uniquely -- find esp finds parent of the curr element in the group 
    
    public int count=0;
    public UnionFind(char[][] grid)
    {
        int rows= grid.length;
        int cols=grid[0].length;
        
        for(int row=0;row < rows;row++)
        {
            for(int col=0;col < cols;col++)
            {
                if(grid[row][col] == '1')
                {
                    count++;
                }
            }
        }        
        this.oneDGrid = new int[rows*cols];
        for(int i=0; i < oneDGrid.length; i++)
        {
            oneDGrid[i]=i;
        }
    }
    
    //finds the parent
    public int find(int currElement){
        int parent = oneDGrid[currElement];
        if( parent == currElement){
            return currElement;
        }        
        oneDGrid[currElement] = find(parent);        
        return oneDGrid[currElement];
    }
    
    
    //union of 2 sets so the first set points to second set for its parent
    public void union(int one,int second)
    {
        int firstRoot = find(one);
        int secRoot = find(second);

        if(firstRoot ==  secRoot) return;    /*
        //secondRoot is ranked higher
        if(firstRoot != one){
            oneDGrid[second]= firstRoot;
            count--;
        } //firstRoot is ranked Higher
        else if(secRoot != second){
            oneDGrid[one]= secRoot;
            count--;
        } //either of them have same ranks
        else {
            oneDGrid[second]= firstRoot;
            count--;
        }
        */
        
         oneDGrid[second]= firstRoot;
            count--;      
        return;
    }

}
/**
 * 3 ms
 * public class Solution {

private int n;
private int m;

public int numIslands(char[][] grid) {
    int count = 0;
    n = grid.length;
    if (n == 0) return 0;
    m = grid[0].length;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++)
            if (grid[i][j] == '1') {
                DFSMarking(grid, i, j);
                ++count;
            }
    }    
    return count;
}

private void DFSMarking(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
    grid[i][j] = '0';
    DFSMarking(grid, i + 1, j);
    DFSMarking(grid, i - 1, j);
    DFSMarking(grid, i, j + 1);
    DFSMarking(grid, i, j - 1);
}
}

**/


