import java.util.*;

/***
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.


 * @author Shiva
 *
 */
public class CourseSchedule {
    //form an adjacency list
    // get indegrees of vertexes
    //in a while loop
    //iterate all nodes , add indegree-0 vertices to result and remove the
    //vertex from all other vertices indirection list and update the indegree as well
	
	//if all the courses are present in result list, then course schedule is possible
	//else u are having a circular reference so this schedule is not possible
    
    static class Vertex
    {
        int name;
        boolean visited=false;
        public int indirection=0;
        public Set<Integer> indirectionSet = new HashSet<Integer>();
        public Set<Integer> outDirectionSet = new HashSet<Integer>();
        
        public Vertex()
        {
            
        }
        
        public Vertex(int name)
        {
            this.name = name;
        }
        
        @Override
        public String toString()
        {
            return "name:"+name+" indirection:"+indirection;
        }
    }
    
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 1) return true;
        if(prerequisites == null || prerequisites.length < 1) return true;
        
        List<Vertex> vertexList = new ArrayList<Vertex>(numCourses);
        
        for(int i=0;i<numCourses;i++)
        {
            vertexList.add(new Vertex(i));
        }
        
        Set<String> sample = new HashSet<String>();
        
        for(int[] preReq : prerequisites)
        {
        	if(!sample.contains(preReq[0]+"&"+preReq[1])){
        		sample.add(preReq[0]+"&"+preReq[1]);
        		
        		vertexList.get(preReq[0]).indirection++;
	            vertexList.get(preReq[0]).indirectionSet.add(preReq[1]);
	            
	            vertexList.get(preReq[1]).outDirectionSet.add(preReq[0]);
        	}
        }
        
        
        List<Vertex> result = new ArrayList<Vertex>();
        boolean canFinish = true;
        
        while(canFinish)
        {
            canFinish=false;
            
            Iterator<Vertex> itr = vertexList.iterator();
            while(itr.hasNext())
            {
                Vertex vertex = itr.next();
                
                //remove the 0 indirection vertex from indirectionSet of all the outdirection vertices
                if(vertex.indirection == 0 && vertex.visited != true)
                {
                    canFinish=true;
                    for(int outVertex : vertex.outDirectionSet)
                    {
                        vertexList.get(outVertex).indirectionSet.remove(vertex.name);   
                        vertexList.get(outVertex).indirection--;
                    }
                    
                    //add it to the result queue and remove from the vertex list
                    result.add(vertex);
                    vertex.visited=true;
                }                             
            }
            
        }
        
        // System.out.println(result.toString());
        if(result.size() == numCourses) return true;
        else return false;
    }
    
    //test the method can finish
    public static void main(String[] args)
    {      
    	int[][] arr = {{1,0}};
    	boolean ans  = canFinish(2, arr); 
    	
//    	if(ans) System.out.println("true");
//    	else  System.out.println("false");
    	
    	///[[5,8],[3,5],[1,9],[4,5],[0,2],[1,9],[7,8],[4,9]]
    	int[][] arr1 = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
    	ans  = canFinish(10, arr1);
    	
    	if(ans) System.out.println("true");
    	else  System.out.println("false");
    }
    
}