
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
 222. Count Complete Tree Nodes
Total Accepted: 23296 Total Submissions: 100164 Difficulty: Medium

Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes {
    
    // the first ting n mind is to do it log n way by taking leftmoost ad rightmost and if they are of equal ht
    //ans is 2^(level+1) -1 and if they are not equal do (count(rooot.left)+count(root.right)+1 at each level until roots null which will be 0(n)) so worst case its o(n) and best case is o(log n)
    
    //But having a complete binary tree property, we can be sure that all nodes have proper values ecept the last level, so we begin a logn approach wherein u count the levels and take sum of all nodes until the last before level and write a log n method to count the nodes in the last level
    //we take the roots left and traverse till the last level on the rightside and if the nodes are present, it is 2^level-1 nodes present so far + countLastLevel(root.right,levels-1)
    //if the element at that location is null, then we do countLAstLevel(root.left,levelSeen-1);
    //base case is if ht is 0 and root is present,return 1 else if roots null return 0;
    //0(log n) solution
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return 1;
        TreeNode curr = root;
        int sumOfNodes = 0,ht = 0;
        
        while(curr.left != null){
            sumOfNodes += 1 << ht;
            ht++;
            curr = curr.left;
        }
        
        return sumOfNodes + countLastLevel(root, ht);
    }
    
    // base case such that is 0 for last level, handle just that.
    public int countLastLevel(TreeNode root, int ht)
    {
        if(root == null && ht==0) return 0;
        else if(root != null && ht==0)return 1;
        
        int sum=0;
        
        TreeNode element = root.left;
        int height = 0;
        
        while(height < ht-1)
        {
            element = element.right;
            height++;
        }
        
        if(element != null) sum = 1 << height;
        
        if(element != null) return sum + countLastLevel(root.right,ht-1);
        else return countLastLevel(root.left,ht-1);
    }    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
