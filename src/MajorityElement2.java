import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    
    /**
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
     * **/
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> li = new ArrayList<Integer>();
        if(nums == null) return li;
   
        int candidate1=0,candidate2=1;
        int count1=0,count2=0;
        
        for(int num :  nums)
        {
            if(candidate1==num){
                count1++;
                continue;
            }
            else if(candidate2==num)
            {
                count2++;
                continue;
            }
            else if(count2 == 0)
            {
                count2=1;
                candidate2=num; 
            }
            else if(count1 == 0)
            {
            candidate1=num;
            count1=1;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
    for(int num :  nums)
    {
        if(candidate1 == num) count1++;
       else if(candidate2 == num) count2++;
    }
    
    if(count1 > nums.length/3) li.add(candidate1);
    if(count2 > nums.length/3) li.add(candidate2);
    
    return li;
    }
}