
public class MaxBinaryAnyWayTreePathSum {

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
	  * 124. Binary Tree Maximum Path Sum   QuestionEditorial Solution  My Submissions
	Total Accepted: 80544
	Total Submissions: 325379
	Difficulty: Hard
	Contributors: Admin
	Given a binary tree, find the maximum path sum.

	For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

	For example:
	Given the below binary tree,

	       1
	      / \
	     2   3
	Return 6.

	**/
	
	    int maxSum;
	    public int maxPathSum(TreeNode root) {
	        maxSum = Integer.MIN_VALUE;
	        maxPathSumR(root);
	        return maxSum;
	    }
	    
	    public int maxPathSumR(TreeNode root) {
	        if(root == null) return 0;
	        int l = maxPathSumR(root.left);
	        int r = maxPathSumR(root.right);
	        
	        int runningSum = Math.max(Math.max(l,r) + root.val, root.val);
	        maxSum = Math.max(Math.max(l+r+root.val,runningSum),maxSum);
	       
	        return runningSum;
	    }
	}



