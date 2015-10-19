
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class InverseBinary
{
	/*
	Invert a binary tree.
 
     4
   /   \
  2     7
 / \   / \
1   3 6   9
 
to
 
     4
   /   \
  7     2
 / \   / \
9   6 3   1
	*/
	public static TreeNode invertTree(TreeNode root) {
 
        Stack<TreeNode> st = new Stack();
        st.push(root);
 
        while(!st.isEmpty())
        {
            TreeNode tr = st.pop();
 
            if(tr.left != null) st.push(tr.left);
            if(tr.right != null) st.push(tr.right);
 
            TreeNode temp = tr.left;
            tr.left = tr.right;
            tr.right = temp;
        }
 
        return root;
    }
 
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		TreeNode tr = new TreeNode(1);
		tr.left = new TreeNode(2);
		tr.right = new TreeNode(3);
 
		printInOrder(tr);
 
		tr = invertTree(tr);
 
		printInOrder(tr);
	}
 
	public static void printInOrder(TreeNode root)
	{
		if(root == null) return;
		printInOrder(root.left);
			System.out.println(root.val);
		printInOrder(root.right);
	}
}
 
class TreeNode
{
	TreeNode right;
	TreeNode left;
	int val;
 
	public TreeNode(int v)
	{
		val = v;
	}
}
