import java.util.*;

public class AllSubSets {
	 /*
	Given a set of distinct integers, nums, return all possible subsets.

	Note:
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If nums = [1,2,3], a solution is:
	    */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstSet = new ArrayList<>();
        result.add(firstSet);
        Arrays.sort(nums);
        recur(nums, result);
        
        return result;
    }
    
    private static void recur(int[] nums, List<List<Integer>> res)
    {
        if(nums == null) return;
            List<List<Integer>> tempo = new ArrayList<>();
            
            for(List<Integer> li : res){
                List<Integer> li_1 = new ArrayList<Integer>();
                li_1.addAll(li);
                li_1.add(nums[0]);
                tempo.add(li_1);
            }
            res.addAll(tempo);
            
        if(nums.length > 1) recur(Arrays.copyOfRange(nums,1,nums.length),res);
        else recur(null,res);
    }
    
    
}