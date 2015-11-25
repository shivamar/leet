
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;



public class ZigZagBinaryTraversal {	
	
	 public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<Integer> currLevel = new ArrayList<Integer>();
	        List<List<Integer>> answer = new ArrayList<List<Integer>>();
	        
	        if(root == null) return answer;	        		   
	        
	        Stack<TreeNode> st1 = new Stack<TreeNode>();
	        Stack<TreeNode> st2 = new Stack<TreeNode>();
	        
	        st1.push(root);
			boolean bo = true;        

	        Stack<TreeNode> input = st1;
	        Stack<TreeNode> output = st2;
	       // st1.push(root);			
	        
	        while(!st2.isEmpty() || !st1.isEmpty())
	        {
				
				if(bo && st1.isEmpty()) 
				{						
					answer.add(currLevel);
					currLevel = new ArrayList<Integer>();           				
					bo = false;
				}

				if(!bo && st2.isEmpty())
				{					
					answer.add(currLevel);
					currLevel = new ArrayList<Integer>();           				
					bo = true;
				}

				if(bo)
				{
					input  = st1;
					output = st2;
			     		
			    }
	            else 
				{							
					input  = st2;
					output = st1;
			    }
		
			   TreeNode r = input.pop();                       
	           currLevel.add(r.val);	
	        if(output == st2){   
			   if(r.left != null)	output.push(r.left);
			   if(r.right != null)	output.push(r.right);
	        }
	        else
	        {
	        	if(r.right != null)	output.push(r.right);
	        	if(r.left != null)	output.push(r.left);
	        }
	        
	        }
	        
	        if(bo && st1.isEmpty()) 
			{						
					answer.add(currLevel);
					currLevel = new ArrayList<Integer>();           				
					bo = false;
			}

			else if(!bo && st2.isEmpty())
				{					
					answer.add(currLevel);
					currLevel = new ArrayList<Integer>();           				
					bo = true;
				}
				

		return answer;		
	 }
	 
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		List<List<Integer>> answer = zigzagLevelOrder(root);
		
		for(List<Integer> a : answer)
	    {
	    	for(int val : a)
	    	{
	    		System.out.print(val+" ");
	    	}
	    	System.out.println();
	    }
		
	}

}
