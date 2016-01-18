
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

	//  Definition for a binary tree node.


public class IterativePreorder {	 
	    
	    public void inorderTraversalRecur(TreeNode root, List<Integer> li)
	    {
	        if(root == null) return;
	        li.add(root.val);
	        inorderTraversalRecur(root.left,li);	            
	        inorderTraversalRecur(root.right,li);
	    }
	    

        //process the node and then process the righht and left in such a way that left is processed after right
        //so left gets to be printed before right as it is a stack
	    public static List<Integer> preorderTraversal(TreeNode root) {
	        Deque<TreeNode> st = new ArrayDeque<>();
	        List<Integer> li = new ArrayList<>();
	        
	        if(root == null) return li;
	        TreeNode curr = root;
	        st.push(curr);
	        
	        while(!st.isEmpty())
	        {
	            curr  = st.pop();
	            li.add(curr.val);
	            
	            if(curr.right != null)
	                st.push(curr.right);
	                
	            if(curr.left != null)
	                st.push(curr.left);
	            
	        }
	        
	        return li;
	    }
	    
		public static void main(String[] args)
		{
			TreeNode tr = new TreeNode(1);
			tr.left = new TreeNode(2);
			tr.right = new TreeNode(3);
			tr.right.left = new TreeNode(6);
			tr.right.right = new TreeNode(7);
			tr.left.left = new TreeNode(4);
			tr.left.right = new TreeNode(5);
			
			List<Integer> liu = preorderTraversal(tr);
			
			System.out.println(liu.toString());
		}	

}
