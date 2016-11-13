/**Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.


 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumOfLeftLeaves {
    
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        if(isLeaf(root.left)) return root.left.val+sumOfLeftLeaves(root.right);
        else return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    
    public boolean isLeaf(TreeNode root){
        if(root == null) return false;
        if(root.left == null && root.right == null) return true;
        return false;
    }
    
    public int sumOfLeftNodes123(TreeNode root) {
        if(root==null) return 0;
        
        return root.left != null ? root.left.val + sumOfLeftLeaves(root.right) + sumOfLeftLeaves(root.left) : sumOfLeftLeaves(root.right) + sumOfLeftLeaves(root.left); 
    }
}