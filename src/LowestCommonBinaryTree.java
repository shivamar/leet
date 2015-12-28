/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonBinaryTree {
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) return null;
    if(root == p) return p;
    if(root == q) return q;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if(left == null && right == null) return null;
    if(left != null && right == null) return left;
    if(left == null && right != null) return right;
    return root;
}
    
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        boolean[] isPresent = {false,false};
//        return lowestCommonAncestor(root, p, q, isPresent);
//    }
//    
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, boolean[] isPresent)
//    {
//        if(root==null) return null;
//        
//        if(!isPresent[0])
//        if(root.val == p.val){
//        TreeNode right = lowestCommonAncestor(root.right,p,q,isPresent);
//        TreeNode left = lowestCommonAncestor(root.left,p,q,isPresent);
//        
//        isPresent[0]=true;
//        if(isPresent[0]==true && isPresent[1]==true){
//            return root;
//        }
//        else return null;
//         
//        }
//        
//        if(!isPresent[1])
//        if(root.val == q.val){
//        TreeNode right = lowestCommonAncestor(root.right,p,q,isPresent);
//        TreeNode left = lowestCommonAncestor(root.left,p,q,isPresent);
//            isPresent[1]=true;
//            
//        if(isPresent[0]==true && isPresent[1]==true){
//            return root;
//        }
//        else return null;
//        
//        }
//        
//        TreeNode right = lowestCommonAncestor(root.right,p,q,isPresent);
//        TreeNode left = lowestCommonAncestor(root.left,p,q,isPresent);
//        
//        if(right != null || left != null ){
//            return (right != null) ? right : left;
//        }
//        
//        if(isPresent[0]==true && isPresent[1]==true){
//            return root;
//        }
//        
//        return null;
//    }
}