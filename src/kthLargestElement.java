import java.util.Arrays;

public class kthLargestElement {
		
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);        
        return nums[nums.length-k];
    }
}
