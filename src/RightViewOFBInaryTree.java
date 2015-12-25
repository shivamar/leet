import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
public class RightViewOFBInaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>();
        if(root == null) return ans;
        
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.add(root);
        boolean first=true;
        while(!q1.isEmpty() || !q2.isEmpty())
        {
            Queue<TreeNode> q = null;
            Queue<TreeNode> res = null;  
            if (first){
                q = q1;
                res = q2;
            }
            else{
                q = q2;
                res = q1;
            }
            TreeNode curr = q.remove();
            
            if(curr.left != null) res.add(curr.left);
            if(curr.right != null) res.add(curr.right);
            
            if(q.isEmpty()){
              ans.add(curr.val);
              first = !first;
            } 
        }
        
        return ans;
    }
}