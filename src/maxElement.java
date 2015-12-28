import java.util.HashMap;

public class maxElement {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int count=0,maxCount=0,ans=0;
        for(int a : nums)
        {    
            if(maxCount > nums.length/2) return ans;
            if(hmap.containsKey(a))
            {
                count = hmap.get(a)+1;
                hmap.put(a,count);
                
                if(count > maxCount) {
                    ans=a;   
                    maxCount = count;   
                }
            }
            else
             hmap.put(a,1);
        }
        
        return ans;
    }
}