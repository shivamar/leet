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


/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * @author Shiva
 *
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        
        Queue<TreeNode> currPointer = q1;
        Queue<TreeNode> targetPointer = q2;
        List<Integer>levelArr = new ArrayList<>();
        q1.add(root);
        
        while(!currPointer.isEmpty())
        {
            TreeNode node = currPointer.remove();
            
            //add val to level array and add children to targetQ
            levelArr.add(node.val);
            if(node.left != null) targetPointer.add(node.left);
            if(node.right != null) targetPointer.add(node.right);
            
            //switch when currPointer is empty and add levelArr to result and initialise new levelArr 
            if(currPointer.isEmpty()){
                Queue<TreeNode> temp = targetPointer;
                targetPointer = currPointer;
                currPointer = temp;
                
                result.add(levelArr);
                levelArr = new ArrayList<Integer>();
            }
        }
        
        return result;
    }
}