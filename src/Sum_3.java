import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;





public class Sum_3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans  = new ArrayList<List<Integer>>();
        
        for(int i=0;i<nums.length-2;i++){
            int firstNum = nums[i];
            int negate = -firstNum;
            int start = i+1;
            int end = nums.length - 1;
            
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            while(start < end){
                if(nums[start]+nums[end]==negate){
                    List<Integer> li = new ArrayList<Integer>();
                    li.add(nums[i]);
                    li.add(nums[start]);
                    li.add(nums[end]);
                    
                    Collections.sort(li);
                    ans.add(li);
                    
                    start++;
                    end--;
                }
                else if(nums[start]+nums[end] < negate){
                    start++;
                }
                else if(nums[start]+nums[end] > negate){
                    end--;
                }
                
                //to avoid duplicates
                while(end > start && i!=start-1 &&nums[start]==nums[start-1]){
                    start++;
                }
                
                while(end > start && end != nums.length-1&& nums[end]==nums[end+1]){
                    end--;
                }
                
            }
        }
        
         return ans;
    }
}