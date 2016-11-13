import java.util.Arrays;


public class ThreeSumClosest {
	    //3 pointer solution
	    public int threeSumClosest(int[] nums, int target) {
	        int first=0,second=1,third=nums.length-1,sum=nums[second]+nums[third]+nums[first],result=sum;
	        Arrays.sort(nums);
	        for(first=0;first<nums.length-2;first++)
	        {
	            second=first+1;
	            third=nums.length-1;
	            while(second < third)
	            {
	                sum = nums[second]+nums[third]+nums[first];
	                if(sum==target)
	                {
	                    return target;
	                }
	                if(sum > target)
	                {
	                    third--;    
	                }
	                else
	                {
	                    second++;
	                }
	                
	                if(Math.abs(target-sum) < Math.abs(target-result))
	                {
	                    result = sum;
	                }
	            }
	        }
	        
	        return result;
	    }
	}