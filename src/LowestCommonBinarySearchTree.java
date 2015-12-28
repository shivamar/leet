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
 *  Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes v and w as the 
lowest node in T that has both v and w as descendants
 (where we allow a node to be a descendant of itself).” 
 */
public class LowestCommonBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //null check
        if(root==null) return null;
        //santitise if p is always less
        if(p.val > q.val) return lowestCommonAncestor(root, q, p);
        
        //if root is between p and q return root
        if(root.val >= p.val && root.val <= q.val){
            return root;
        } 
        
        //do a binary search ..if root is less than the smallest search on right
        //else search oon left , if nothing return null
        if(root.val < p.val) return lowestCommonAncestor(root.right, p,q);
        if(root.val > q.val) return lowestCommonAncestor(root.left,p,q);
        
        return null;
    }
}