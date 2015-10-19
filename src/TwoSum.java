import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class TwoSum {

	public TwoSum() {
		// TODO Auto-generated constructor stub
	}

	
	 public static int[] twoSum(int[] nums, int target) {

		   Map<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		   int[] ans = new int [2];
	        
	        for(int i=0;i<nums.length;i++)
	        {
	            int cur = nums[i];
	            
	            if(hmap.containsKey(cur)){
	              
	                ans[0] = hmap.get(cur);
	                ans[1] = i + 1;
	                
	                break;
	            }
	            
	            int rem = target - nums[i];
	            hmap.put(rem,i+1);
	        }
	        
	        return ans;
	 }
	        
//	        Set<Integer> hs = new HashSet<Integer>();
//	        boolean isAnswerPresent = false;
//	        int[] result = new int[2];
//	        
//	        for(int i=0;i < nums.length; i++)
//	        {
//	            if(!hs.contains(nums[i]))
//	                hs.add(nums[i]);
//	        }
//	        
//	        for(int i=0,j=0,rem_ans=0;i < nums.length; i++)
//	        {
//	            int rem = target - nums[i];
//	            
//	            if(hs.contains(rem) && !isAnswerPresent) 
//	            {
//	                isAnswerPresent = true;
//	            
//	                result[j] = i;
//	                j++;
//	                rem_ans = rem;
//	            }
//	            
//	            if(nums[i]==rem_ans)  result[j] = i;
//	        }
//	        
//	        return result;
//	        
//	    }
	 
	 public static void main(String[] args)
	 {
		 int [] ans =  {1,2,3,4,5};
		 int [] res = twoSum(ans, 6);
		 
		 for(int i : res) System.out.println(i);
	 }
}
