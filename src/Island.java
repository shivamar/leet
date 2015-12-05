
/*
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
 */
public class Island {
    public int numIslands(char[][] grid) {
        if(grid==null) return 0;
        if(grid.length==0) return 0;
        int count=0;
        int[][]visited = new int[grid.length][grid[0].length];
        
        // watch out for un-visited islands and start bfs when u see one
        //mark all other (unvisted dry areas) as visited
        for(int i=0; i < visited.length; i ++)
        {
            for(int j=0; j < visited[0].length;j++)
            {
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    count++;
                    visited[i][j] = 1;
                    bfs(i, j, grid, visited);
                }
                
                if(visited[i][j] == 0)
                    visited[i][j]=1;
            }
        }
        return count;
    }
    
    public void bfs(int i,int j,char[][] grid, int[][] visited)
    {
        Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
        ArrayList<Integer> li = new ArrayList<Integer>();
        li.add(i);li.add(j);
        
        q.add(li);
        while(!q.isEmpty())
        {
            li = q.remove();
            addAdjacentUnvisitedIslandsToQ(li.get(0), li.get(1), q, visited, grid);
        }
    }
    
    //get all neighbouring marked islands which are un-visited given an island-spot i,j and add it to q
    //mark as visited all the unvisted places u search
    public void addAdjacentUnvisitedIslandsToQ(int i,
                                            int j,
                                            Queue<ArrayList<Integer>> q, 
                                            int[][] visited,
                                            char[][] grid)
    {
      int boundaryX =  grid.length;
      int boundaryY = grid[0].length;
      
      int[] x={1,0,-1,0};
      int[] y={0,1,0,-1};
      
      for(int r=0;r < 4;r++)
      {
          int adjX = i + x[r];
          int adjY = j + y[r];
          
          if(adjX > -1 && adjX < boundaryX && adjY > -1 && adjY < boundaryY)     
          {
            if(visited[adjX][adjY]==0 && grid[adjX][adjY] == '1')
            {
                ArrayList<Integer> li = new ArrayList<Integer>();
                li.add(adjX);
                li.add(adjY);
                q.add(li);
                
                visited[adjX][adjY] = 1;
            }
            else if(visited[adjX][adjY]==0)
                visited[adjX][adjY] = 1;
          }
      }
    }
    
}