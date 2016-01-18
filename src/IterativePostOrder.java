import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //see narasimha karumanchi  fr ref
public class IterativePostOrder {
	
	//two pointer approach..have a prev and curr node
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> li = new ArrayList<>();        
        if(root == null) return li;        
        Stack<TreeNode> st = new Stack<>();
        
        TreeNode curr = root,prev =null;
        st.push(curr);
        while(!st.isEmpty())
        {
            curr = st.peek();
            if(prev==null || prev.left == curr || prev.right == curr)
            {
                if(curr.left != null)
                {                   
                    st.push(curr.left);
                }
                else if(curr.right != null)
                {
                    st.push(curr.right);
                }
                else
                {                 
                    li.add(curr.val);  st.pop();
                }
            }
            else if(prev == curr.left)
            {
                if(curr.right != null)
                {                  
                    st.push(curr.right);
                }
                else 
                {                     
                    li.add(curr.val);  st.pop();    
                }
            }
            else if(prev == curr.right)
            {                
                li.add(curr.val);  st.pop();
            }
        
            prev = curr;
        }
		
		return li;		
	}
	
	static void printThis(TreeNode tr)
	{
	   // System.out.println(tr.val);
	}
	
	static void printThis(String tr)
	{
	    //System.out.println(tr);
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
		
		List<Integer> liu = postorderTraversal(tr);
		
		System.out.println(liu.toString());
	}	
}