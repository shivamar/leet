import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import CTCILibrary.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum2 {
            
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
         if(root == null) 
          return new ArrayList<List<Integer>> ();
        
        if(sum == root.value && root.left == null && root.right == null){
            List<Integer> arr_list = new ArrayList<Integer>();
            arr_list.add(root.value);
            
            List<List<Integer>> li = new ArrayList<List<Integer>> ();
            li.add(arr_list);
            return li;
        }
                
         List<List<Integer>> left = pathSum(root.left,sum-root.value);
         List<List<Integer>> right = pathSum(root.right,sum-root.value);
         
         boolean isRightExists = false;
         boolean isLeftExists = false;
         if(!right.isEmpty()) {
             isRightExists = true;
             Iterator it = right.iterator();
             
             while(it.hasNext())
             {
                List<Integer> arr_right = (ArrayList<Integer>)it.next();
                arr_right.add(0,root.value);
             }
            //  for(ArrayList<Integer> arr_right : right){
            //      arr_right.add(root.value);
            //  }
         }
         
         
         if(!left.isEmpty()){
             isLeftExists = true;
             
            //  Iterator it = left.iterator();
             
            //  while(it.hasNext())
            //  {
            //     List<Integer> arr_left = (ArrayList<Integer>)it.next();
            //     arr_left.add(root.val);
            //  }
             int i=0;
             for(List<Integer> arr_left : left){
                 arr_left.add(0,root.value);
                 left.set(i,arr_left);
                 i++;
             }
         }
         
         if(isLeftExists && isRightExists) 
         return right.addAll(left) ? right : null;
         else if(isLeftExists)
         return left;
         else if(isRightExists)
         return right;
         else return new ArrayList<List<Integer>> ();
    }
    
    public static void main(String[] args)
    {
    	PathSum2 p = new PathSum2();
    	TreeNode tr = new TreeNode(10);
    	tr.add(3);
    	tr.add(4);    	
    	tr.add(5);
    	tr.add(12);
    	
    	List<List<Integer>> ans  = p.pathSum(tr,22);
    	
    	for(List<Integer> li_ans : ans)
    		System.out.println(li_ans.toString());
    	
    }
}
