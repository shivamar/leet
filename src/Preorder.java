import java.util.*;

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
 Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,2,3]. 
 */
public class Preorder {
    public List<Integer> preorderTraversal(TreeNode root) {
            if(root == null) return new ArrayList<Integer>();
            
            List<Integer> li = new ArrayList<Integer>();
            li.add(root.val); 
            
            li.addAll(preorderTraversal(root.left));
            li.addAll(preorderTraversal(root.right));
            
            return li;
    }
}