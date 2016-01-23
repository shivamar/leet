
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
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is 
defined as a binary tree in which the depth of the two subtrees 
of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    
    public boolean isBalanced(TreeNode root) {
        int ht = isBalancedHt(root);
        
        if(ht == -1) return false;
        else return true;
    }
    
    public int isBalancedHt(TreeNode root) {
        if(root == null) return 0;
        
        int rht = isBalancedHt(root.right);
        int lht = isBalancedHt(root.left);
        
        //processing
        if(rht == -1 || lht == -1) return -1;
        int diff = rht - lht;
        if(diff < 0){
            diff = diff*-1;
        }
        if(diff > 1) return -1;
        
        return Math.max(rht,lht)+1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}


