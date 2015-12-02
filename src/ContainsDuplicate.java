import java.util.Arrays;
import java.util.HashSet;


public class ContainsDuplicate {
	
	//O(nlogn)
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length==0)
        return false;
    Arrays.sort(nums);
    for (int i=0; i<nums.length-1; i++)
        if (nums[i]==nums[i+1])
            return true;
    return false;
    
    }
    
    
    
    //O(n)
    public boolean containsDuplicateO_n(int[] nums) {             
    HashSet<Integer> hs = new HashSet<>();
         for(int num : nums)
         {
             if(hs.contains(num)){
                 return true;    
             }
            
             hs.add(num);
         }
        
         return false;
     }
}
