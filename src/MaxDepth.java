/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
 Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int lht = maxDepth(root.left);
        int rht = maxDepth(root.right);
        
        return Math.max(rht, lht)+1;
    }
}