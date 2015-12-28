import java.util.*;


/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
    The solution set must not contain duplicate quadruplets.

    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)

 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> hs = new HashSet<>();
        if(nums==null || nums.length == 0) return ans;
        Arrays.sort(nums);
        
        for(int i=0;i < nums.length;i++)
        {
            for(int j=nums.length-1;j > i+2;j--){
                int k = i+1;
                int l = j-1;
                
                while(l > k){
                    int sum = nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum > target){
                        l--;
                    }
                    else if(sum < target){
                        k++;
                    }
                    else if(sum == target) {
                        List<Integer> li = new ArrayList<Integer>();
                        
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[k]);
                        li.add(nums[l]);
                        
                        Collections.sort(li);
                        
                        if(!hs.contains(li)){
                            hs.add(li);
                            ans.add(li);    
                        }
                        
                        l--;
                        k++;
                    }
                    
                }
            }
        }
        
        
        return ans;
    }
}