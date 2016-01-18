import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//  Definition for a binary tree node.
 
public class IterativeInorder {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> li = new ArrayList<Integer>();
        inorderTraversalIterative(root, li);
        return li;
    }
    
    public void inorderTraversalRecur(TreeNode root, List<Integer> li)
    {
        if(root == null) return;
        inorderTraversalRecur(root.left,li);
            li.add(root.val);
        inorderTraversalRecur(root.right,li);
    }
    
    //the node is processed after all the left childs are processed, 
    //and after it is processed, all its right childs are processed the same way
    public static void inorderTraversalIterative(TreeNode root, List<Integer> li)
    {
      if(root == null) return;
      Stack<TreeNode> st = new Stack<>();
      TreeNode curr = root;
      //st.push(curr);
            
      while(!st.isEmpty() || curr != null)
      {
    	  if(curr != null)
    	  {
    		  st.push(curr);
    		  curr = curr.left;
    	  }
    	  else
    	  {
    		  curr = st.pop();
    		  li.add(curr.val);
    		  curr = curr.right;
    	  }
      }
      
    }
//      
//      boolean isNew = true;
//      
//      while(!st.isEmpty())
//     {
//        curr = st.peek();
//        printThis(curr.val + " 35");
//        printThis(li.toString());
//            
//        if(curr.left != null && isNew)
//        {
//            st.push(curr.left);
//        }
//        else 
//        {
//            TreeNode r = st.pop();
//            li.add(r.val);
//            isNew = false;
//            
//            if(r.right != null)
//            {
//                isNew = true;  
//                st.push(r.right);
//            }
//            else 
//            	isNew = false;
//        }
//    }
//      
//    }
    
    static void printThis(TreeNode tr)
	{
	   // System.out.println(tr.val);
	}
	
	static void printThis(String tr)
	{
		System.out.println(tr);
	}
	
	static void printThis(int tr)
	{
	    //System.out.println(tr);
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
		
		List<Integer> liu = inorderTraversal(tr);
		
		System.out.println(liu.toString());
	}	
}