public class ProductOfArrayExceptSelf {
    //calculate the sum and note down how many 0s occur
    //if more than one occur, all result will be 0s but if only one occur, calculate the sum without that 0 and result will be 000..sum..0000 inplace of that 0.
    public int[] productExceptSelf(int[] nums) {
        int sum=1,count=0;
        for(int n : nums)
        {
            if(n==0) count++;
            else
                if(count < 2)
                    sum=n*sum;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] != 0){
                 if(count > 0) nums[i] = 0;
                 else
                 nums[i] = sum / nums[i];
            }
            else {
                nums[i] = (count < 2) ? sum : 0;
            }
            
        }
        
        return nums;
    }
}