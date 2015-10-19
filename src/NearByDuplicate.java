import java.util.HashMap;


public class NearByDuplicate {

	public NearByDuplicate() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Given an array of integers and an integer k, 
	 * find out whether there there are two distinct indices i and j in the array 
	 * such that nums[i] = nums[j] and the difference between i and j is at most k.
	 */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> ha = new HashMap<Integer, Integer>();
         int num = 0;
         
        for(int i=0;i<nums.length;i++)
        {
           num = nums[i];
            if(ha.get(num) == null)
                ha.put(nums[i],i);
                
            else
            {
                int j = ha.get(num);
                if((i - j) <= k) return true; 
                ha.put(nums[i],i);
            }
        }
        
        return false;
    }

}
